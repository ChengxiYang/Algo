package Math;

public class TitleToNumber {
    /**
     * 利用霍纳法则即可
     */
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            System.out.println(columnTitle.charAt(i) - 'A' + 1);
            sum = sum * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
