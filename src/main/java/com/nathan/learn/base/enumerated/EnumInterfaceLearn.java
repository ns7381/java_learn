package com.nathan.learn.base.enumerated;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by nathan on 17/6/17.
 */
public class EnumInterfaceLearn {
    public interface Operation {
        double apply(double x, double y);
    }

    public enum BasicOperation implements Operation {
        PLUS("+"){
            @Override
            public double apply(double x, double y) {
                return x+y;
            }
        };

        private final String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }

    public enum ExtendOperation implements Operation {
        EXP("^") {
            @Override
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        };

        private final String symbol;

        ExtendOperation(String symbol) {
            this.symbol = symbol;
        }
    }


    public static void main(String[] args) {
        Class<BasicOperation> x = BasicOperation.class;
        System.out.println(x.getEnumConstants()[0]);
        test(ExtendOperation.class, 10.00, 2.00);
        test2(Arrays.asList(ExtendOperation.values()), 10.00, 2.00);
    }

    private static void test2(Collection<? extends Operation> values, double v, double v1) {
        for (Operation operation : values) {
            System.out.println(operation.apply(v, v1));
        }
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opt, double x, double y) {
        for (T op : opt.getEnumConstants()) {
            System.out.println(op.apply(x, y));
        }
    }
}
