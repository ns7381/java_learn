
package com.nathan.learn.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.nathan.learn.parser.statement.ASTNode;

/**
 * Identifier segment.
 */
@RequiredArgsConstructor
@Getter
public final class IdentifierSegment implements ASTNode {
    
    private final String value;
}
