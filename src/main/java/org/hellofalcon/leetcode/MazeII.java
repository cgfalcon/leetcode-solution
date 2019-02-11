package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.MazeUtils;
import org.hellofalcon.leetcode.utils.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 505. The Maze II
 *
 * Find the shortest path
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class MazeII {

    final int WALL = 1;
    final int SPACE = 0;

    final int[][] neighbourDir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}}; // index : 0 - row, 1 - col

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (isWall(maze, start[0], start[1])) {
            return -1;
        }

        if (reachDest(destination, start[0], start[1])) {
            return 0;
        }

        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int[] currentPosition = null;
        distance[start[0]][start[1]] = 0;
        while ((currentPosition = queue.poll()) != null) {
            int row = currentPosition[0];
            int col = currentPosition[1];

            // for all the 4 neighbours of current position
            for (int i = 0; i < 4; i++) {
                int nRow = row + neighbourDir[i][0]; // neighbour row
                int nCol = col + neighbourDir[i][1]; // neighbour col
                int ramble = 0;

                // keep going when there is no wall
                while (!isWall(maze, nRow, nCol)) {
                    nRow += neighbourDir[i][0];
                    nCol += neighbourDir[i][1];
                    ramble++;
                }

                // To get here, means current position is a wall, so the coordinate should be adjusted
                int lastRow = nRow - neighbourDir[i][0];
                int lastCol = nCol - neighbourDir[i][1];

                if (distance[row][col] + ramble < distance[lastRow][lastCol]) {
                    // not visited
                    distance[lastRow][lastCol] = distance[row][col] + ramble;
                    queue.add(new int[]{lastRow, lastCol});
                }
            }

        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?  -1 : distance[destination[0]][destination[1]];

    }


    private boolean reachDest(int[] destination, int row, int col) {
        return destination[0] == row && destination[1] == col;
    }

    private boolean isWall(int[][] maze, int row, int col) {
        if (row < 0 || row >= maze.length || col >= maze[0].length || col < 0) {
            return true;
        }

        if (maze[row][col] == WALL) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String mazeStr = "0 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 1 0\n" +
                "1 1 0 1 1\n" +
                "0 0 0 0 0";

        int[][] maze = MazeUtils.readMaze(mazeStr, 5, 5);
        ArrayUtils.printArray(maze);

        MazeII mz = new MazeII();
        int path = mz.shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4});
        System.out.println(path);
    }
}
