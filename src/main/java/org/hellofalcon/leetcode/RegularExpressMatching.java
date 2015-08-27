package org.hellofalcon.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: chugang.cg
 * @date: 2015/8/27.
 */
public class RegularExpressMatching {

    /**
     * A cheat solution
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        Pattern pt = Pattern.compile(p);
        final Matcher matcher = pt.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        RegularExpressMatching re = new RegularExpressMatching();
        System.out.println(re.isMatch("aa","a") 		);
        System.out.println(re.isMatch("aa","aa") 		);
        System.out.println(re.isMatch("aaa","aa")     ) ;
        System.out.println(re.isMatch("aa", "a*")     ) ;
        System.out.println(re.isMatch("aa", ".*")     ) ;
        System.out.println(re.isMatch("ab", ".*")     ) ;
        System.out.println(re.isMatch("aab", "c*a*b") ) ;
        System.out.println(re.isMatch("", ".*"));
    }
}
