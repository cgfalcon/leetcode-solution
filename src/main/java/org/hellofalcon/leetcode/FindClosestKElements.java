package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No.658. Find K Closest Elements
 *
 * @author - chugang.cg
 * @create - 2019/2/1
 */
public class FindClosestKElements {

    class MinQ {
        private int[] queue;

        private int size = 0;

        public MinQ(int n) {
            queue = new int[n + 1];
        }

        public void add(int item, int x) {
            int idx;
            for (idx = 0; idx < size; idx++) {
                if (Math.abs(queue[idx] - x) > Math.abs(item - x)) {
                    // find the place to insert item
                    break;
                } else if ((Math.abs(queue[idx] - x) ==  Math.abs(item - x)) && (queue[idx] > item)){
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

        public Integer poll() {
            if (size >= 0) {
                int i = size--;
                return queue[i - 1];
            } else {
                return null;
            }
        }

        public Integer get(int i) {
            if (i > size) {
                return null;
            }
            return queue[i];
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        MinQ minQ = new MinQ(k);

        for (int i : arr) {
            minQ.add(i, x);
        }

        minQ.print();

        List<Integer> cl = new ArrayList<Integer>();

        for (int i = 0; i < k; i++) {
            cl.add(minQ.poll());
        }

        Collections.sort(cl);
        return cl;
    }

    public static void main(String[] args) {
        FindClosestKElements fk = new FindClosestKElements();

        int[] input = new int[]{1, 2, 3, 4, 5};
        List<Integer> closestElements = fk.findClosestElements(input, 4, 3);

        ListUtils.printList(closestElements);
    }

}
