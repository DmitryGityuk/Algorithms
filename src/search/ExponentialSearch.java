package search;

import static java.lang.System.out;

/**
 * 1.Поиск проводится в отсортированной последовательности. Для определения границы объявляем доп. переменную (х),
 * её значение устанавливаем равной 1.
 * 2. Выполняем проверку: если значение х больше чем длинна последовательности,то в таком случае выполняем бинарный поиск нужного элемента
 * в промежутке от х/2 до размера последовательности. Заканчиваем поиск. В противном случае переходим к п.3
 * 3. Выполняем проверку: если значение на индексе х больше искомого элемента то выполняем бинарный поиск нужного элемента
 * в промежутке от х/2 до х. Заканчиваем поиск. В противном случае переходим к п.4
 * 4. Увеличиваем значение х в два раза. Переходим к п.2
 */

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, 5, 7, 9, 11, 15, 18};
        int requiredElement = 5;
        out.println(exponentialSearch(arr, requiredElement));
    }


    public static int binarySearch(int[] arr, int requiredElement, int l, int r) {
        for (; l <= r; ) {
            int m = l + (r - l) / 2;
            int element = arr[m];
            if (requiredElement == element) {
                return m;
            }
            if (element < requiredElement) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int requiredElement) {
        long border = 1;
        for (; border < arr.length && arr[(int) border] < requiredElement; ) {
            border *= 2;
        }
        int l = (int) (border / 2);
        int r;
        if (border > arr.length - 1) {
            r = arr.length - 1;
        } else {
            r = (int) border;
        }
        return binarySearch(arr, requiredElement, l, r);
    }
}
