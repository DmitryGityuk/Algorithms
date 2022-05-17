package search;

/**
 * Принцип работы алгоритма:
 * 1. Сортируется последовательность в которой будет проводиться поиск. Если последовательность уже отсоритрована, то
 * этот шаг можно пропустить.
 * 2. В качестве начальных точек (левая и правая) выбираем первый и последний элемент последовательности.
 * 3. Определяется значение индекса по формуле линейной интерполяции. Получаем элемент по этому индексу.
 * Полученный элемент сравнивается с искомым элементом. Различают случаи:
 * а) Элемент равный искомому. Заканчиваем алгоритм. Поиск успешен.
 * b) Элемент больше искомого. Сдвигаем правую точку. Новое значение (найденный индекс -1).
 * с) Элемент меньше искомого. Свидгаем левую точку. Новое значение (найденный индекс +1).
 * 4. Повторяем пункт 3 до тех пор, до тех пор пока не будет найден искомый элемент или не станет пустым интервал поиска.
 */

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] sequence = new int[]{-2, 0, 3, 5, 7, 9, 11, 15, 18, 21, 28, 34};
        int element = 5;
        System.out.println(interpolationSearch(sequence, element));
    }

    public static int interpolationSearch(int[] sequence, int element) {
        int l = 0;
        int r = sequence.length - 1;
        for (; sequence[l] < element && element < sequence[r]; ) {
            if (sequence[l] == sequence[r]) {
                break;
            }
            int index = (element - sequence[l]) * (l - r) / (sequence[l] - sequence[r]) + l;
            if (sequence[index] > element) {
                r = index - 1;
            } else if (sequence[index] < element) {
                l = index + 1;
            } else {
                return index;
            }
        }
        if (sequence[l] == element) {
            return l;
        }
        if (sequence[r] == element) {
            return r;
        }
        return -1;
    }
}
