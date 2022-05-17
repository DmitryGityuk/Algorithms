package search;
import static java.lang.System.out;

/**
 * Принцип работы:
 * 1. Устанавить начальное значение индекса (обозначим его i) равным индексу первого элемента в последовательности.
 * 2. Получить элемент стоящий по индексу n[i]. Возможны два случая.
 *  а) Ключ элемента равен искомому. Вернуть индекс и завершить алгоритм. Поиск успешен.
 *  b) Ключ элеммента не равен искомому. Увеличить индекс на единицу. i=i+1. Переход к пункту 3.
 * 3. Проверить, индекс меньше или равен индексу последнего элемента в последовательности. Если да, то переход к пункту 2.
 * Если нет, то завершить алгоритм. Поиск неудачен.
 */

public class LinearSearch {
    public static void main(String[] args) {
        int[] sequence = new int[]{-2, 0, 3, 5, 7, 11, 15, 19, 24};
        int element = 7;
        out.println(linearSearch(sequence, element));
    }

    private static int linearSearch(int[] sequence, int element) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
