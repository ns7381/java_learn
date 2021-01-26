package com.nathan.learn.calcite.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用自定义的 csv 源，查询数据
 */
public class CSVTest {
    public static void main(String[] args) {
        String filePath = "/model.json";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CalciteUtil.getConnect(filePath);
            statement = connection.createStatement();
            String[] strArray = {
                    "select * from TEST_CSV.TEST02",
                    "select NAME3,count(*) as num from TEST_CSV.TEST02 group by NAME3",
                    "select * from TEST_CSV.TEST01 as t1 left join TEST_CSV.TEST02 as t2 on t1.NAME1=t2.NAME3"
            };

            for (String sql : strArray) {
                ResultSet resultSet = statement.executeQuery(sql);
                System.out.println("-------------------------  " +
                        "start sql"
                        + "  -------------------------  ");
                String pretty = JSON.toJSONString(CalciteUtil.getData(resultSet),
                        SerializerFeature.PrettyFormat,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteDateUseDateFormat);
                System.out.println(pretty);
                System.out.println("-------------------------  " +
                        "end sql"
                        + "  -------------------------  ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
