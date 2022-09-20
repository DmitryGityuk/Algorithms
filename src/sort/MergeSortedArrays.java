package sort;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Принцип работы:
 * 1. Создаем результирующую последовательность длинна которой равна сумме длинн объединяемых последовательностей.
 * Создаем две вспомогательные переменные для хранения индексов (l && r) присваиваем им значения индексов первого элемента в первой и второй обхединяемых последовательностей
 * 2. Выполняем проход по результирующей последовательности. Для добавления элемента в результирующую последовательность выполним ряд проверок:
 * 2.1 Если знаечние индекса l больше длинны первой последовательности, то добавляем элемент стоящий на индексе r во второй последовательности. r++.
 * 2.2 Если значение индекса r больше длинны второй последовательности, то добавляем элемент стоящий на индексе l в первой последовательности. l++.
 * 2.3 Если элемент на индексе l меньше элемента на индексе r то добавляем элемент стоящий на индексе l в первой последовательности. l ++.
 * 2.4 Добавить элемент стоящий на индексе r во второй последовательности. r++.
 */

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] firstArr = new int[]{1, 2, 6, 9};
        int[] secondArr = new int[]{3, 4, 4, 7};

        out.println(Arrays.toString(merge(firstArr, secondArr)));
    }

    public static int[] merge(int[] firstArr, int[] secondArr) {
        int[] result = new int[firstArr.length + secondArr.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l >= firstArr.length) {
                result[i] = secondArr[r];
                r++;
            } else if (r >= secondArr.length) {
                result[i] = firstArr[l];
                l++;
            } else if (firstArr[l] < secondArr[r]) {
                result[i] = firstArr[l];
                l++;
            } else {
                result[i] = secondArr[r];
                r++;
            }
        }
        return result;
    }
}
