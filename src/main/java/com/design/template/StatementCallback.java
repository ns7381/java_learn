package com.design.template;


import java.sql.SQLException;
import java.sql.Statement;


public interface StatementCallback {
    Object doInStatement(Statement stmt) throws SQLException;
}
