
package com.nathan.learn.parser.statement.statement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.nathan.learn.parser.statement.ASTNode;
import com.nathan.learn.parser.statement.segment.SchemeNameSegment;

/**
 * Use statement.
 */
@RequiredArgsConstructor
@Getter
public final class UseStatement implements ASTNode {
    
    private final SchemeNameSegment schemeName;
}
