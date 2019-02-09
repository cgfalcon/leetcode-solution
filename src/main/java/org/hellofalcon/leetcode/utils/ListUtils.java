package org.hellofalcon.leetcode.utils;

import java.util.List;

/**
 * @author - chugang.cg
 * @create - 2019/2/9
 */
public class ListUtils {

    public static void printList(List list) {
        if (list == null) {
            return;
        }
        System.out.print("[ ");
        for(int i = 0; i < list.size(); i ++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(" ]");
    }
}
