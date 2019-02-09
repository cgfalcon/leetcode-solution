package org.hellofalcon.leetcode;

/**
 * @author - chugang.cg
 * @create - 2019/2/8
 */
public class LongestPalindromeSubtring {

    public String longestPalindrome(String s) {
        int length = s.length();
        while (length > 0) {
            for (int i = 0; i + length - 1 < s.length(); i++) {
                int left = i;
                int right = i + length - 1;
                while(left <= right) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        break;
                    }
                }

                if (left > right) {
                    return s.substring(i, i + length);
                }

            }

            length--;
        }

        return "";

    }

    public static void main(String[] args) {
        LongestPalindromeSubtring lps = new LongestPalindromeSubtring();
        System.out.println(lps.longestPalindrome("abaaba"));
    }
}
