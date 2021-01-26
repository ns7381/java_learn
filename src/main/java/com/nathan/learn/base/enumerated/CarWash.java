package com.nathan.learn.base.enumerated;

import java.util.EnumSet;

/**
 * Created by nathan on 17/1/12.
 */
public class CarWash {
    enum Cycle {
        UNDERBODY {
            void action() {
                System.out.println("underbody");
            }
        },
        BASIC {
            @Override
            void action() {
                System.out.println("basic");
            }
        },
        TEST {
            @Override
            void action() {
                System.out.println("test");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.TEST);

    void add(Cycle cycle) {
        cycles.add(cycle);
    }

    void wash() {
        for (Cycle cycle : cycles) {
            cycle.action();

        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);;
        carWash.wash();
        System.out.println("------");
        carWash.add(Cycle.UNDERBODY);
        carWash.wash();
        System.out.println(Cycle.valueOf("BASIC"));
    }
}
