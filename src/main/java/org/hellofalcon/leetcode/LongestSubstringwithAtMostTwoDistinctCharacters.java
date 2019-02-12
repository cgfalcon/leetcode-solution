package org.hellofalcon.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 *
 * use a slide window solution
 *
 * @author - chugang.cg
 * @create - 2019/2/12
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return findSubtringWithKDistinctCharacter(s, 2);
    }

    private int findSubtringWithKDistinctCharacter(String s, int k) {
        Map<Character, Integer> chDict = new HashMap<>();

        int ans = 0;
        int i = 0;
        int j = 0;
        int len = s.length();
        while (i < len && j < len) {
            Character curChar = s.charAt(j);
            chDict.put(curChar, chDict.getOrDefault(curChar, 0) + 1); // increase the count of current character

            while (chDict.size() > k) {
                // once the dict size exceed the limit, we should evict some elements
                // to achieve that, we should increase the left index
                Character leftChar = s.charAt(i++);
                chDict.put(leftChar, chDict.get(leftChar) - 1) ;
                if (chDict.get(leftChar) == 0) {
                    chDict.remove(leftChar);
                }

            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters lk = new LongestSubstringwithAtMostTwoDistinctCharacters();

        System.out.println(lk.lengthOfLongestSubstringTwoDistinct("abbbac")); // 5
        System.out.println(lk.lengthOfLongestSubstringTwoDistinct("abcdefg")); // 2
        System.out.println(lk.lengthOfLongestSubstringTwoDistinct("abbbbbbb")); // 8
        System.out.println(lk.lengthOfLongestSubstringTwoDistinct("abacccccc")); // 7
        System.out.println(lk.lengthOfLongestSubstringTwoDistinct("")); // 0
    }
}
