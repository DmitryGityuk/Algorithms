/**
 * Такая модификация имеет смысл только для последовательносткй в которых вставка и удаление эдемента не связаны
 * с высокими вычислительными затратами.
 * Принцип работы:
 * 1. Добавить элемент(значение ключа которого равно искомому) в конец последовательности.
 * 2. Установить начальное значение индекса равным индексу первого эдемента в последовательности.
 * 3. Получить элемент стоящий по индексу n[i]. Возможны два случая.
 *  а) Ключ эдемента равен искомому. Удалить последний элемент. Если индекс не равен индексу последнего элемента - поиск успешен.
 *      В случае равенства индекса индексу последнего элемента - поиск не удачен.
 *  b) Ключ элемента не равен искомому. Увеличить индекс на единицу. i=i+1/ Перейти к началу пункта 3.
 */

import java.util.ArrayList;
import java.util.List;

public class ModifiedLinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, 5, 7, 9, 14, 18, 23};
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sequence.add(arr[i]);
        }
        int element = 5;
        System.out.println(modifiedLinearSearch(sequence, element));
        System.out.println(sequence);
    }

    private static int modifiedLinearSearch(List<Integer> sequence, int element) {
        sequence.add(element);
        int lastIndex = sequence.size() - 1;
        int i = 0;
        for (; sequence.get(i) != element; ) {
            i++;
        }
        sequence.remove(lastIndex);
        if (i != lastIndex) {
            return i;
        }
        return -1;
    }
}
