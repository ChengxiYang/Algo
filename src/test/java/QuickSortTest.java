import Sort.QuickSort;

public class QuickSortTest {

    public void testQuickSort1() {
        int[] arr = {4, 3, 6, 5, 1, 2, 9, 7, 8};
        QuickSort.quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
