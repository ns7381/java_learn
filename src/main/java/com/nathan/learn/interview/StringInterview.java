package com.nathan.learn.interview;

import java.util.Stack;

public class StringInterview {
    /**
     * 最长有效括号
     * 1. 遍历字符串
     * 2. 遇到左括号入栈, 遇到右括号出栈
     *
     *
     *
     * @param bracketStr 带有括号的字符串
     * @return 最长有效括号的个数
     */
    private int maxLength(String bracketStr) {
        int maxLength = 0;
        Stack<Character> stack = new Stack<>();
        int length = 0;
        for (int i = 0; i < bracketStr.length(); i++) {
            char curChar = bracketStr.charAt(i);
            if ('(' == curChar) {
                stack.push(curChar);
            } else if (')' == curChar) {
                if (stack.isEmpty()) {
                    length = 0;
                } else {
                    char stackChar = stack.pop();
                    if (stackChar == '(') {
                        length = length + 2;
                        maxLength = Math.max(maxLength, length);
                    } else if (stackChar == ')') {
                        length = 0;
                    }
                }
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        StringInterview interview = new StringInterview();
        System.out.println(interview.maxLength("(()"));
        System.out.println(interview.maxLength(")()())"));
    }
}
