package sort;

import java.util.Arrays;
import static java.lang.System.out;

/**
 * Принцип действия алгоритма:
 * 1. Определяем макс. и мин. значение в сортируемой последовательности. Объявляем вспомогательную последовательность
 * длинна которой вычисляется как max-min+1. Заполняем её нулями.
 * 2. Выполняем проход по сортируемой последовательности, добавляем единицу к значению вспомогательной(elem-min),
 * где elem это текущий элемент в сортируемой последователньости.
 * 3. Выполняем проход по индексам(i) вспомогателньой последовательности добавляя в сортируемую значения i+min в кол-ве
 * вспомогательной последовательности.
 */

public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        out.println(Arrays.toString(array));
        countingSort(array);
        out.println(Arrays.toString(array));
    }


    public static void countingSort(int[] array) {
        int[] minMax = findMinMax(array);
        int minVal = minMax[0];
        int maxVal = minMax[1];
        int[] support = new int[maxVal - minVal + 1];
        for (int elem : array) {
            support[elem - minVal] += 1;
        }
        int index = 0;
        for (int i = 0; i < support.length; i++) {
            for (int j = 0; j < support[i]; j++) {
                array[index] = i + minVal;
                index += 1;
            }
        }
    }

    private static int[] findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int elem : array) {
            if (min > elem) {
                min = elem;
            }
            if (max < elem) {
                max = elem;
            }
        }
        return new int[]{min, max};
    }
}
