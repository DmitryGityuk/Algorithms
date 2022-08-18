package sort;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Принцип работы:
 * 1. Объявляем две доп. переменные для хранения границ с которых нужно начинать плоход по элементам последовательности
 * (left и right) и переменную для контроля наличия факта обмена (control). Устанавливаем знаечние left = 0, right = индексу последнего
 * элемента последовательности. control = right.
 * 2. Начиная от left и до right выполняем проход по элемментам последовательности. ЕСли текущий элемент больше передыдущего, то проводим их обмен
 * и устанавливаем значение control равной индексу текущего элемента. После прохода установить значение right = control.
 * 3. Начиная от right и до left выполянем обратынй проход по элементам последовательности. Если текущий элемент меньше предыдущего
 * то выполняем их обмен и устанавливаем значение control равным индексу текущего элемента. После прохода устаналиваем значение left = control.
 * 4. Если left < right вернуться к п2. В противном случае закончить алгоритм.
 */

public class CocktailSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        cocktailSort(array);
        out.println(Arrays.toString(array));
    }

    public static void cocktailSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int control = right;
        for (; left < right; ) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    control = i;
                }
            }
            right = control;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    control = i;
                }
            }
            left = control;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
