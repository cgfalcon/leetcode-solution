package org.hellofalcon.leetcode;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author: chugang.cg
 * @date: 2015/8/28.
 */
public class KthLargestElementInArray {

    /**
     * Space: o(n)
     * time: o(n)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // sort first
//        sort(nums);
        Arrays.sort(nums);
        // pick k th
        return nums[nums.length - k];
    }

    public void sort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        qsort(nums, start, end);
    }

    public void qsort(int[] nums, int start, int end) {
        int mid = (end - start) / 2;

    }

    public static void main(String[] args) {
        KthLargestElementInArray kl = new KthLargestElementInArray();
        int[] arr = new int[]{2,5,1,7,5,9};
        System.out.println(kl.findKthLargest(arr, 1));
        System.out.println(kl.findKthLargest(arr, 2));
        System.out.println(kl.findKthLargest(arr, 3));
        System.out.println(kl.findKthLargest(arr, 4));
        System.out.println(kl.findKthLargest(arr, 5));
        System.out.println(kl.findKthLargest(arr, 6));

        int[] arr2 = new int[]{2,1};
        System.out.println(kl.findKthLargest(arr2, 1));
    }
}
