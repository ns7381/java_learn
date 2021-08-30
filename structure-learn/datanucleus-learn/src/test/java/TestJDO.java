import org.junit.Test;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.datastore.JDOConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestJDO {
    @Test
    public void testSqlMode() throws SQLException {
        PersistenceManager pm = getPF().getPersistenceManager();

        pm.currentTransaction().begin();
        assert pm.currentTransaction().isActive(); // must be inside tx together with queries
        executeNoResult(pm, "SET @@session.sql_mode=ANSI_QUOTES");

        Transaction tx = pm.currentTransaction();

        Query query = null;
        // Run a self-test query. If it doesn't work, we will self-disable. What a PITA...
        String selfTestQuery = "select \"DB_ID\" from \"test1\"";
        try {
            query = pm.newQuery("javax.jdo.query.SQL", selfTestQuery);
            Object ret = query.execute();
            System.out.println(ret);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            if (query != null) {
                query.closeAll();
            }
        }
    }

    public PersistenceManagerFactory getPF() {
        Properties properties = new Properties();
        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");
        properties.setProperty("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:mysql://localhost:3360/xxx?useSSL=false");
        properties.setProperty("javax.jdo.option.ConnectionUserName", "root");
        properties.setProperty("javax.jdo.option.ConnectionPassword", "root");
        return JDOHelper.getPersistenceManagerFactory(properties);
    }

    public void executeNoResult(PersistenceManager pm, final String queryText) throws SQLException {
        JDOConnection jdoConn = pm.getDataStoreConnection();
        Statement statement = null;
        try {
            statement = ((Connection) jdoConn.getNativeConnection()).createStatement();
            statement.execute(queryText);
        } finally {
            if (statement != null) {
                statement.close();
            }
            jdoConn.close(); // We must release the connection before we call other pm methods.
        }
    }
}
