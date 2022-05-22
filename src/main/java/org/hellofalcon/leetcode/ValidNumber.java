package org.hellofalcon.leetcode;

/**
 * @author: chugang.cg
 * @date: 2015/9/5.
 */
public class ValidNumber {

    public ValidNumber() {
    }

    int current = 0;
    String s;
    char c;

    public boolean isNumber(String s) {
        this.s = s;
        this.current = 0;
        this.c = s.charAt(current);

        consumeSpace();
        if(c == 0) return false;

        if(c == '+' || c == '-' ) {
            next();
        }

        boolean intpart = consumeNumber();
        boolean frac = false;

        if (c == '.') {
            next();
            frac = consumeNumber();
            if(!intpart && !frac) return false;
        }

        if (c == 'e') {
            if(!intpart && !frac) return false;

            next();
            if (c == '+' || c == '-') { next(); }
            boolean exp = consumeNumber();
            if (!exp) {
                return false;
            }
        }

        consumeSpace();
        if(c == 0) return true;

        return false;
    }

    public boolean consumeNumber() {
        boolean result = false;
        if(isDigit(c)) {
            result = true;
        }
        while(c != 0 && isDigit(c)) {
            next();
        }
        return result;
    }

    public void consumeSpace() {
        while(c != 0 && isSpace(c)) {
            next();
        }
    }

    public boolean isSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    public boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public char next() {
        current += 1;
        if(current >= s.length()) {
            c = 0;
            return c;
        } else {
            c = s.charAt(current);
            return c;
        }
    }


    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println('0' == 0);
        System.out.println(vn.isNumber("123"));
        System.out.println(vn.isNumber("123.321"));
        System.out.println(vn.isNumber("  2 da"));
        System.out.println(vn.isNumber("2e10"));
        System.out.println(vn.isNumber("123.34e12"));
        System.out.println(vn.isNumber(" 1.0 "));
        System.out.println(vn.isNumber(".1"));
        System.out.println(vn.isNumber(" "));
        System.out.println(vn.isNumber("e9"));
        System.out.println(vn.isNumber(".2e81"));
    }
}
