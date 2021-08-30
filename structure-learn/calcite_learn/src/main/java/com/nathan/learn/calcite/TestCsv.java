package com.nathan.learn.calcite;

import org.apache.calcite.util.Sources;
import org.junit.Test;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestCsv {
    @Test
    public void test() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            Properties info = new Properties();
            info.put("model", jsonPath("csv_sales"));
            connection = DriverManager.getConnection("jdbc:calcite:", info);
            statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("select * from DEPTS");
            output(resultSet);

//            resultSet =
//                    statement.executeQuery("select * from FEMALE_EMPS");
//            output(resultSet);
        } finally {
            close(connection, statement);
        }
    }

    private String jsonPath(String model) {
        return resourcePath(model + ".json");
    }

    private String resourcePath(String path) {
        return Sources.of(TestCsv.class.getResource("/" + path)).file().getAbsolutePath();
    }

    private void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // ignore
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // ignore
            }
        }
    }

    private void output(ResultSet resultSet)
            throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        final int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1;; i++) {
                System.out.print(resultSet.getString(i));
                if (i < columnCount) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                    break;
                }
            }
        }
    }
}
