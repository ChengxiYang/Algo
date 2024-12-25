package Matrix;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] lineFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    lineFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            if (lineFlag[i] == true) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            if (colFlag[j] == true) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
