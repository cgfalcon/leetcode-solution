package org.hellofalcon.leetcode.common;

/**
 * @author - chugang.cg
 * @create - 2019/2/11
 */
public class MazeUtils {

    /**
     *
     * @param input
     * @param m rows of maze
     * @param n cols of maze
     * @return
     */
    public static int[][] readMaze(String input, int m, int n) {
        int[][] maze = new int[m][n];

        int row = 0;
        int col = 0;
        for (char ch :input.toCharArray()) {
            if (Character.isDigit(ch)) {
                maze[row][col++] = ch == '0' ? 0 : 1;
                if (col >= n) {
                    row++;
                    col = 0;
                }
            }

            if (row == m - 1 && col == n - 1) {
                break;
            }
        }

        if (row != m - 1 || col != n - 1) {
            throw new IllegalArgumentException("Not valid input for a maze");
        }

        return maze;
    }

}
