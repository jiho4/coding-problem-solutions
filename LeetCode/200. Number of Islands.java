package leetcode;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/submissions/560574857/
 * solved: 2021-09-25
 */
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                // if we found the island, increase the counter and check the neighbors
                if (grid[x][y] == '1') {
                    count++;
                    checkNeighbors(grid, x, y);
                } else {}
            }
        }

        return count;
    }

    public void checkNeighbors(char[][] grid, int x, int y) {
        // do nothing when it reaches out of the bound
        if (x < 0 || x >= grid.length
         || y < 0 || y >= grid[0].length
         || grid[x][y] == '0') {
            // do nothing
        } else {
            // mark the visited island
            grid[x][y] = '0';

            // call recursive to four-way
            checkNeighbors(grid, x - 1, y);
            checkNeighbors(grid, x + 1, y);
            checkNeighbors(grid, x, y - 1);
            checkNeighbors(grid, x, y + 1);
        }
    }
}
