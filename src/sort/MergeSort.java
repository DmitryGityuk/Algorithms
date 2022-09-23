package sort;

/**
 * Принцип работы алгоритма:
 * 1. Разбиваем исходный массив на массиивы размером в 1 элемент.
 * 2. Объединяем массивы размером в 1 элемент в массивы по 2 жлемента.
 * 3. Объединяем массивы размером в 2 элемента в массивы по 4 элемента.
 * 4. Объединяем массивы размером в 4 элемента в массивы по 8 элементов.
 * 5. Объядиняем массивы размером в 8 элементов в результирующий массив. Конец сортировки.
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 7, 9, 13, 15, 89, 65, 43, 74, 99, 23, 18};
        System.out.println(arrayToString(array));
        array = mergeSort(array);
        System.out.println(arrayToString(array));
    }


    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
//            System.out.println(arrayToString(currentSrc));
        }
        return currentSrc;
    }


    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
