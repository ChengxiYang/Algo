package ACM;

import java.util.*;

/**
 *  逐行读取并解析生成矩阵每行数据， 一直读直到没有行输入，完成矩阵内容初始化
 */
public class MatrixTransDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        String line = null;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                // 碰到空行时、退出循环
                break;
            }
            String[] tokens = line.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String token : tokens) {
                row.add(Integer.parseInt(token));
            }
            matrix.add(row);
        }

        int rows = matrix.size();
        int columns = matrix.get(0).size();
        // 转置矩阵并输出结果
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix.get(j).get(i));
                //注意数字之间的空格
                if (j < rows - 1) {
                    System.out.print(" ");
                }
            }
            //输出空行
            System.out.println();
        }
        scanner.close();
    }
}