package org.hellofalcon.leetcode;

import java.util.*;

/**
 * 819. Most Common Word
 *
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        String p1 = paragraph.toLowerCase();
        String[] words = p1.replaceAll("[^a-zA-Z]", " ").trim().split("\\s+");

        Arrays.sort(words);

        String mostCommonWord = "";
        int mostCommonWrodFreq = 0;
        String lastWord = "";
        int wordHit = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if ("".equals(word)) {
                continue;
            }

            if (bannedSet.contains(word)) {
                continue;
            }

            if (!word.equals(lastWord)) {
                if (wordHit > mostCommonWrodFreq) {
                    mostCommonWord = lastWord;
                    mostCommonWrodFreq = wordHit;
                }
                // reset to next word
                wordHit = 1;
                lastWord = word;
            } else {
                wordHit++;
            }

        }

        // corner case
        if (wordHit > mostCommonWrodFreq) {
            mostCommonWord = lastWord;
        }

        return mostCommonWord;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String s : banned) {
            bannedSet.add(s);
        }

        Map<String, Integer> count = new HashMap<String, Integer>();

        String ans = null;
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch: paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if(sb.length() > 0) {
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    if (count.get(word) > freq) {
                        ans = word;
                        freq = count.get(word);
                    }
                }

                sb = new StringBuilder();
            }

        }

        // corner case
        if (sb.length() > 0) {
            String word = sb.toString();
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
                if (count.get(word) > freq) {
                    ans = word;
                    freq = count.get(word);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MostCommonWord mcw = new MostCommonWord();
        String s = mcw.mostCommonWord2("Bob", new String[]{});
        System.out.println(s);
    }
}
