package com.nathan.learn.base.enumerated;

import java.util.Random;

import static com.nathan.learn.base.enumerated.Input.*;

/**
 * Created by nathan on 17/1/16.
 */
enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("abort.amout()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("shutdown.amout()");
        }
    };

    int value;
    Input(int value) {
        this.value = value;
    }
    Input() { }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;
    Category(Input... inputs) {
        this.values = inputs;
    }
}
public class VendingMachine {
}
