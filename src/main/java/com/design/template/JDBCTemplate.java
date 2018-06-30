package com.design.template;

import java.sql.*;


public class JDBCTemplate {

    public Object execute(StatementCallback action) throws ClassNotFoundException, SQLException {
        String url = "";
        String userName = "";
        String password = "";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.driver");
        con = DriverManager.getConnection(url, userName, password);
        st = con.createStatement();
        return action.doInStatement(st);

    }


    public Object query(StatementCallback action) throws SQLException, ClassNotFoundException {
        return execute(action);
    }

}

