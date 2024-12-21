package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大堆 & 堆排序的一个简单实现
 * @author chengxiyang
 * @date 2022-07-17
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; --i) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, --heapSize);
        }
    }

    /**
     * 将输入数组堆化
     * @param arr 输入数组
     */
    public static void buildHeap(int[] arr) {
        int startNode = ((arr.length - 1) - 1) / 2;
        for (int i = startNode; i >= 0; --i) {
            maxHeapify(arr, i, arr.length);
        }
    }

    /**
     * 维护数组的堆性质，要求输入数组root.left和root.right均已为最大堆
     * 堆中元素索引的范围 < heapSize
     * @param arr 输入数组
     * @param root 根节点
     */
    public static void maxHeapify(int[] arr, int root, int heapSize) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int max = root;
        if (left < heapSize && arr[left] > arr[max]) {
            max = left;
        }
        if (right < heapSize && arr[right] > arr[max]) {
            max = right;
        }
        if (max != root) {
            swap(arr, root, max);
            maxHeapify(arr, max, heapSize);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
