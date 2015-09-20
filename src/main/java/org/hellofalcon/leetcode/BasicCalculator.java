package org.hellofalcon.leetcode;

import java.util.ArrayDeque;

/**
 * ( 1 + 2 ) + 3 => 6
 * 1 + 3 - 1 + (2 + 1) => 6
 * (1) + 2 - 1 => 2
 * @author: chugang.cg
 * @date: 2015/9/18.
 */
public class BasicCalculator {

    ArrayDeque<Integer> numStack = new ArrayDeque<Integer>();

    /**
     * Operator Priority: + - ( )
     */
    ArrayDeque<Character> opStack = new ArrayDeque<Character>();

    int current;
    char c;
    String s;

    public int calculate(String s) {
        this.current = 0;
        this.c = s.charAt(this.current);
        this.s = s;

        while(c != 0) {
            evalExpr();
        }

        while(!opStack.isEmpty()) {
            final Character op = opStack.pop();
            if(op == '+' || op == '-') {
                final Integer opt2 = numStack.pop();
                final Integer opt1 = numStack.pop();
                numStack.push(eval(op, opt1, opt2));
            }
        }

        return numStack.pop();
    }

    private void evalExpr() {
        if(isDigit(c)) {
            int digit = digit();
            if(opStack.isEmpty() || opStack.peek() == '(') {
                numStack.push(digit);
            } else {
                final Character op = opStack.pop();
                final int opt1 = numStack.pop();
                numStack.push(eval(op, opt1, digit));
            }
        } else if(isWhiteSpace(c)) {
            WS();
        } else if('+' == c || '-' == c) {
            opStack.push(c);
            next();
        } else if('(' == c) {
            opStack.push(c);
            int expr = paramExpr();
            if(opStack.isEmpty() || opStack.peek() == '(') {
                numStack.push(expr);
            } else {
                final Character op = opStack.pop();
                final int opt1 = numStack.pop();
                numStack.push(eval(op, opt1, expr));
            }
        } else if (')' == c) {
            if(opStack.peek() == '(') {
                opStack.pop(); // pop (
                next();
            } else {
                final Character op = opStack.pop();
                final int opt2 = numStack.pop();
                final int opt1 = numStack.pop();
                numStack.push(eval(op, opt1, opt2));
            }
        }
        else {
            next();
        }
    }


    private Integer eval(char op, int opt1, int digit) {
        if('+' == op)  {
            return opt1 + digit;
        } else if('-' == op) {
            return opt1 - digit;
        } else {
            throw new IllegalStateException("Unsupported operator");
        }
    }

    private int paramExpr() {
        next(); // consume (
        while(c != ')') {
            evalExpr();
        }

        if(opStack.peek() == '(') {
            opStack.pop(); // pop (
            next();
        } else {
            final Character op = opStack.pop();
            final int opt2 = numStack.pop();
            final int opt1 = numStack.pop();
            numStack.push(eval(op, opt1, opt2));
        }
        return numStack.pop();
    }

    private int digit() {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(c);
            next();
        } while(isDigit(c));

        return Integer.parseInt(sb.toString());
    }

    private void WS() {
        while(isWhiteSpace(c)) {
            next();
        }
    }


    private void next() {
        if(this.current + 1 >= s.length()) {
            c = 0;
        } else {
            this.current += 1;
            this.c = this.s.charAt(this.current);
        }
    }

    private boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String input = "14 - 43 + 43";
        final int solution = bc.calculate(input);
        System.out.println(solution);

        System.out.println(bc.calculate("12"));

        System.out.println(bc.calculate("(3)"));

        System.out.println(bc.calculate("(4) + (5)"));

        System.out.println(bc.calculate("(7)-(0)+(4)"));

        System.out.println(bc.calculate("1-(5)"));

        System.out.println(bc.calculate("12 -12+12"));

        System.out.println(bc.calculate("(1 + 3)"));

        System.out.println(bc.calculate("1 + (212 + 12) - 212"));

        System.out.println(bc.calculate("(1 +2 + (123 - 123))"));

        System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));

        System.out.println(bc.calculate("2-(5-6)"));
    }
}
