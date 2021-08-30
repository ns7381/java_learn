package com.nathan.learn.calcite;

import com.nathan.learn.calcite.mock.HrSchema;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Programs;
import org.apache.calcite.tools.RelBuilder;
import org.junit.Test;

import java.util.List;

public class TestAlgebra {
    @Test
    public void testAlgebra() {
        final RelBuilder builder = RelBuilder.create(config().build());
        final RelNode node = builder
                .scan("emps")
                .aggregate(builder.groupKey("deptno"),
                        builder.count(false, "C"),
                        builder.sum(false, "S", builder.field("salary")))
                .filter(
                        builder.call(SqlStdOperatorTable.GREATER_THAN,
                                builder.field("C"),
                                builder.literal(10)))
                .build();
        System.out.println(RelOptUtil.toString(node));
    }

    public static Frameworks.ConfigBuilder config() {
        final SchemaPlus rootSchema = Frameworks.createRootSchema(true);
        ReflectiveSchema schema = new ReflectiveSchema(new HrSchema());
        rootSchema.add("hr", schema);
        return Frameworks.newConfigBuilder().defaultSchema(rootSchema.getSubSchema("hr"));
    }
}
