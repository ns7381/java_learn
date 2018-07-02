package com.design.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends JDBCTemplate {
    @SuppressWarnings("unchecked")
    public List<Student> test2(final String sql) throws SQLException, ClassNotFoundException {


        JDBCTemplate jdbcTemplate = new JDBCTemplate();
        return (List<Student>) jdbcTemplate.execute(stmt -> {
            ResultSet rs = stmt.executeQuery(sql);
            List<Student> userList = new ArrayList<Student>();

            Student user = null;
            while (rs.next()) {
                user = new Student();
                user.setId(rs.getInt("id"));
                user.setBirth(rs.getDate("birth"));
                userList.add(user);
            }
            return userList;
        });

    }
}
