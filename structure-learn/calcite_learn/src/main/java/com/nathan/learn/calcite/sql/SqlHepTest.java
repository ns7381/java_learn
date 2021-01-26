package com.nathan.learn.calcite.sql;

import org.apache.calcite.config.CalciteConnectionConfigImpl;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.RelDistributionTraitDef;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.rules.FilterJoinRule;
import org.apache.calcite.rel.rules.PruneEmptyRules;
import org.apache.calcite.rel.rules.ReduceExpressionsRule;
import org.apache.calcite.rel.type.RelDataTypeSystem;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
import org.apache.calcite.sql2rel.RelDecorrelator;
import org.apache.calcite.sql2rel.SqlToRelConverter;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.RelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SqlHepTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlHepTest.class);
    private static final String SQL
            = "select u.id as user_id, u.name as user_name, j.company as user_company, u.age as user_age from users u"
            + " join jobs j on u.id=j.id where u.age > 30 and j.id>10 order by user_id";


    public static void main(String[] args) {


        // use HepPlanner
        HepProgramBuilder builder = new HepProgramBuilder();
        builder.addRuleInstance(FilterJoinRule.FilterIntoJoinRule.FILTER_ON_JOIN);
        builder.addRuleInstance(ReduceExpressionsRule.PROJECT_INSTANCE);
        builder.addRuleInstance(PruneEmptyRules.PROJECT_INSTANCE);
        HepPlanner planner = new HepPlanner(builder.build());

        try {
            //1.  sql parser
            SqlParser parser = SqlParser.create(SQL, SqlParser.Config.DEFAULT);
            SqlNode parsed = parser.parseStmt();
            LOGGER.info("The SqlNode after parsed is:\n{}", parsed.toString());

            //2. sql validate
            // RelDataTypeSystem类型系统定义对象的相互作用的行为和约束。
            //SqlTypeFactoryImpl类型工厂把SQL数据类型名字转换成关系数据类型
            SqlTypeFactoryImpl factory = new SqlTypeFactoryImpl(RelDataTypeSystem.DEFAULT);

            // 创建schema
            SchemaPlus rootSchema = CalciteUtils.registerRootSchema();

            // 统一的一个框架的配置类, 放入parseconfig, schema, traitDefs
            // trait用来定义逻辑表的物理相关属性
            final FrameworkConfig frameworkConfig = Frameworks.newConfigBuilder()
                    .parserConfig(SqlParser.Config.DEFAULT)
                    .defaultSchema(rootSchema)
                    .traitDefs(ConventionTraitDef.INSTANCE, RelDistributionTraitDef.INSTANCE)
                    .build();

            //Interface by which validator and planner can read table metadata. 
            CalciteCatalogReader calciteCatalogReader = new CalciteCatalogReader(
                    CalciteSchema.from(rootSchema),
                    CalciteSchema.from(rootSchema).path(null),
                    factory,
                    new CalciteConnectionConfigImpl(new Properties()));

            //Provides library users a way to store data within the planner session and access it within rules. 
            SqlValidator validator = SqlValidatorUtil.newValidator(SqlStdOperatorTable.instance(), calciteCatalogReader,
                    factory, CalciteUtils.conformance(frameworkConfig));
            SqlNode validated = validator.validate(parsed);
            LOGGER.info("The SqlNode after validated is:\n{}", validated.toString());

            //3. convert
            //Factory for row expressions.
            final RexBuilder rexBuilder = CalciteUtils.createRexBuilder(factory);
            final RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);

            // init SqlToRelConverter config
            final SqlToRelConverter.Config config = SqlToRelConverter.configBuilder()
                    .withConfig(frameworkConfig.getSqlToRelConverterConfig())
                    .withTrimUnusedFields(false)
                    .build();
            // SqlNode toRelNode
            final SqlToRelConverter sqlToRelConverter = new SqlToRelConverter(new CalciteUtils.ViewExpanderImpl(),
                    validator, calciteCatalogReader, cluster, frameworkConfig.getConvertletTable(), config);
            RelRoot root = sqlToRelConverter.convertQuery(validated, false, true);
            root = root.withRel(sqlToRelConverter.flattenTypes(root.rel, true));
            final RelBuilder relBuilder = config.getRelBuilderFactory().create(cluster, null);
            root = root.withRel(RelDecorrelator.decorrelateQuery(root.rel, relBuilder));

            // 4. optimize
            RelNode relNode = root.rel;
            LOGGER.info("The relational expression string before optimized is:\n{}", RelOptUtil.toString(relNode));
            planner.setRoot(relNode);
            relNode = planner.findBestExp();
            System.out.println("-----------------------------------------------------------");
            System.out.println("The Best relational expression string:");
            System.out.println(RelOptUtil.toString(relNode));
            System.out.println("-----------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
