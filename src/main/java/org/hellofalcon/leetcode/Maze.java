package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.MazeUtils;
import org.hellofalcon.leetcode.utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 490. The Maze
 *
 * BFS
 *
 * @author - chugang.cg
 * @create - 2019/2/11
 */
public class Maze {

    final int WALL = 1;
    final int SPACE = 0;

    final int[][] neighbourDir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}}; // index : 0 - row, 1 - col

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (isWall(maze, start[0], start[1])) {
            return false;
        }

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int[] currentPosition = null;
        visited[start[0]][start[1]] = true;
        while ((currentPosition = queue.poll()) != null) {
            int row = currentPosition[0];
            int col = currentPosition[1];

            // whether is destination
            if (reachDest(destination, row, col)) {
                return true;
            }

            // for all the 4 neighbours of current position
            for (int i = 0; i < 4; i++) {
                int nRow = row + neighbourDir[i][0]; // neighbour row
                int nCol = col + neighbourDir[i][1]; // neighbour col

                // keep going when there is no wall
                while (!isWall(maze, nRow, nCol)) {
                    nRow += neighbourDir[i][0];
                    nCol += neighbourDir[i][1];
                }

                // To get here, means current position is a wall, so the coordinate should be adjusted
                int lastRow = nRow - neighbourDir[i][0];
                int lastCol = nCol - neighbourDir[i][1];

                if (!isWall(maze, lastRow, lastCol) && !visited[lastRow][lastCol]) {
                    // not visited
                    visited[lastRow][lastCol] = true;
                    queue.add(new int[]{lastRow, lastCol});
                }
            }

        }

        return false;
    }

    private boolean reachDest(int[] destination, int row, int col) {
        return destination[0] == row && destination[1] == col;
    }

    public boolean isWall(int[][] maze, int row, int col) {
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

        Maze mz = new Maze();
        boolean b = mz.hasPath(maze, new int[]{0, 4}, new int[]{3, 2});
        System.out.println(b);
    }
}
