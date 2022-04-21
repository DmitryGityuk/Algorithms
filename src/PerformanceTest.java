import perfomance.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PerformanceTest {
    public static void main(String[] args) {
        ArrayList<Integer> generated = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            generated.add(i);
        }
        Collections.shuffle(generated);
        int[] arr1 = generated.stream().mapToInt(i -> i).toArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        int[] arr4 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        int[] arr5 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr5, 0, arr1.length);
        int[] arr6 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr6, 0, arr1.length);
        int[] arr7 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr7, 0, arr1.length);
        int[] arr8 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr8, 0, arr1.length);

        Utils.measureTime(() -> BubbleSort.sort(arr1), "BubbleSort");
        Utils.measureTime(() -> BubbleSortKnuth.sort(arr2), "BubbleSort Knuth");
        Utils.measureTime(() -> SelectionSort.sort(arr3), "SelectionSort");
        Utils.measureTime(() -> CombSort.combSort(arr4), "CombSort");
        Utils.assertTrue(Arrays.equals(arr2, arr3));
        Utils.assertTrue(Arrays.equals(arr3, arr4));
    }

}
