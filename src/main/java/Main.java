import DynamicProgramming.LongestPalindrome;
import DynamicProgramming.MaxSubArray;
import DynamicProgramming.PileBox;
import Heap.HeapSort;
import Sort.QuickSort;
import Math.TitleToNumber;
import StringAlgorithm.LengthOfLastWord;
import Util.TreeNode;

/**
 * @author chengxiyang
 */
public class Main {

    public static void main(String[] args) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.longestPalindrome("ccc");
    }


    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        return s.equals(rs);
    }

}
