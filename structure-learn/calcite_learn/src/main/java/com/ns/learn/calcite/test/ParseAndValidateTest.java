package com.ns.learn.calcite.test;

import org.apache.calcite.config.Lex;
import org.apache.calcite.jdbc.CalcitePrepare;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.server.CalciteServerStatement;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用自定义的 csv 源，解析校验 SQL ，遍历 RelNode 树，统计其中一些信息并打印
 */
public class ParseAndValidateTest {

    public static void main(String[] args) {
        String sql = "select * from TEST_CSV.TEST01 as t1 left join TEST_CSV.TEST02 as t2 on t1.NAME1=t2.NAME3";
        String filePath = "/model.json";
        Connection connection = null;
        try {
            connection = CalciteUtil.getConnect(filePath);
            RelRoot root = genRelRoot(connection, sql);
            System.out.println(RelOptUtil.toString(root.rel));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Planner解析，校验，然后生成RelNode，使用mysql的sql语法格式
     */
    public static RelRoot genRelRoot(Connection connection, String sql) throws Exception {
        //从 conn 中获取相关的环境和配置，生成对应配置
        CalciteServerStatement st = connection.createStatement().unwrap(CalciteServerStatement.class);
        CalcitePrepare.Context prepareContext = st.createPrepareContext();
        final FrameworkConfig config = Frameworks.newConfigBuilder()
                .parserConfig(SqlParser.configBuilder().setLex(Lex.MYSQL).build())
                .defaultSchema(prepareContext.getRootSchema().plus())
                .build();
        Planner planner = Frameworks.getPlanner(config);
        RelRoot root = null;
        try {
            SqlNode parse1 = planner.parse(sql);
            SqlNode validate = planner.validate(parse1);
            root = planner.rel(validate);
            RelNode rel = root.rel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return root;
    }

}
