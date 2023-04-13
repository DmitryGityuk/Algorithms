package sort;

import perfomance.Utils;

import java.util.Arrays;

public class BogoSort {
    public static void main(String[] args) {
        int[] array = new int[]{64, 32, 47, 51, 33, 62, 18, 20, 74, 55, 98};
        Utils.measureTime(() -> {
            while (!isSorted(array)) {
                shuffle(array);
            }
        }, "bogoSort");
        System.out.println(Arrays.toString(array));

    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    static void shuffle(int[] arr) {
        int temp;
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = (int) (Math.random() * arr.length);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
