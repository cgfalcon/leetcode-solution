package org.hellofalcon.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    public int findKthLargestByQueue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer t, Integer o) {
                return t - o;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] largestNums = new int[k];
        for (int i = 0; i < k; i++) {
            largestNums[i] = pq.poll();
        }
        return largestNums[k - 1];
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
        System.out.println(kl.findKthLargestByQueue(arr, 1));
        System.out.println(kl.findKthLargestByQueue(arr, 2));
        System.out.println(kl.findKthLargestByQueue(arr, 3));
        System.out.println(kl.findKthLargestByQueue(arr, 4));
        System.out.println(kl.findKthLargestByQueue(arr, 5));
        System.out.println(kl.findKthLargestByQueue(arr, 6));

        int[] arr2 = new int[]{2,1};
        System.out.println(kl.findKthLargestByQueue(arr2, 1));
    }
}
