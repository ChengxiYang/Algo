package Heap;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * @author chengxiyang
 */
public class KthLargest {

    private final int[] heap;

    private int heapSize;

    private int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        heap = new int[kth];
        buildHeap(nums);
    }

    public int add(int val) {
        if (heapSize < kth) {
            ++heapSize;
            heap[heapSize - 1] = val;
            int c = heapSize - 1;
            int p = (c - 1) / 2;
            while(p >= 0 && heap[c] < heap[p]) {
                swap(c, p);
                c = p;
                p = (c - 1) / 2;
            }
        } else {
            if (val > heap[0]) {
                heap[0] = val;
                heapify(0);
            }
        }
        return heap[0];
    }

    private void buildHeap(int[] nums) {
        int len = nums.length;
        if (len < kth) {
            heapSize = len;
        } else {
            heapSize = kth;
        }
        for (int i = 0; i < heapSize; ++i) {
            heap[i] = nums[i];
        }
        int lastInner = (heapSize - 2) / 2;
        for (int i = lastInner; i >= 0; --i) {
            heapify(i);
        }
        if (len > heapSize) {
            for (int i = heapSize; i < len; ++i) {
                if (nums[i] <= heap[0]) {
                    continue;
                } else {
                    heap[0] = nums[i];
                    heapify(0);
                }
            }
        }
    }

    private void heapify(int root) {
        int p = root;
        int l = p * 2 + 1;
        int r = p * 2 + 2;
        while (true) {
            int min = p;
            if (l < heapSize && heap[l] < heap[min]) {
                min = l;
            }
            if (r < heapSize && heap[r] < heap[min]) {
                min = r;
            }
            if (min == p) {
                break;
            } else {
                swap(min, p);
                p = min;
                l = p * 2 + 1;
                r = p * 2 + 2;
            }
        }
    }

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
