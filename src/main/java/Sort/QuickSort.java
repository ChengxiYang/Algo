package Sort;

import java.util.ArrayList;
import java.util.List;

import static Heap.HeapSort.swap;

/**
 * 快速排序的非递归实现
 * @author chengxiyang
 * @date 2022-07-17
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        int len = arr.length;
        List<Pair> stack = new ArrayList<>();
        stack.add(new Pair(0, len - 1));
        while (!stack.isEmpty()) {
            Pair pair = stack.remove(stack.size() - 1);
            int q = partition(arr, pair.start, pair.end);
            if (q + 1 < pair.end) {
                stack.add(new Pair(q + 1, pair.end));
            }
            if (q - 1 > pair.start) {
                stack.add(new Pair(pair.start, q - 1));
            }
        }
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; ++j) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }
}
