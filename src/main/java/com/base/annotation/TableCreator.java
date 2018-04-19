package com.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 17/1/23.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"com.nathan.test.annotation.Member"};
        if (args.length < 1) {
            System.out.println("args: annotated classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                if (anns[0] instanceof SqlString) {
                    SqlString sqlString = (SqlString) anns[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR("+sqlString.value()+")"+getConstraints(sqlString.constrains()));
                }
            }
            StringBuilder createCmd = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCmd.append("\n " + columnDef + ",");
            }
            String tableCreate = createCmd.substring(0, createCmd.length() - 1) + ")";
            System.out.println("Table Creation Sql for "+className+" is :\n"+tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
