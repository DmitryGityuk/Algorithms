package sort;

import java.util.Arrays;

import static java.lang.System.out;

public class CombSort {
    public static void main(String[] args) {
        int[] arr = new int[]{43, 56, 72, 90, 14, -23, 19, 27, 44, 1};
        combSort(arr);
        out.println(Arrays.toString(arr));
    }

    public static void combSort(int[] arr) {
        int gap = arr.length;
        boolean isSorted = false;
        while (!isSorted || gap != 1) {
            if (gap > 1) {
                gap = gap * 10 / 13;
            } else {
                gap = 1;
            }
            isSorted = true;
            for (int i = gap; i < arr.length; i++) {
                if (arr[i - gap] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - gap];
                    arr[i - gap] = tmp;
                    isSorted = false;
                }

            }
        }
    }
}
