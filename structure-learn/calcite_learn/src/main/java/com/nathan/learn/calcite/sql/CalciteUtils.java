package com.nathan.learn.calcite.sql;

import org.apache.calcite.config.CalciteConnectionConfig;
import org.apache.calcite.plan.Context;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeSystemImpl;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.sql.type.BasicSqlType;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.validate.SqlConformance;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;

import java.util.List;

public class CalciteUtils {

    public static SchemaPlus registerRootSchema() {
        //Frameworks calcite的框架工具类
        //Schema，是table和function的名称空间，它是一个可嵌套的结构
        //SchemaPlus, schema接口的扩展, 可支持下面的add table等操作
        SchemaPlus rootSchema = Frameworks.createRootSchema(true);
        //AbstractTable, schema里的table,
        rootSchema.add("USERS", new AbstractTable() {
            @Override
            public RelDataType getRowType(final RelDataTypeFactory typeFactory) {
                RelDataTypeFactory.Builder builder = typeFactory.builder();
                builder.add("ID", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.INTEGER));
                builder.add("NAME", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.CHAR));
                builder.add("AGE", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.INTEGER));
                return builder.build();
            }
        });

        rootSchema.add("JOBS", new AbstractTable() {
            @Override
            public RelDataType getRowType(final RelDataTypeFactory typeFactory) {
                RelDataTypeFactory.Builder builder = typeFactory.builder();
                builder.add("ID", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.INTEGER));
                builder.add("NAME", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.CHAR));
                builder.add("COMPANY", new BasicSqlType(new RelDataTypeSystemImpl() {
                }, SqlTypeName.CHAR));
                return builder.build();
            }
        });
        return rootSchema;
    }

    public static SqlConformance conformance(FrameworkConfig config) {
        final Context context = config.getContext();
        if (context != null) {
            final CalciteConnectionConfig connectionConfig = context.unwrap(CalciteConnectionConfig.class);
            if (connectionConfig != null) {
                return connectionConfig.conformance();
            }
        }
        return SqlConformanceEnum.DEFAULT;
    }

    public static RexBuilder createRexBuilder(RelDataTypeFactory typeFactory) {
        return new RexBuilder(typeFactory);
    }

    public static class ViewExpanderImpl implements RelOptTable.ViewExpander {
        public ViewExpanderImpl() {
        }

        @Override
        public RelRoot expandView(RelDataType rowType, String queryString, List<String> schemaPath,
                                  List<String> viewPath) {
            return null;
        }
    }
}
