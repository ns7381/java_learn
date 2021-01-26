package com.nathan.learn.mybatis;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception
    {

        String sql = "select * from employees where employee_id < ? and employee_id >= ?";
        PreparedStatement st = null;
        ResultSet rs = null;

        long beforeTimeOffset = -1L; //创建Connection对象前时间
        long afterTimeOffset = -1L; //创建Connection对象后时间
        long executeTimeOffset = -1L; //创建Connection对象后时间

        Connection con = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");

        beforeTimeOffset = System.currentTimeMillis();
        System.out.println("before:\t" + beforeTimeOffset);

        con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "louluan", "123456");

        afterTimeOffset = System.currentTimeMillis();
        System.out.println("after:\t\t" + afterTimeOffset);
        System.out.println("Create Costs:\t\t" + (afterTimeOffset - beforeTimeOffset) + " ms");

        st = con.prepareStatement(sql);
        //设置参数
        st.setInt(1, 101);
        st.setInt(2, 0);
        //查询，得出结果集
        rs = st.executeQuery();
        executeTimeOffset = System.currentTimeMillis();
        System.out.println("Exec Costs:\t\t" + (executeTimeOffset - afterTimeOffset) + " ms");

    }
}
