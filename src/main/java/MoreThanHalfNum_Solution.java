public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {

        int num = array[0];
        int count = 1;
        int i = 1;
        for (; i < array.length; ++i) {
            if (array[i] == num) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                if (i < array.length - 1) {
                    num = array[++i];
                } else {
                    num = array[i];
                }
                ++count;
            }
        }

        return num;

    }
}
