package org.hellofalcon.leetcode;

/**
 * @author: chugang.cg
 * @date: 2015/8/21.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse2(123));
        System.out.println(ri.reverse2(-231));
        System.out.println(ri.reverse2(1534236469));
        System.out.println(ri.reverse2(-2147483648));
    }

    // has overflow problem
    public int reverse(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
        }

        int remain = x;
        int result = 0;
        while(remain != 0) {
            int d = remain % 10;
            if(result * 10 > Integer.MAX_VALUE ) {
                return 0;
            }
            result = result * 10 + d * sign;
            remain = remain / 10;
        }

        return sign * result;
    }

    public int reverse2(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
        }

        int remain = x;
        long result = 0;
        while(remain != 0) {
            int d = remain % 10;
            if(sign > 0 && result * 10 > Integer.MAX_VALUE) {
                return 0;
            }

            if(sign < 0 && result * 10 < Integer.MIN_VALUE) {
                return 0;
            }
            result = result * 10 + d;
            remain = remain / 10;
        }

        return (int)(result);
    }
}
