package org.hellofalcon.leetcode;

/**
 *
 * 240. Search a 2D Matrix II
 *
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int x = 0; // start from first row
        int y = col - 1; // start from right most column

        while (x < row && col >= 0) {

            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] > target) {
                // because the column is sorted in ascending order, so we increase x here.
                // after x increased, we also excluded the previous row
                x++;
            } else {
                y--;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Search2DMatrix s2d = new Search2DMatrix();
        assert s2d.searchMatrix(input, 9);

        assert s2d.searchMatrix(input, 20);
    }
}
