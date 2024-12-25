package BackTrack;

/**
 * N皇后问题的求解
 * 递归 + 回溯
 */
public class Nqueen {

    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int Nqueen (int n) {
        // write code here
        char[][] chess = new char[n][n];
        //初始化棋盘
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                chess[i][j] = '.';
            }
        }
        return solve(chess, 0);
    }

    //求解棋盘上特定的行与列
    private int solve(char[][] chess, int row) {
        int len = chess.length;
        //找到一个解的标志
        if (row == len) {
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < len; ++i) {

            if (isValid(chess, row, i)) {
                chess[row][i] = 'Q';
                //将所有解的数目求和
                ret += solve(chess, row + 1);
                chess[row][i] = '.';
            }
        }
        return ret;
    }

    //验证在该位置上摆放棋盘是否有效
    private boolean isValid(char[][] chess, int row, int col) {
        if (row == 0) {
            return true;
        }
        int len = chess.length;
        for (int i = 0; i < row; ++i) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; --i, ++j) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
