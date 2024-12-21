package DFS;

import java.util.Random;

/**
 * 网格问题的通解框架
 * DFS，递归加回溯实现
 */
public class GridProblem {

    private final static int SEA = 0;
    private final static int ISLAND = 1;
    private final static int VISITED = 2;

    public static void main(String[] args) {
        int[][] grid = new int[10][10];
        generateRandomGrid(grid);
        int x = 0, y = 0;
        dfs(grid, x, y);

    }

    /**
     * 生成一个随机的m * n网格
     */
    public static void generateRandomGrid(int[][] grid ) {
        Random random = new Random(14);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (random.nextBoolean()) {
                    grid[i][j] = ISLAND;
                } else {
                    grid[i][j] = SEA;
                }
            }
        }
        grid[0][0] = SEA;
    }

    public static void dfs(int[][] grid, int x, int y) {
        if (!isInGrid(grid, x, y)) {
            return;
        }
        if (grid[x][y] != SEA) {
            return;
        }
        grid[x][y] = VISITED;
        System.out.println(x + ", " + y);
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid,  x, y + 1);
        dfs(grid,  x, y - 1);
    }

    public static boolean isInGrid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
