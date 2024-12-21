package DFS;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 */
public class IslandPerimeter {

    private final int SEA = 0;

    private final int LAND = 1;

    private final int VISITED = 2;

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == LAND) {
                    perimeter =  dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return perimeter;


    }

    private int dfs(int[][] grid, int x, int y) {

        if (!isInGrid(grid, x, y)) {
            return 1;
        }

        if (grid[x][y] == SEA) {
            return 1;
        }

        if (grid[x][y] == VISITED) {
            return 0;
        }

        grid[x][y] = VISITED;

        return  dfs(grid, x + 1, y) +
                dfs(grid, x - 1, y) +
                dfs(grid, x, y + 1) +
                dfs(grid, x, y - 1);
    }

    private boolean isInGrid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
