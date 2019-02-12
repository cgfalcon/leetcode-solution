package org.hellofalcon.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * use a slide window solution
 *
 * @author - chugang.cg
 * @create - 2019/2/12
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int ans = 0;
        int i = 0;
        int j = 0;
        int len = s.length();
        while (i < len && j < len) {
            if(!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                // has duplicated char, so we should move window
                // remove the first char, because it not belong to the set anymore
                charSet.remove(s.charAt(i++));
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(ls.lengthOfLongestSubstring("abcdefg"));
        System.out.println(ls.lengthOfLongestSubstring("abacdefg"));
        System.out.println(ls.lengthOfLongestSubstring("abcaaadefg"));
        System.out.println(ls.lengthOfLongestSubstring("abcdefgaqwertyuiop"));
        System.out.println(ls.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(ls.lengthOfLongestSubstring("ababbbbb"));
        System.out.println(ls.lengthOfLongestSubstring("*2_12-mlaoi;'[].,/"));
    }

}
