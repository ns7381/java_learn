package com.nathan.learn.calcite;

import com.nathan.learn.calcite.mock.HrSchema;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.rel2sql.RelToSqlConverter;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlDialect;
import org.apache.calcite.sql.SqlExplainLevel;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.RelBuilder;
import org.junit.Test;

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

    @Test
    public void testRelToSql() {
        final RelBuilder builder = RelBuilder.create(config().build());
        final RelNode node = builder
                .scan("emps")
                .project(builder.field("deptno"), builder.field("salary"))
                .filter(
                        builder.call(SqlStdOperatorTable.GREATER_THAN,
                                builder.field("deptno"),
                                builder.literal(10)))
                .scan("depts")
                .project(builder.field("deptno"))
                .filter(builder.call(SqlStdOperatorTable.EQUALS,
                        builder.field("deptno"),
                        builder.literal("20201101")))
                .join(JoinRelType.LEFT, "deptno", "deptno")
                .join(JoinRelType.LEFT, "deptno", "deptno")
                .project(builder.field(0))
                .build();
        System.out.println(RelOptUtil.toString(node));
        System.out.println(RelOptUtil.toString(node, SqlExplainLevel.ALL_ATTRIBUTES));
        System.out.println(new RelToSqlConverter(SqlDialect.DatabaseProduct.SPARK.getDialect())
                .visitChild(0, node).asStatement());
    }
}
