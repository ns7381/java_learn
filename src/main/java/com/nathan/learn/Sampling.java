/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.nathan.learn;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author ningsheng
 * @version Sampling.java, v 0.1 2022年09月05日 6:40 PM ningsheng
 */

public class Sampling {
    public Sampling() {
    }

    public Boolean evaluate(String colVal, String startVal, String endVal) {
        String strVal;
        if (this.isNumber(colVal)) {
            int index = colVal.indexOf(".");
            if (index > 0) {
                strVal = colVal.substring(0, index);
            } else {
                strVal = colVal;
            }
        } else {
            strVal = String.valueOf(colVal.hashCode());
        }

        if (strVal.length() < 5) {
            strVal = "00000" + strVal;
        }

        String samplingStr = strVal.substring(strVal.length() - 5, strVal.length() - 1);
        startVal = this.fillToFixedLength(startVal, 4);
        endVal = this.fillToFixedLength(endVal, 4);
        return samplingStr.compareTo(startVal) >= 0 && samplingStr.compareTo(endVal) <= 0 ? true : false;
    }

    public boolean isNumber(String number) {
        int index = number.indexOf(".");
        if (index < 0) {
            return StringUtils.isNumeric(number);
        } else {
            String num1 = number.substring(0, index);
            String num2 = number.substring(index + 1);
            return StringUtils.isNumeric(num1) && StringUtils.isNumeric(num2);
        }
    }

    public String fillToFixedLength(String str, int len) {
        int cnt = len - str.length();
        if (cnt <= 0) {
            return str;
        } else {
            String pre;
            for(pre = ""; cnt > 0; --cnt) {
                pre = pre + "0";
            }

            return pre + str;
        }
    }

    @Test
    public void test() {
        Boolean evaluate = evaluate("123456789098765432", "6541", "6544");
        System.out.println(evaluate);
    }
}
