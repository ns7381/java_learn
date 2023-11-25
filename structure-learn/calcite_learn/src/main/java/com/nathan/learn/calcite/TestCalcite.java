package com.nathan.learn.calcite;

import com.nathan.learn.calcite.mock.HrSchema;
import org.apache.calcite.adapter.enumerable.JavaRelImplementor;
import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.adapter.jdbc.JdbcSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.validate.SqlConformance;
import org.apache.calcite.tools.RelBuilder;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestCalcite {

    @Test
    public void testInMemory() throws Exception {
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection =
                DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection =
                connection.unwrap(CalciteConnection.class);
        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        Schema schema = new ReflectiveSchema(new HrSchema());
        rootSchema.add("hr", schema);
//        calciteConnection.setSchema("hr");
        Statement statement = calciteConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select d.deptno, min(e.empid) "
                        + "from hr.emps as e "
                        + "join hr.depts as d "
                        + "  on e.deptno = d.deptno "
                        + "group by d.deptno "
                        + "having count(*) > 1");
        print(resultSet);
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void print(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    /*
CREATE TABLE IF NOT EXISTS `emps`(
   `empid` INT UNSIGNED AUTO_INCREMENT,
   `deptno` INT,
   `name` VARCHAR(100) NOT NULL,
   `salary` float(10,2) NOT NULL,
   `commission` INT,
    PRIMARY KEY ( `empid` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `depts`(
   `deptno` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `deptno` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into emps (`empid`,`deptno`,`name`,`salary`, `commission`) values (100, 10, "Bill", 10000, 1000);
insert into emps (`empid`,`deptno`,`name`,`salary`, `commission`) values (200, 20, "Eric", 8000, 500);
insert into emps (`empid`,`deptno`,`name`,`salary`, `commission`) values (150, 10, "Sebastian", 7000, null);
insert into emps (`empid`,`deptno`,`name`,`salary`, `commission`) values (110, 10, "Theodore", 11500, 250);
insert into depts (`deptno`,`name`) values (10, "Sales");
insert into depts (`deptno`,`name`) values (30, "Marketing");
insert into depts (`deptno`,`name`) values (40, "HR");
*/
    @Test
    public void testJDBC() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection =
                DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection =
                connection.unwrap(CalciteConnection.class);
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Schema schema = JdbcSchema.create(rootSchema, "hr", dataSource,
                null, "test");


        rootSchema.add("hr", schema);
        Statement statement = calciteConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select d.deptno, min(e.empid) "
                        + "from hr.emps as e "
                        + "join hr.depts as d "
                        + "  on e.deptno = d.deptno "
                        + "group by d.deptno "
                        + "having count(*) > 1");
        print(resultSet);
        resultSet.close();
        statement.close();
        connection.close();
    }



}
