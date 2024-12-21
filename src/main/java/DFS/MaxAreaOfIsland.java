package DFS;

/**
 * 给定一个由0 和 1 组成的非空二维数组grid，用来表示海洋岛屿地图。
 * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 链接：https://leetcode.cn/problems/ZL6zAn
 */
public class MaxAreaOfIsland {

    private final int SEA = 0;

    private final int LAND = 1;

    private final int VISITED = 2;


    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == LAND) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;

    }

    private int dfs(int[][] grid, int x, int y) {

        if (!isInGrid(grid, x, y)) {
            return 0;
        }

        if (grid[x][y] != LAND) {
            return 0;
        }

        grid[x][y] = VISITED;

        return 1 +
                dfs(grid, x + 1, y) +
                dfs(grid, x - 1, y) +
                dfs(grid, x, y + 1) +
                dfs(grid, x, y - 1);
    }

    private boolean isInGrid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

}
