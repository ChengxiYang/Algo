package StringAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 链接：https://leetcode.cn/problems/length-of-last-word
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        List<String> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        final char space = ' ';
        int start = 0, end = 0;
        //利用指针技巧进行分词
        while (start < cs.length && end < cs.length) {
            if(space == cs[start]) {
                ++start;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                //note: 这里必须先判断数组是否越界
                for (end = start; end < cs.length && space != cs[end]; ++end) {
                    stringBuilder.append(cs[end]);
                }
                list.add(stringBuilder.toString());
                start = end;
            }
        }
        return list.get(list.size() - 1).length();

    }

    //利用String的api仅两行代码搞定
    public int lengthOfLastWord_(String s) {
        String[] sarr = s.split(" ");
        return sarr[sarr.length - 1].length();
    }


}
