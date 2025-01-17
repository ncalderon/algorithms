package com.test;

import java.util.LinkedList;

public class StringCalculate {


    private static int applyOperation(String op, int b, int a)
    {
        switch (op)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case "**":
                return (int)Math.pow(a + 0.0, b + 0.0);
        }
        return 0;
    }
    private static boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;
    }

    /**
     * Challenge
     * Have the function StringCalculate(str) take the str parameter being passed and evaluate the mathematical expression within in.
     * The double asterisks (**) represent exponentiation.
     *
     * For example, if str were "(2+(3-1)*3)**3" the output should be 512. Another example: if str is "(2-0)(6/2)" the output should be 6. T
     * here can be parenthesis within the string so you must evaluate it properly according to the rules of arithmetic.
     * The string will contain the operators: +, -, /, *, (, ), and **. If you have a string like this: #/#*# or #+#(#)/#, then evaluate from left to right.
     * So divide then multiply, and for the second one multiply, divide, then add. The evaluations will be such that there will not be any decimal operations,
     * so you do not need to account for rounding.
     *
     * Sample Test Cases
     * Input:"6*(4/2)+3*1"
     *
     * Output:15
     *
     * Input:"100*2**4"
     *
     * Output:1600
     *
     * @param str
     * @return
     */
    public static String StringCalculate(String str) {
        char[] tokens = str.toCharArray();

        LinkedList<Integer> values = new LinkedList<>();

        LinkedList<String> operators = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Skip blank characters
            if (tokens[i] == 32)
                continue;

            if (tokens[i] >= 48 && tokens[i] <= 57)
            {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= 48 && tokens[i] <= 57){
                    sb.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));
                i--;
            }
            else if (tokens[i] == '(') {
                operators.push(tokens[i] + "");
            } else if (tokens[i] == ')') {
                if(operators.peek().equals("(")){
                    operators.pop();
                    operators.push("*");
                    continue;
                }
                while (!operators.peek().equals("(")) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
                if(i+1 != tokens.length && tokens[i+1] == '(')
                    operators.push("*");
            } else if(tokens[i] == '*' && tokens[i+1] == '*'){
                operators.push("**");
                i+=2;
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= 48 && tokens[i] <= 57){
                    sb.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));
                i--;
                values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
            }
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                String op = tokens[i] + "";

                while (!operators.isEmpty() && hasPrecedence(op, operators.peek())){
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(op);
            }
        }
        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }
        return values.pop().toString();
    }


}
