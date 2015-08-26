package org.hellofalcon.leetcode.utils;

/**
 * @author: chugang.cg
 * @date: 2015/8/20.
 */
public class ArrayUtils {

    public static void printArray(int[] nums) {
        System.out.print("[ ");
        for(int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ]");
    }
}
