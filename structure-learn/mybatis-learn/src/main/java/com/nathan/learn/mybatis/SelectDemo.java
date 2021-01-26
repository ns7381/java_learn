package com.nathan.learn.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SelectDemo {

    public static void main(String[] args) throws Exception {
        /*
         * 1.加载mybatis的配置文件，初始化mybatis，创建出SqlSessionFactory，是创建SqlSession的工厂
         * 这里只是为了演示的需要，SqlSessionFactory临时创建出来，在实际的使用中，SqlSessionFactory只需要创建一次，当作单例来使用
         */
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));

        //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作
        SqlSession sqlSession = factory.openSession();

        //3.使用SqlSession查询
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("id", 100);
        EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);
        List<Employee> employees = mapper.selectAll();
        System.out.println(employees);
        List<Employee> selectAll = sqlSession.selectList("com.nathan.learn.mybatis.EmployeesMapper.selectAll");
        System.out.println(selectAll);
        Employee result = sqlSession.selectOne("com.nathan.learn.mybatis.EmployeesMapper.selectEmployee", 100);
        System.out.println("员工：" + result);
    }

}