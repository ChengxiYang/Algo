package DFS;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 */
public class NumIslands {

    private final char SEA = '0';

    private final char LAND = '1';

    private final char VISITED = '2';

    //2024.12.24 重温此题
    public int numIslands(char[][] grid) {

        int cnt = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == LAND) {
                    ++cnt;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;


    }

    private void dfs(char[][] grid, int x, int y) {

        if (!isInGrid(grid, x, y)) {
            return;
        }

        if (grid[x][y] != LAND) {
            return;
        }

        grid[x][y] = VISITED;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean isInGrid(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

}
