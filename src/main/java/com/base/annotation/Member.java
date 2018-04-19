package com.base.annotation;

/**
 * Created by nathan on 17/1/23.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SqlString(30) String firstName;
    @SqlString(50) String lastName;
    @SqlString(value = 30, constrains = @Constraints(primaryKey = true)) String id;
}
