package sort;

import java.util.Arrays;

/**
 * Принцип работы:
 * 1. Выполняется проход по сортируемой последовательности.
 * 2. Первый элемент не отсортированной подпоследовательности принимается за минимальный и сохраняется его индекс.
 * 3. Выполняется проход по не отсортирвоанной части последовательности в поиске минимального элемента.
 * 4. Происходит обмен найденного манимального члена и первого члена не отсортированной подпоследовательности.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 0, -2, 10, 22, 8, 1, 4, 99};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
