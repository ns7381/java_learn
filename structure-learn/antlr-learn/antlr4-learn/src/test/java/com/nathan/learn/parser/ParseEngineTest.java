package com.nathan.learn.parser;

import com.nathan.learn.parser.engine.ParseEngine;
import com.nathan.learn.parser.statement.statement.UseStatement;
import org.junit.Test;

import static org.junit.Assert.*;

public final class ParseEngineTest {

    @Test
    public void testParse() {
        String sql = "use test_db";
        UseStatement useStatement = (UseStatement) ParseEngine.parse(sql);
        assertEquals(useStatement.getSchemeName().getIdentifier().getValue(), "test_db");
    }
}
