package org.hellofalcon.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 上没有原题
 *
 * @author - chugang.cg
 * @create - 2019/2/12
 */
public class HigestFive {

    static class Record {
        int score;
        int id;

        public Record(int id, int score) {
            this.score = score;
            this.id = id;
        }


    }

    public static void main(String[] args) {
        int k = 4;
        PriorityQueue<Record> pq = new PriorityQueue<>(k, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.score - o2.score;
            }
        });

        pq.add(new Record(1, 3));
        pq.add(new Record(1, 2));
        pq.add(new Record(1, 1));
        pq.add(new Record(1, 9));
        pq.add(new Record(1, 4));
        pq.add(new Record(1, 8));

        while (pq.size() != 0) {
            System.out.println(pq.poll().score);
        }

    }
}
