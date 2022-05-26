package org.hellofalcon.leetcode;

/**
 * @author chugang.cg
 * @create - 2022/5/25.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int h = grid.length;
        int w = grid[0].length;

        for (int i = 0 ; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    // try to seek the four directions of current position
                    visit(grid, h, w, i, j);
                }
            }
        }

        return islandCount;
    }

    private void visit(char[][] grid, int h, int w, int i, int j) {
        if (i < 0 || j <0 || i >= h || j >= w) {
            // index out of bound
            return;
        }

        if (grid[i][j] != '1') {
            // for position with char '2' or '0', we just return to ignore them
            return;
        }

        grid[i][j] = '2';

        visit(grid, h, w, i + 1, j);
        visit(grid, h, w, i - 1, j);
        visit(grid, h, w, i, j + 1);
        visit(grid, h, w, i, j - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands ni = new NumberOfIslands();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        int num = ni.numIslands(grid);
        System.out.println(num);
    }


}
