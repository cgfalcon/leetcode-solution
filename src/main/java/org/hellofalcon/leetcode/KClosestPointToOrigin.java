package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.973. K Closest Points to Origin
 *
 * @author - chugang.cg
 * @create - 2019/2/9
 */
public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
            public int compare(int[] input, int[] o2) {
                return distToOrigin(o2) - distToOrigin(input);
            }
        });

        for (int[] point : points) {
            queue.add(point);
            if (queue.size() > K) {
                queue.poll();
            }
        }

        int[][] kArray = new int[K][];
        for (int i = 0; i < K; i++) {
            kArray[i] = queue.poll();
        }

        return kArray;

    }

    private int distToOrigin(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}, {1, 1}};

        KClosestPointToOrigin kClosestPointToOrigin = new KClosestPointToOrigin();
        int[][] pts = kClosestPointToOrigin.kClosest(points, 2);

        ArrayUtils.printArray(pts);


    }

}
