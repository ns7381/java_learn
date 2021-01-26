package com.nathan.learn.design.behavioral.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author nathan
 */
public class JDBCTemplate {

    public Statement getStatement() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.driver");
        con = DriverManager.getConnection("url", "userName", "password");
        return con.createStatement();
    }

    public Object execute(StatementCallback action) throws ClassNotFoundException, SQLException {
        Statement statement = getStatement();
        return action.doInStatement(statement);
    }

}

