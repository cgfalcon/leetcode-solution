package org.hellofalcon.leetcode;

/**
 * @author: chugang.cg
 * @date: 2015/8/23.
 */
public class RomanInteger {

    /**
     * A Roman Number is a char sequence of [I, V, X, L, C, D, M].
     * For example, VII => 7, MCM => 1900, MDCLXVI => 1666, MDCCCXCIX => 1899.
     *
     * Steps for solution:
     * 1. reverse the roman number
     * 2. from left to right, for each roman number, if its previous number less than id, then do addition. otherwise do subtraction
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int pre = -1;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = numOfRoman(s.charAt(i));
            if(pre > current) {
                // subtract
                pre = pre - current;
                sum -= current;
            } else {
                // add
                sum += current;
                pre = current;
            }
        }

        return sum;
    }

    public int numOfRoman(char rn) {
        switch(rn) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }

    enum RomanNum {
        I('I', 1), V('V', 5), X('X', 10), L('L', 50), C('C', 100), D('D', 500),
        M('M', 1000);

        RomanNum(char mark, int value) {
            this.mark = mark;
            this.value = value;
        }

        char mark;
        int value;

        public static int getValueOf(char mark) {
            for(RomanNum rn : RomanNum.values()) {
                if(rn.getMark() == mark) {
                    return rn.getValue();
                }
            }

            return -1;
        }

        public int getValue() {
            return this.value;
        }

        public char getMark() {
            return this.mark;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String r1 = "VII";
        print(r1);

        String r2 = "MCM";
        print(r2);

        String r3 = "MDCLXVI";
        print(r3);

        String r4 = "MDCCCXCIX";
        print(r4);

        String r5= "MMMCMXCIX";
        print(r5);

        for(int i = 0; i < 3500; i++) {
            print(r5);
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    public static void print(String rm) {
        RomanInteger ri = new RomanInteger();
        System.out.println(rm + " => " + ri.romanToInt(rm));
    }
}
