package org.hellofalcon.leetcode;


import org.hellofalcon.leetcode.utils.ArrayUtils;

/**
 * @author: chugang.cg
 * @date: 2015/8/20.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int another = nums[j];
                if((current + another) == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum tw = new TwoSum();
        int[] nums = new int[]{2,3,4,1,7};
        int[] result = tw.twoSum(nums, 5);
        ArrayUtils.printArray(result);
    }
}
