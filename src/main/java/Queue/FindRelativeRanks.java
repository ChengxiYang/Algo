package Queue;

import java.util.*;

/**
 * @author chengxiyang
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.score > o2.score) {
                return -1;
            } else if (o1.score < o2.score) {
                return 1;
            } else {
                return 0;
            }
        });

        int count = 0;
        for (int s : score) {
            queue.offer(new Pair(s, count++));
        }
        count = 1;
        String[] ret = new String[score.length];
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (count == 1) {
                ret[pair.index] = "Gold Medal";
            } else if (count == 2) {
                ret[pair.index] = "Silver Medal";
            } else if (count == 3) {
                ret[pair.index] = "Bronze Medal";
            } else {
                ret[pair.index] = "" + count;
            }
            ++count;
        }

        List<Integer> list = new ArrayList<>();
        Collections.sort(list, (a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });
        return ret;
    }

    static class Pair {
        int score;
        int index;

        public Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

}
