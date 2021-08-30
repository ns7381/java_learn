package com.nathan.learn.calcite.mock;

import java.util.Arrays;
import java.util.Collections;

/** Pojo schema containing "emps" and "depts" tables. */
public class HrSchema {
    @Override public String toString() {
        return "HrSchema";
    }

    public final Employee[] emps = {
            new Employee(100, 10, "Bill", 10000, 1000),
            new Employee(200, 20, "Eric", 8000, 500),
            new Employee(150, 10, "Sebastian", 7000, null),
            new Employee(110, 10, "Theodore", 11500, 250),
    };
    public final Department[] depts = {
            new Department(10, "Sales"),
            new Department(30, "Marketing"),
            new Department(40, "HR"),
    };
}