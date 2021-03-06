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

    public static void printArrayWithIdx(int[] nums) {
        System.out.print("[ ");
        for(int i = 0; i < nums.length; i ++) {
            System.out.print("[" + i + "]: " + nums[i] + ", ");
        }
        System.out.println(" ]");
    }

    public static void printArray(Object[] nums) {
        System.out.print("[ ");
        for(int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ]");
    }

    public static void printArray(String[] nums) {
        System.out.print("[ ");
        for(int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ]");
    }


    public static void printArray(int[][] nums) {
        System.out.println("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" [ ");
            for(int j = 0; j < nums[i].length; j ++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
