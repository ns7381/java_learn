/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author ningsheng
 * @version MyVisitor.java, v 0.1 2023年03月02日 4:45 PM ningsheng
 */
public class MyVisitor implements HiveParserVisitor {
    /**
     * Visit a parse tree produced by {@link HiveParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStatement(HiveParser.StatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#explainStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExplainStatement(HiveParser.ExplainStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#explainOption}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExplainOption(HiveParser.ExplainOptionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#vectorizationOnly}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitVectorizationOnly(HiveParser.VectorizationOnlyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#vectorizatonDetail}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitVectorizatonDetail(HiveParser.VectorizatonDetailContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#execStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExecStatement(HiveParser.ExecStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#loadStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLoadStatement(HiveParser.LoadStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replicationClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplicationClause(HiveParser.ReplicationClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#exportStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExportStatement(HiveParser.ExportStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#importStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitImportStatement(HiveParser.ImportStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replDumpStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplDumpStatement(HiveParser.ReplDumpStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replDbPolicy}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplDbPolicy(HiveParser.ReplDbPolicyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replLoadStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplLoadStatement(HiveParser.ReplLoadStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replConfigs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplConfigs(HiveParser.ReplConfigsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replConfigsList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplConfigsList(HiveParser.ReplConfigsListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replTableLevelPolicy}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplTableLevelPolicy(HiveParser.ReplTableLevelPolicyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replStatusStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplStatusStatement(HiveParser.ReplStatusStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#ddlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDdlStatement(HiveParser.DdlStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#ifExists}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIfExists(HiveParser.IfExistsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#restrictOrCascade}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRestrictOrCascade(HiveParser.RestrictOrCascadeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#ifNotExists}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIfNotExists(HiveParser.IfNotExistsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#force}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitForce(HiveParser.ForceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rewriteEnabled}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRewriteEnabled(HiveParser.RewriteEnabledContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rewriteDisabled}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRewriteDisabled(HiveParser.RewriteDisabledContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#storedAsDirs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStoredAsDirs(HiveParser.StoredAsDirsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#orReplace}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitOrReplace(HiveParser.OrReplaceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createDatabaseStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateDatabaseStatement(HiveParser.CreateDatabaseStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dbLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDbLocation(HiveParser.DbLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dbManagedLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDbManagedLocation(HiveParser.DbManagedLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dbProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDbProperties(HiveParser.DbPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dbPropertiesList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDbPropertiesList(HiveParser.DbPropertiesListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dbConnectorName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDbConnectorName(HiveParser.DbConnectorNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#switchDatabaseStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSwitchDatabaseStatement(HiveParser.SwitchDatabaseStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropDatabaseStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropDatabaseStatement(HiveParser.DropDatabaseStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#databaseComment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDatabaseComment(HiveParser.DatabaseCommentContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#truncateTableStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTruncateTableStatement(HiveParser.TruncateTableStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropTableStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropTableStatement(HiveParser.DropTableStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#inputFileFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitInputFileFormat(HiveParser.InputFileFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tabTypeExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTabTypeExpr(HiveParser.TabTypeExprContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partTypeExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartTypeExpr(HiveParser.PartTypeExprContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tabPartColTypeExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTabPartColTypeExpr(HiveParser.TabPartColTypeExprContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#descStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDescStatement(HiveParser.DescStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#analyzeStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAnalyzeStatement(HiveParser.AnalyzeStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#from_in}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFrom_in(HiveParser.From_inContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#db_schema}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDb_schema(HiveParser.Db_schemaContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowStatement(HiveParser.ShowStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showTablesFilterExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowTablesFilterExpr(HiveParser.ShowTablesFilterExprContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#lockStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLockStatement(HiveParser.LockStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#lockDatabase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLockDatabase(HiveParser.LockDatabaseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#lockMode}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLockMode(HiveParser.LockModeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#unlockStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUnlockStatement(HiveParser.UnlockStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#unlockDatabase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUnlockDatabase(HiveParser.UnlockDatabaseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createRoleStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateRoleStatement(HiveParser.CreateRoleStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropRoleStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropRoleStatement(HiveParser.DropRoleStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#grantPrivileges}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGrantPrivileges(HiveParser.GrantPrivilegesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#revokePrivileges}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRevokePrivileges(HiveParser.RevokePrivilegesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#grantRole}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGrantRole(HiveParser.GrantRoleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#revokeRole}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRevokeRole(HiveParser.RevokeRoleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showRoleGrants}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowRoleGrants(HiveParser.ShowRoleGrantsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showRoles}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowRoles(HiveParser.ShowRolesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showCurrentRole}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowCurrentRole(HiveParser.ShowCurrentRoleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#setRole}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSetRole(HiveParser.SetRoleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showGrants}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowGrants(HiveParser.ShowGrantsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showRolePrincipals}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowRolePrincipals(HiveParser.ShowRolePrincipalsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privilegeIncludeColObject}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivilegeIncludeColObject(HiveParser.PrivilegeIncludeColObjectContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privilegeObject}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivilegeObject(HiveParser.PrivilegeObjectContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privObject}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivObject(HiveParser.PrivObjectContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privObjectCols}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivObjectCols(HiveParser.PrivObjectColsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privilegeList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivilegeList(HiveParser.PrivilegeListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privlegeDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivlegeDef(HiveParser.PrivlegeDefContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#privilegeType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrivilegeType(HiveParser.PrivilegeTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#principalSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrincipalSpecification(HiveParser.PrincipalSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#principalName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrincipalName(HiveParser.PrincipalNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#withGrantOption}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWithGrantOption(HiveParser.WithGrantOptionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#grantOptionFor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGrantOptionFor(HiveParser.GrantOptionForContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#adminOptionFor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAdminOptionFor(HiveParser.AdminOptionForContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#withAdminOption}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWithAdminOption(HiveParser.WithAdminOptionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#metastoreCheck}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitMetastoreCheck(HiveParser.MetastoreCheckContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#resourceList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitResourceList(HiveParser.ResourceListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#resource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitResource(HiveParser.ResourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#resourceType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitResourceType(HiveParser.ResourceTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createFunctionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateFunctionStatement(HiveParser.CreateFunctionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropFunctionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropFunctionStatement(HiveParser.DropFunctionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#reloadFunctionsStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReloadFunctionsStatement(HiveParser.ReloadFunctionsStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createMacroStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateMacroStatement(HiveParser.CreateMacroStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropMacroStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropMacroStatement(HiveParser.DropMacroStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateViewStatement(HiveParser.CreateViewStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewPartition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewPartition(HiveParser.ViewPartitionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewOrganization}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewOrganization(HiveParser.ViewOrganizationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewClusterSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewClusterSpec(HiveParser.ViewClusterSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewComplexSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewComplexSpec(HiveParser.ViewComplexSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewDistSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewDistSpec(HiveParser.ViewDistSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewSortSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewSortSpec(HiveParser.ViewSortSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropViewStatement(HiveParser.DropViewStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createMaterializedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateMaterializedViewStatement(HiveParser.CreateMaterializedViewStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropMaterializedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropMaterializedViewStatement(HiveParser.DropMaterializedViewStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createScheduledQueryStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateScheduledQueryStatement(HiveParser.CreateScheduledQueryStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropScheduledQueryStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropScheduledQueryStatement(HiveParser.DropScheduledQueryStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterScheduledQueryStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterScheduledQueryStatement(HiveParser.AlterScheduledQueryStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterScheduledQueryChange}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterScheduledQueryChange(HiveParser.AlterScheduledQueryChangeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#scheduleSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitScheduleSpec(HiveParser.ScheduleSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#executedAsSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExecutedAsSpec(HiveParser.ExecutedAsSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#definedAsSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDefinedAsSpec(HiveParser.DefinedAsSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showFunctionIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowFunctionIdentifier(HiveParser.ShowFunctionIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#showStmtIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitShowStmtIdentifier(HiveParser.ShowStmtIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableComment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableComment(HiveParser.TableCommentContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createTablePartitionSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateTablePartitionSpec(HiveParser.CreateTablePartitionSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createTablePartitionColumnTypeSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateTablePartitionColumnTypeSpec(HiveParser.CreateTablePartitionColumnTypeSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createTablePartitionColumnSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateTablePartitionColumnSpec(HiveParser.CreateTablePartitionColumnSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionTransformSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionTransformSpec(HiveParser.PartitionTransformSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameTransformConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameTransformConstraint(HiveParser.ColumnNameTransformConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionTransformType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionTransformType(HiveParser.PartitionTransformTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableBuckets}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableBuckets(HiveParser.TableBucketsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableImplBuckets}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableImplBuckets(HiveParser.TableImplBucketsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableSkewed}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableSkewed(HiveParser.TableSkewedContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rowFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRowFormat(HiveParser.RowFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#recordReader}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRecordReader(HiveParser.RecordReaderContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#recordWriter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRecordWriter(HiveParser.RecordWriterContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rowFormatSerde}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRowFormatSerde(HiveParser.RowFormatSerdeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rowFormatDelimited}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRowFormatDelimited(HiveParser.RowFormatDelimitedContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowFormat(HiveParser.TableRowFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tablePropertiesPrefixed}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTablePropertiesPrefixed(HiveParser.TablePropertiesPrefixedContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableProperties(HiveParser.TablePropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tablePropertiesList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTablePropertiesList(HiveParser.TablePropertiesListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#keyValueProperty}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitKeyValueProperty(HiveParser.KeyValuePropertyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#keyProperty}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitKeyProperty(HiveParser.KeyPropertyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowFormatFieldIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowFormatFieldIdentifier(HiveParser.TableRowFormatFieldIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowFormatCollItemsIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowFormatCollItemsIdentifier(HiveParser.TableRowFormatCollItemsIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowFormatMapKeysIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowFormatMapKeysIdentifier(HiveParser.TableRowFormatMapKeysIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowFormatLinesIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowFormatLinesIdentifier(HiveParser.TableRowFormatLinesIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableRowNullFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableRowNullFormat(HiveParser.TableRowNullFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableFileFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableFileFormat(HiveParser.TableFileFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableLocation(HiveParser.TableLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameTypeList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameTypeList(HiveParser.ColumnNameTypeListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameTypeOrConstraintList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameTypeOrConstraintList(HiveParser.ColumnNameTypeOrConstraintListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameColonTypeList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameColonTypeList(HiveParser.ColumnNameColonTypeListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameList(HiveParser.ColumnNameListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnName(HiveParser.ColumnNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#extColumnName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExtColumnName(HiveParser.ExtColumnNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameOrderList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameOrderList(HiveParser.ColumnNameOrderListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnParenthesesList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnParenthesesList(HiveParser.ColumnParenthesesListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#enableValidateSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitEnableValidateSpecification(HiveParser.EnableValidateSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#enableSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitEnableSpecification(HiveParser.EnableSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#validateSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitValidateSpecification(HiveParser.ValidateSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#enforcedSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitEnforcedSpecification(HiveParser.EnforcedSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#relySpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRelySpecification(HiveParser.RelySpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateConstraint(HiveParser.CreateConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterConstraintWithName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterConstraintWithName(HiveParser.AlterConstraintWithNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableLevelConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableLevelConstraint(HiveParser.TableLevelConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#pkUkConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPkUkConstraint(HiveParser.PkUkConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#checkConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCheckConstraint(HiveParser.CheckConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createForeignKey}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateForeignKey(HiveParser.CreateForeignKeyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterForeignKeyWithName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterForeignKeyWithName(HiveParser.AlterForeignKeyWithNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedValueElement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedValueElement(HiveParser.SkewedValueElementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedColumnValuePairList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedColumnValuePairList(HiveParser.SkewedColumnValuePairListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedColumnValuePair}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedColumnValuePair(HiveParser.SkewedColumnValuePairContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedColumnValues}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedColumnValues(HiveParser.SkewedColumnValuesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedColumnValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedColumnValue(HiveParser.SkewedColumnValueContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedValueLocationElement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedValueLocationElement(HiveParser.SkewedValueLocationElementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#orderSpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitOrderSpecification(HiveParser.OrderSpecificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#nullOrdering}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitNullOrdering(HiveParser.NullOrderingContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameOrder}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameOrder(HiveParser.ColumnNameOrderContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameCommentList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameCommentList(HiveParser.ColumnNameCommentListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameComment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameComment(HiveParser.ColumnNameCommentContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#orderSpecificationRewrite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitOrderSpecificationRewrite(HiveParser.OrderSpecificationRewriteContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnRefOrder}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnRefOrder(HiveParser.ColumnRefOrderContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameType(HiveParser.ColumnNameTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameTypeOrConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameTypeOrConstraint(HiveParser.ColumnNameTypeOrConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableConstraint(HiveParser.TableConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameTypeConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameTypeConstraint(HiveParser.ColumnNameTypeConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnConstraint(HiveParser.ColumnConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#foreignKeyConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitForeignKeyConstraint(HiveParser.ForeignKeyConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#colConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColConstraint(HiveParser.ColConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterColumnConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterColumnConstraint(HiveParser.AlterColumnConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterForeignKeyConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterForeignKeyConstraint(HiveParser.AlterForeignKeyConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterColConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterColConstraint(HiveParser.AlterColConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnConstraintType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnConstraintType(HiveParser.ColumnConstraintTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#defaultVal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDefaultVal(HiveParser.DefaultValContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableConstraintType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableConstraintType(HiveParser.TableConstraintTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#constraintOptsCreate}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConstraintOptsCreate(HiveParser.ConstraintOptsCreateContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#constraintOptsAlter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConstraintOptsAlter(HiveParser.ConstraintOptsAlterContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnNameColonType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnNameColonType(HiveParser.ColumnNameColonTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#colType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColType(HiveParser.ColTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#colTypeList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColTypeList(HiveParser.ColTypeListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitType(HiveParser.TypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#primitiveType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrimitiveType(HiveParser.PrimitiveTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#listType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitListType(HiveParser.ListTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#structType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStructType(HiveParser.StructTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#mapType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitMapType(HiveParser.MapTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#unionType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUnionType(HiveParser.UnionTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#setOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSetOperator(HiveParser.SetOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#queryStatementExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitQueryStatementExpression(HiveParser.QueryStatementExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#queryStatementExpressionBody}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitQueryStatementExpressionBody(HiveParser.QueryStatementExpressionBodyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#withClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWithClause(HiveParser.WithClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#cteStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCteStatement(HiveParser.CteStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#fromStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFromStatement(HiveParser.FromStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#singleFromStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSingleFromStatement(HiveParser.SingleFromStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#regularBody}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRegularBody(HiveParser.RegularBodyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#atomSelectStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAtomSelectStatement(HiveParser.AtomSelectStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectStatement(HiveParser.SelectStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#setOpSelectStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSetOpSelectStatement(HiveParser.SetOpSelectStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectStatementWithCTE}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectStatementWithCTE(HiveParser.SelectStatementWithCTEContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitBody(HiveParser.BodyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#insertClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitInsertClause(HiveParser.InsertClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#destination}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDestination(HiveParser.DestinationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#limitClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLimitClause(HiveParser.LimitClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#deleteStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDeleteStatement(HiveParser.DeleteStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnAssignmentClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnAssignmentClause(HiveParser.ColumnAssignmentClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedencePlusExpressionOrDefault}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedencePlusExpressionOrDefault(HiveParser.PrecedencePlusExpressionOrDefaultContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#setColumnsClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSetColumnsClause(HiveParser.SetColumnsClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#updateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUpdateStatement(HiveParser.UpdateStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#sqlTransactionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSqlTransactionStatement(HiveParser.SqlTransactionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#startTransactionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStartTransactionStatement(HiveParser.StartTransactionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#transactionMode}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTransactionMode(HiveParser.TransactionModeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#transactionAccessMode}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTransactionAccessMode(HiveParser.TransactionAccessModeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#isolationLevel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIsolationLevel(HiveParser.IsolationLevelContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#levelOfIsolation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLevelOfIsolation(HiveParser.LevelOfIsolationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#commitStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCommitStatement(HiveParser.CommitStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rollbackStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRollbackStatement(HiveParser.RollbackStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#setAutoCommitStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSetAutoCommitStatement(HiveParser.SetAutoCommitStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#abortTransactionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAbortTransactionStatement(HiveParser.AbortTransactionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#abortCompactionStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAbortCompactionStatement(HiveParser.AbortCompactionStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#mergeStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitMergeStatement(HiveParser.MergeStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whenClauses}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhenClauses(HiveParser.WhenClausesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whenNotMatchedClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhenNotMatchedClause(HiveParser.WhenNotMatchedClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whenMatchedAndClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhenMatchedAndClause(HiveParser.WhenMatchedAndClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whenMatchedThenClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhenMatchedThenClause(HiveParser.WhenMatchedThenClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#updateOrDelete}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUpdateOrDelete(HiveParser.UpdateOrDeleteContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#killQueryStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitKillQueryStatement(HiveParser.KillQueryStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#compactionId}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCompactionId(HiveParser.CompactionIdContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#compactionPool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCompactionPool(HiveParser.CompactionPoolContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#compactionType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCompactionType(HiveParser.CompactionTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#compactionStatus}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCompactionStatus(HiveParser.CompactionStatusContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatement(HiveParser.AlterStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterTableStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterTableStatementSuffix(HiveParser.AlterTableStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterTblPartitionStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterTblPartitionStatementSuffix(HiveParser.AlterTblPartitionStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementPartitionKeyType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementPartitionKeyType(HiveParser.AlterStatementPartitionKeyTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterViewStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterViewStatementSuffix(HiveParser.AlterViewStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterMaterializedViewStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterMaterializedViewStatementSuffix(HiveParser.AlterMaterializedViewStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterMaterializedViewSuffixRewrite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterMaterializedViewSuffixRewrite(HiveParser.AlterMaterializedViewSuffixRewriteContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterMaterializedViewSuffixRebuild}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterMaterializedViewSuffixRebuild(HiveParser.AlterMaterializedViewSuffixRebuildContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDatabaseStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDatabaseStatementSuffix(HiveParser.AlterDatabaseStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDatabaseSuffixProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDatabaseSuffixProperties(HiveParser.AlterDatabaseSuffixPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDatabaseSuffixSetOwner}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDatabaseSuffixSetOwner(HiveParser.AlterDatabaseSuffixSetOwnerContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDatabaseSuffixSetLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDatabaseSuffixSetLocation(HiveParser.AlterDatabaseSuffixSetLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDatabaseSuffixSetManagedLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDatabaseSuffixSetManagedLocation(HiveParser.AlterDatabaseSuffixSetManagedLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixRename}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixRename(HiveParser.AlterStatementSuffixRenameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixAddCol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixAddCol(HiveParser.AlterStatementSuffixAddColContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixAddConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixAddConstraint(HiveParser.AlterStatementSuffixAddConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixUpdateColumns}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixUpdateColumns(HiveParser.AlterStatementSuffixUpdateColumnsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixDropConstraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixDropConstraint(HiveParser.AlterStatementSuffixDropConstraintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixRenameCol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixRenameCol(HiveParser.AlterStatementSuffixRenameColContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixUpdateStatsCol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixUpdateStatsCol(HiveParser.AlterStatementSuffixUpdateStatsColContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixUpdateStats}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixUpdateStats(HiveParser.AlterStatementSuffixUpdateStatsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementChangeColPosition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementChangeColPosition(HiveParser.AlterStatementChangeColPositionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixAddPartitions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixAddPartitions(HiveParser.AlterStatementSuffixAddPartitionsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixAddPartitionsElement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixAddPartitionsElement(HiveParser.AlterStatementSuffixAddPartitionsElementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixTouch}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixTouch(HiveParser.AlterStatementSuffixTouchContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixArchive}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixArchive(HiveParser.AlterStatementSuffixArchiveContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixUnArchive}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixUnArchive(HiveParser.AlterStatementSuffixUnArchiveContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionLocation(HiveParser.PartitionLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixDropPartitions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixDropPartitions(HiveParser.AlterStatementSuffixDropPartitionsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixProperties(HiveParser.AlterStatementSuffixPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterViewSuffixProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterViewSuffixProperties(HiveParser.AlterViewSuffixPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixSerdeProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixSerdeProperties(HiveParser.AlterStatementSuffixSerdePropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tablePartitionPrefix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTablePartitionPrefix(HiveParser.TablePartitionPrefixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixFileFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixFileFormat(HiveParser.AlterStatementSuffixFileFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixClusterbySortby}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixClusterbySortby(HiveParser.AlterStatementSuffixClusterbySortbyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterTblPartitionStatementSuffixSkewedLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterTblPartitionStatementSuffixSkewedLocation(HiveParser.AlterTblPartitionStatementSuffixSkewedLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedLocations}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedLocations(HiveParser.SkewedLocationsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedLocationsList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedLocationsList(HiveParser.SkewedLocationsListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#skewedLocationMap}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSkewedLocationMap(HiveParser.SkewedLocationMapContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixLocation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixLocation(HiveParser.AlterStatementSuffixLocationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixSkewedby}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixSkewedby(HiveParser.AlterStatementSuffixSkewedbyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixExchangePartition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixExchangePartition(HiveParser.AlterStatementSuffixExchangePartitionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixRenamePart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixRenamePart(HiveParser.AlterStatementSuffixRenamePartContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixStatsPart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixStatsPart(HiveParser.AlterStatementSuffixStatsPartContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixMergeFiles}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixMergeFiles(HiveParser.AlterStatementSuffixMergeFilesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixBucketNum}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixBucketNum(HiveParser.AlterStatementSuffixBucketNumContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#blocking}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitBlocking(HiveParser.BlockingContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#compactPool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCompactPool(HiveParser.CompactPoolContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixCompact}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixCompact(HiveParser.AlterStatementSuffixCompactContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixSetOwner}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixSetOwner(HiveParser.AlterStatementSuffixSetOwnerContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixSetPartSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixSetPartSpec(HiveParser.AlterStatementSuffixSetPartSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterStatementSuffixExecute}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterStatementSuffixExecute(HiveParser.AlterStatementSuffixExecuteContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#fileFormat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFileFormat(HiveParser.FileFormatContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDataConnectorStatementSuffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDataConnectorStatementSuffix(HiveParser.AlterDataConnectorStatementSuffixContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDataConnectorSuffixProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDataConnectorSuffixProperties(HiveParser.AlterDataConnectorSuffixPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDataConnectorSuffixSetOwner}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDataConnectorSuffixSetOwner(HiveParser.AlterDataConnectorSuffixSetOwnerContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterDataConnectorSuffixSetUrl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterDataConnectorSuffixSetUrl(HiveParser.AlterDataConnectorSuffixSetUrlContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#likeTableOrFile}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLikeTableOrFile(HiveParser.LikeTableOrFileContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createTableStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateTableStatement(HiveParser.CreateTableStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createDataConnectorStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateDataConnectorStatement(HiveParser.CreateDataConnectorStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dataConnectorComment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDataConnectorComment(HiveParser.DataConnectorCommentContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dataConnectorUrl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDataConnectorUrl(HiveParser.DataConnectorUrlContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dataConnectorType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDataConnectorType(HiveParser.DataConnectorTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dcProperties}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDcProperties(HiveParser.DcPropertiesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropDataConnectorStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropDataConnectorStatement(HiveParser.DropDataConnectorStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableAllColumns}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableAllColumns(HiveParser.TableAllColumnsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableOrColumn}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableOrColumn(HiveParser.TableOrColumnContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#defaultValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDefaultValue(HiveParser.DefaultValueContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionList(HiveParser.ExpressionListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#aliasList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAliasList(HiveParser.AliasListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#fromClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFromClause(HiveParser.FromClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#fromSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFromSource(HiveParser.FromSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#atomjoinSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAtomjoinSource(HiveParser.AtomjoinSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#joinSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitJoinSource(HiveParser.JoinSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#joinSourcePart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitJoinSourcePart(HiveParser.JoinSourcePartContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#uniqueJoinSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUniqueJoinSource(HiveParser.UniqueJoinSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#uniqueJoinExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUniqueJoinExpr(HiveParser.UniqueJoinExprContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#uniqueJoinToken}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUniqueJoinToken(HiveParser.UniqueJoinTokenContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#joinToken}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitJoinToken(HiveParser.JoinTokenContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#lateralView}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitLateralView(HiveParser.LateralViewContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableAlias}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableAlias(HiveParser.TableAliasContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableBucketSample}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableBucketSample(HiveParser.TableBucketSampleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#splitSample}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSplitSample(HiveParser.SplitSampleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableSample}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableSample(HiveParser.TableSampleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableSource(HiveParser.TableSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#asOfClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAsOfClause(HiveParser.AsOfClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#uniqueJoinTableSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUniqueJoinTableSource(HiveParser.UniqueJoinTableSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableName(HiveParser.TableNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#viewName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitViewName(HiveParser.ViewNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#subQuerySource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSubQuerySource(HiveParser.SubQuerySourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitioningSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitioningSpec(HiveParser.PartitioningSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionTableFunctionSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionTableFunctionSource(HiveParser.PartitionTableFunctionSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionedTableFunction}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionedTableFunction(HiveParser.PartitionedTableFunctionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whereClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhereClause(HiveParser.WhereClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#searchCondition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSearchCondition(HiveParser.SearchConditionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#valuesSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitValuesSource(HiveParser.ValuesSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#valuesClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitValuesClause(HiveParser.ValuesClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#valuesTableConstructor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitValuesTableConstructor(HiveParser.ValuesTableConstructorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#valueRowConstructor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitValueRowConstructor(HiveParser.ValueRowConstructorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#firstValueRowConstructor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFirstValueRowConstructor(HiveParser.FirstValueRowConstructorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#virtualTableSource}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitVirtualTableSource(HiveParser.VirtualTableSourceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectClause(HiveParser.SelectClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#all_distinct}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAll_distinct(HiveParser.All_distinctContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectList(HiveParser.SelectListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectTrfmClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectTrfmClause(HiveParser.SelectTrfmClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectItem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectItem(HiveParser.SelectItemContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#trfmClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTrfmClause(HiveParser.TrfmClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectExpression(HiveParser.SelectExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#selectExpressionList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSelectExpressionList(HiveParser.SelectExpressionListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_clause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_clause(HiveParser.Window_clauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_defn}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_defn(HiveParser.Window_defnContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_specification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_specification(HiveParser.Window_specificationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_frame}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_frame(HiveParser.Window_frameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_range_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_range_expression(HiveParser.Window_range_expressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_value_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_value_expression(HiveParser.Window_value_expressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_frame_start_boundary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_frame_start_boundary(HiveParser.Window_frame_start_boundaryContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#window_frame_boundary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWindow_frame_boundary(HiveParser.Window_frame_boundaryContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupByClause(HiveParser.GroupByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupby_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupby_expression(HiveParser.Groupby_expressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupByEmpty}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupByEmpty(HiveParser.GroupByEmptyContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rollupStandard}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRollupStandard(HiveParser.RollupStandardContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rollupOldSyntax}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRollupOldSyntax(HiveParser.RollupOldSyntaxContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupingSetExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupingSetExpression(HiveParser.GroupingSetExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupingSetExpressionMultiple}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupingSetExpressionMultiple(HiveParser.GroupingSetExpressionMultipleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#groupingExpressionSingle}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGroupingExpressionSingle(HiveParser.GroupingExpressionSingleContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#havingClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHavingClause(HiveParser.HavingClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#qualifyClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitQualifyClause(HiveParser.QualifyClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#havingCondition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHavingCondition(HiveParser.HavingConditionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionsInParenthesis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionsInParenthesis(HiveParser.ExpressionsInParenthesisContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionsNotInParenthesis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionsNotInParenthesis(HiveParser.ExpressionsNotInParenthesisContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionPart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionPart(HiveParser.ExpressionPartContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionOrDefault}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionOrDefault(HiveParser.ExpressionOrDefaultContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#firstExpressionsWithAlias}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFirstExpressionsWithAlias(HiveParser.FirstExpressionsWithAliasContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressionWithAlias}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressionWithAlias(HiveParser.ExpressionWithAliasContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expressions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpressions(HiveParser.ExpressionsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnRefOrderInParenthesis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnRefOrderInParenthesis(HiveParser.ColumnRefOrderInParenthesisContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#columnRefOrderNotInParenthesis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitColumnRefOrderNotInParenthesis(HiveParser.ColumnRefOrderNotInParenthesisContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#orderByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitOrderByClause(HiveParser.OrderByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#clusterByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitClusterByClause(HiveParser.ClusterByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionByClause(HiveParser.PartitionByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#distributeByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDistributeByClause(HiveParser.DistributeByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#sortByClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSortByClause(HiveParser.SortByClauseContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#trimFunction}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTrimFunction(HiveParser.TrimFunctionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#function_}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunction_(HiveParser.Function_Context ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#null_treatment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitNull_treatment(HiveParser.Null_treatmentContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#functionName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunctionName(HiveParser.FunctionNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#castExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCastExpression(HiveParser.CastExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#caseExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCaseExpression(HiveParser.CaseExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#whenExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhenExpression(HiveParser.WhenExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#floorExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFloorExpression(HiveParser.FloorExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#floorDateQualifiers}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFloorDateQualifiers(HiveParser.FloorDateQualifiersContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#extractExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExtractExpression(HiveParser.ExtractExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#timeQualifiers}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTimeQualifiers(HiveParser.TimeQualifiersContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConstant(HiveParser.ConstantContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#prepareStmtParam}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrepareStmtParam(HiveParser.PrepareStmtParamContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#parameterIdx}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitParameterIdx(HiveParser.ParameterIdxContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#stringLiteralSequence}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStringLiteralSequence(HiveParser.StringLiteralSequenceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#charSetStringLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCharSetStringLiteral(HiveParser.CharSetStringLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dateLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDateLiteral(HiveParser.DateLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#timestampLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTimestampLiteral(HiveParser.TimestampLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#timestampLocalTZLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTimestampLocalTZLiteral(HiveParser.TimestampLocalTZLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#intervalValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIntervalValue(HiveParser.IntervalValueContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#intervalLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIntervalLiteral(HiveParser.IntervalLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#intervalExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIntervalExpression(HiveParser.IntervalExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#intervalQualifiers}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIntervalQualifiers(HiveParser.IntervalQualifiersContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExpression(HiveParser.ExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#atomExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAtomExpression(HiveParser.AtomExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceFieldExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceFieldExpression(HiveParser.PrecedenceFieldExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceUnaryOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceUnaryOperator(HiveParser.PrecedenceUnaryOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceUnaryPrefixExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceUnaryPrefixExpression(HiveParser.PrecedenceUnaryPrefixExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceBitwiseXorOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceBitwiseXorOperator(HiveParser.PrecedenceBitwiseXorOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceBitwiseXorExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceBitwiseXorExpression(HiveParser.PrecedenceBitwiseXorExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceStarOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceStarOperator(HiveParser.PrecedenceStarOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceStarExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceStarExpression(HiveParser.PrecedenceStarExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedencePlusOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedencePlusOperator(HiveParser.PrecedencePlusOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedencePlusExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedencePlusExpression(HiveParser.PrecedencePlusExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceConcatenateOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceConcatenateOperator(HiveParser.PrecedenceConcatenateOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceConcatenateExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceConcatenateExpression(HiveParser.PrecedenceConcatenateExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceAmpersandOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceAmpersandOperator(HiveParser.PrecedenceAmpersandOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceAmpersandExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceAmpersandExpression(HiveParser.PrecedenceAmpersandExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceBitwiseOrOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceBitwiseOrOperator(HiveParser.PrecedenceBitwiseOrOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceBitwiseOrExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceBitwiseOrExpression(HiveParser.PrecedenceBitwiseOrExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceRegexpOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceRegexpOperator(HiveParser.PrecedenceRegexpOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarOperator(HiveParser.PrecedenceSimilarOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#subQueryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSubQueryExpression(HiveParser.SubQueryExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpression(HiveParser.PrecedenceSimilarExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionMain}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionMain(HiveParser.PrecedenceSimilarExpressionMainContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionPart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionPart(HiveParser.PrecedenceSimilarExpressionPartContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionAtom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionAtom(HiveParser.PrecedenceSimilarExpressionAtomContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionQuantifierPredicate}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionQuantifierPredicate(HiveParser.PrecedenceSimilarExpressionQuantifierPredicateContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#quantifierType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitQuantifierType(HiveParser.QuantifierTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionIn}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionIn(HiveParser.PrecedenceSimilarExpressionInContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceSimilarExpressionPartNot}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceSimilarExpressionPartNot(HiveParser.PrecedenceSimilarExpressionPartNotContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceDistinctOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceDistinctOperator(HiveParser.PrecedenceDistinctOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceEqualOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceEqualOperator(HiveParser.PrecedenceEqualOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceEqualExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceEqualExpression(HiveParser.PrecedenceEqualExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#isCondition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIsCondition(HiveParser.IsConditionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceUnarySuffixExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceUnarySuffixExpression(HiveParser.PrecedenceUnarySuffixExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceNotOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceNotOperator(HiveParser.PrecedenceNotOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceNotExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceNotExpression(HiveParser.PrecedenceNotExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceAndOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceAndOperator(HiveParser.PrecedenceAndOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceAndExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceAndExpression(HiveParser.PrecedenceAndExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceOrOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceOrOperator(HiveParser.PrecedenceOrOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#precedenceOrExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrecedenceOrExpression(HiveParser.PrecedenceOrExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#booleanValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitBooleanValue(HiveParser.BooleanValueContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#booleanValueTok}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitBooleanValueTok(HiveParser.BooleanValueTokContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#tableOrPartition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTableOrPartition(HiveParser.TableOrPartitionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionSpec(HiveParser.PartitionSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionVal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionVal(HiveParser.PartitionValContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionSelectorSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionSelectorSpec(HiveParser.PartitionSelectorSpecContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionSelectorVal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionSelectorVal(HiveParser.PartitionSelectorValContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#partitionSelectorOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPartitionSelectorOperator(HiveParser.PartitionSelectorOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#subQuerySelectorOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSubQuerySelectorOperator(HiveParser.SubQuerySelectorOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#sysFuncNames}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSysFuncNames(HiveParser.SysFuncNamesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#descFuncNames}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDescFuncNames(HiveParser.DescFuncNamesContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#id_}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitId_(HiveParser.Id_Context ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#functionIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunctionIdentifier(HiveParser.FunctionIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#principalIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrincipalIdentifier(HiveParser.PrincipalIdentifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#nonReserved}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitNonReserved(HiveParser.NonReservedContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#sql11ReservedKeywordsUsedAsFunctionName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitSql11ReservedKeywordsUsedAsFunctionName(HiveParser.Sql11ReservedKeywordsUsedAsFunctionNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHint(HiveParser.HintContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hintList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHintList(HiveParser.HintListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hintItem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHintItem(HiveParser.HintItemContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hintName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHintName(HiveParser.HintNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hintArgs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHintArgs(HiveParser.HintArgsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#hintArgName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitHintArgName(HiveParser.HintArgNameContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#prepareStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPrepareStatement(HiveParser.PrepareStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#executeStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExecuteStatement(HiveParser.ExecuteStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#executeParamList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitExecuteParamList(HiveParser.ExecuteParamListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#resourcePlanDdlStatements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitResourcePlanDdlStatements(HiveParser.ResourcePlanDdlStatementsContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rpAssign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRpAssign(HiveParser.RpAssignContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rpAssignList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRpAssignList(HiveParser.RpAssignListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rpUnassign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRpUnassign(HiveParser.RpUnassignContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#rpUnassignList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitRpUnassignList(HiveParser.RpUnassignListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createResourcePlanStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateResourcePlanStatement(HiveParser.CreateResourcePlanStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#withReplace}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWithReplace(HiveParser.WithReplaceContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#activate}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitActivate(HiveParser.ActivateContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#enable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitEnable(HiveParser.EnableContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#disable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDisable(HiveParser.DisableContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#unmanaged}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitUnmanaged(HiveParser.UnmanagedContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterResourcePlanStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterResourcePlanStatement(HiveParser.AlterResourcePlanStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#globalWmStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitGlobalWmStatement(HiveParser.GlobalWmStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#replaceResourcePlanStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitReplaceResourcePlanStatement(HiveParser.ReplaceResourcePlanStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropResourcePlanStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropResourcePlanStatement(HiveParser.DropResourcePlanStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#poolPath}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPoolPath(HiveParser.PoolPathContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerExpression(HiveParser.TriggerExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerExpressionStandalone}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerExpressionStandalone(HiveParser.TriggerExpressionStandaloneContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerOrExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerOrExpression(HiveParser.TriggerOrExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerAndExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerAndExpression(HiveParser.TriggerAndExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerAtomExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerAtomExpression(HiveParser.TriggerAtomExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerLiteral(HiveParser.TriggerLiteralContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#comparisionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitComparisionOperator(HiveParser.ComparisionOperatorContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerActionExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerActionExpression(HiveParser.TriggerActionExpressionContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#triggerActionExpressionStandalone}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitTriggerActionExpressionStandalone(HiveParser.TriggerActionExpressionStandaloneContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createTriggerStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateTriggerStatement(HiveParser.CreateTriggerStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterTriggerStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterTriggerStatement(HiveParser.AlterTriggerStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropTriggerStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropTriggerStatement(HiveParser.DropTriggerStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#poolAssign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPoolAssign(HiveParser.PoolAssignContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#poolAssignList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitPoolAssignList(HiveParser.PoolAssignListContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createPoolStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreatePoolStatement(HiveParser.CreatePoolStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterPoolStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterPoolStatement(HiveParser.AlterPoolStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropPoolStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropPoolStatement(HiveParser.DropPoolStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#createMappingStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitCreateMappingStatement(HiveParser.CreateMappingStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#alterMappingStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitAlterMappingStatement(HiveParser.AlterMappingStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link HiveParser#dropMappingStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitDropMappingStatement(HiveParser.DropMappingStatementContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}