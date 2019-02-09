package org.hellofalcon.leetcode;

/**
 * No.215
 * @author - chugang.cg
 * @create - 2019/2/8
 */
public class KthLargestElementInArrayV2 {

    class MaxQ {


        private int[] queue;

        private int size = 0;

        public MaxQ(int n) {
            queue = new int[n + 1];
        }

        public void add(int item) {
            int idx;
            for (idx = 0; idx < size; idx++) {
                if (queue[idx] < item) {
                    // find the place to insert item
                    break;
                }
            }

            if (idx > size) {
                return;
            }

            // move elements of queue backward
            for (int mi = size - 1; mi >= idx; mi--) {
                queue[mi + 1] = queue[mi];
            }

            queue[idx] = item;
            if (size + 1 >= queue.length) {
                size = queue.length - 1;
            } else {
                size++;
            }
        }

        public int min() {
            return queue[size - 1];
        }

        public void print() {
            for (int i : queue) {
                System.out.print(i + " ");
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {
        MaxQ maxQ = new MaxQ(k );

        for (int num : nums) {
            maxQ.add(num);
        }

        return maxQ.min();

    }


    public static void main(String[] args) {
        KthLargestElementInArrayV2 lke = new KthLargestElementInArrayV2();

        int[] input = new int[]{3, 5, 1, 2, 7, 9, 4, 8, 0};

        System.out.println(lke.findKthLargest(input, 3));

        int[] input2 = new int[]{2, 1};

        System.out.println(lke.findKthLargest(input2, 2));
    }
}
