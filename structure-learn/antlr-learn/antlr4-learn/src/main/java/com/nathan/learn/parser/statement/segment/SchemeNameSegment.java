
package com.nathan.learn.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.nathan.learn.parser.statement.ASTNode;

/**
 * Scheme name segment.
 */
@RequiredArgsConstructor
@Getter
public final class SchemeNameSegment implements ASTNode {
    
    private final IdentifierSegment identifier;
}
