package org.hellofalcon.leetcode;

import java.util.Arrays;

/**
 * No.268. Missing Number
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class MissingNumber {

    /**
     * an array containing n distinct numbers taken from 0, 1, 2, ..., n
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // this array, started from 0, so the count of array is n+1

        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        int[] input = new int[]{9,6,4,2,3,5,7,0,1};
        int i = mn.missingNumber(input);
        assert i == 8;

        int[] input2 = new int[]{3,0,1};
        int i2 = mn.missingNumber(input2);
        assert i2 == 2;
    }
}
