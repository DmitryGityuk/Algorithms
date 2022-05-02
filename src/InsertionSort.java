import java.util.ArrayList;
import java.util.Arrays;

/**
 * Принцип рааботы алгоритма:
 * 1. Последовательность разбивается на две части. Отсортированную и не отсортированную. В качестве отсортированной обычно
 * выбирается левая часть последовательности.
 * 2. Выбирается певрый элемент не отсортированной последовательности и для него находится позиция в отсортированной
 * части последовательности. Правило нахождения позици для элемента со значением Х: а(n) <= X <= a(n+1)
 * 3. Значение устанавливается на найденную позицию со сдвигом элементов стоящим справа от найденной позиции.
 * 4. Алгоритм продолжается до исчерпания не отсортированной части последовательности.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pasteElement = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] <= pasteElement) {
                    break;
                }
                array[j] = array[j - 1];
            }
            array[j] = pasteElement;
        }
    }
}
