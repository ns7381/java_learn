package com.nathan.learn.calcite.mock;


import java.util.List;

/** Department record. */
public class Department {
    public final int deptno;
    public final String name;

    public Department(
            int deptno, String name) {
        this.deptno = deptno;
        this.name = name;
    }


    @Override public String toString() {
        return "Department [deptno: " + deptno + ", name: " + name + "]";
    }
}