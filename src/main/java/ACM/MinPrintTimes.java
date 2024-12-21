package ACM;


import java.util.Scanner;

class Solution {

    public int calculateStrPrintTimes(String str) {
        int times = 0;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; ++i) {

            if (i == 0 && Character.isLowerCase(charArr[i])) {
                times += 1;
            }  else if (i == 0 && Character.isUpperCase(charArr[i])) {
                times += 2;
            }
            else if (Character.isLowerCase(charArr[i]) && Character.isUpperCase(charArr[i-1])) {
                times += 2;
            }
            else if (Character.isUpperCase(charArr[i]) && Character.isLowerCase(charArr[i-1])){
                times += 2;
            } else if (Character.isAlphabetic(charArr[i])){
                times += 1;
            }
        }
        return times;
    }
}

public class MinPrintTimes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        //先处理第一行获取行数
        String line = scanner.nextLine();
        int lines = Integer.parseInt(line.trim());
        for (int i = 1; i <= lines; ++i) {
            line = scanner.nextLine();
            System.out.println("" + solution.calculateStrPrintTimes(line.trim()));
        }
    }
}
