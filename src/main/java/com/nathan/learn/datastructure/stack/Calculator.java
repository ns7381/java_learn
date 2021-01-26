package com.nathan.learn.datastructure.stack;

import com.nathan.learn.datastructure.queue.MyCircularQueue;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nathan
 */
public class Calculator {
    /**
     *  简单匹配运算表达式
     */
    public static final Pattern SIMPLE_EXPRESSION = Pattern.compile("-|\\+|\\*|/|\\d+");
    public static final Pattern COMPLEX_EXPRESSION = Pattern.compile("\\(|\\)|-|\\+|\\*|/|\\d+");
    public static final Pattern NUMBER = Pattern.compile("\\d+");
    public static final Pattern OPERATOR = Pattern.compile("[-+*/]");

    public interface Operator {
        int apply(int a, int b);
    }

    /**
     * add, subtract, multiply and divide
     */
    enum SimpleOperator implements Operator {
        /**
         * add
         */
        ADD("+", 1) {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        /**
         * subtract
         */
        SUBTRACT("-", 1) {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        /**
         * multiply
         */
        MULTIPLY("*", 2) {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        },
        /**
         * divide
         */
        DIVIDE("/", 2) {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        };

        private final String name;
        private final int priority;

        SimpleOperator(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }


    }

    public Optional<SimpleOperator> convert(String text) {
        SimpleOperator[] operators = SimpleOperator.values();
        for (SimpleOperator operator : operators) {
            if (text.equals(operator.name)) {
                return Optional.of(operator);
            }
        }
        return Optional.empty();
    }

    /**
     *  中缀表达式的计算
     * @param expression 中缀表达式
     * @return 计算结果
     */
    public int calculate(String expression) {
        // TODO 校验运算表达式的语法格式
        if (null == expression || "".equals(expression)) {
            throw new RuntimeException("no valid expression");
        }
        // 初始化所需的数据结构
        MyStack<Integer> numStack = new MyStack<>();
        MyStack<SimpleOperator> operatorStack = new MyStack<>();
        // 循环遍历表达式的操作
        Matcher matcher = SIMPLE_EXPRESSION.matcher(expression);
        while (matcher.find()) {
            String group = matcher.group();
            // 判断是运算符还是数字
            Optional<SimpleOperator> operatorOptional = convert(group);
            // 运算符：若栈顶元素的优先级大于当前运算符，将取数运算，将运算结果压栈，当前运算符压栈；否则当前运算符压栈
            operatorOptional.ifPresent(operator -> {
                if (!operatorStack.isEmpty()) {
                    if (operatorStack.peek().priority > operator.priority) {
                        SimpleOperator top = operatorStack.pop();
                        numStack.push(top.apply(numStack.pop(), numStack.pop()));
                    }
                }
                operatorStack.push(operator);
            });
            // 操作数: 直接入栈
            if (!operatorOptional.isPresent()) {
                numStack.push(Integer.valueOf(group));
            }
        }
        // 遍历结束：将栈中数据循环取出运算
        while (!operatorStack.isEmpty()) {
            SimpleOperator top = operatorStack.pop();
            Integer operand1 = numStack.pop();
            Integer operand2 = numStack.pop();
            numStack.push(top.apply(operand2, operand1));
        }
        return numStack.pop();
    }

    /**
     * 中缀表达式转后缀表达式
     * @param infixExpr 中缀表达式
     * @return 中缀表达式
     */
    public String toSuffixExpression(String infixExpr) {
        // 创建算法所需的数据结构
        MyStack<String> stack = new MyStack<>();
        MyCircularQueue<String> queue = new MyCircularQueue<>(16);

        // 遍历中缀表达式
        Matcher matcher = COMPLEX_EXPRESSION.matcher(infixExpr);
        while (matcher.find()) {
            String ele = matcher.group();
            // 操作数：进入队列
            if (NUMBER.matcher(ele).matches()) {
                queue.enqueue(ele);
            }
            // 左括号：进入栈
            else if ("(".equals(ele)) {
                stack.push(ele);
            }
            // 右括号：stack -> queue until top is (
            else if (")".equals(ele)) {
                while (!"(".equals(stack.peek())) {
                    queue.enqueue(stack.pop());
                }
                stack.pop();
            }
            // 运算符：
            // 1. 栈为空，直接入栈
            // 2. 栈不为空：当前运算符优先级小于等于栈顶， 栈顶入队列，同时当前运算符入栈
            else if (OPERATOR.matcher(ele).matches()) {
                if (stack.isEmpty()) {
                    stack.push(ele);
                } else {
                    if (prior(ele) <= prior(stack.peek())) {
                        queue.enqueue(stack.pop());
                    }
                    stack.push(ele);
                }
            }
        }
        // 遍历结束时，将栈中元素放入队列
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.dequeue());
            result.append(",");
        }
        return String.valueOf(result.deleteCharAt(result.length() - 1));
    }

    /**
     * 计算后缀表达式
     * @param suffixExpr 后缀表达式，逗号分隔
     * @return 结果
     */
    public int calculateSuffix(String suffixExpr) {
        //TODO validate
        MyStack<Integer> stack = new MyStack<>();
        // 循环遍历后缀表达式
        for (String ele : suffixExpr.split(",")) {
            // 操作数: 入栈
            if (NUMBER.matcher(ele).matches()) {
                stack.push(Integer.valueOf(ele));
            } else if (OPERATOR.matcher(ele).matches()){
                // 运算符: 出栈, 计算, 入栈
                convert(ele).ifPresent(opt -> {
                    Integer num2 = stack.pop();
                    Integer num1 = stack.pop();
                    stack.push(opt.apply(num1, num2));
                });
            }

        }
        return stack.pop();
    }

    private int prior(String opt) {
        int priority = 0;
        if ("+".equals(opt) || "-".equals(opt)) {
            priority = 1;
        } else if ("*".equals(opt) || "/".equals(opt)) {
            priority = 2;
        }
        return priority;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        System.out.println(calculator.calculate("3+2*5-4"));
//        System.out.println(calculator.toSuffixExpression("(1+(4+5+2)-3)+(6+8)"));
        String expr = calculator.toSuffixExpression("1+((2+3)*4)-5");
        System.out.println(expr);
        System.out.println(calculator.calculateSuffix(expr));
//        Pattern test = Pattern.compile("(\\d*)([-+*/])");
//        Matcher matcher = test.matcher("3+2*5-4");
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }
    }

}
