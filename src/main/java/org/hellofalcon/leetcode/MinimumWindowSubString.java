package org.hellofalcon.leetcode;

/**
 * @author chugang.cg
 * @create - 2022/4/26.
 */
public class MinimumWindowSubString {

    public static void main(String[] args) {
        MinimumWindowSubString mws = new MinimumWindowSubString();
        String ret = mws.minWindow("a","a");
        System.out.println(ret);
    }

        public String minWindow(String s, String t) {

            if (s == null || t == null) {
                return "";
            }

            if (s.length() < t.length()) {
                return "";
            }

            int subStrLen = t.length();
            for (int i = subStrLen; i <= s.length(); i++) {
                int offset = 0;
                while (offset + i <= s.length()) {
                    String subString = s.substring(offset, offset + i);
                    if (isSubstringContainsT(subString, t)) {
                        return subString;
                    }
                    offset++;
                }

            }

            return "";
        }

        private boolean isSubstringContainsT(String subString, String t) {
            char[] chars = t.toCharArray();
            boolean[] cb = new boolean[t.length()];
            boolean allContains = true;
            for(int i = 0; i < chars.length; i++) {
                if (subString.indexOf(chars[i]) < 0) {
                    cb[i] = false;
                } else {
                    cb[i] = true;
                }
                allContains &= cb[i];
            }


            return allContains;
        }
}


