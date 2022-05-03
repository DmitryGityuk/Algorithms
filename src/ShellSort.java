import java.util.Arrays;

/**
 * Принцип рабоыт алгоритма:
 * 1. Выбирается начальное значениее шага сортировки. ОТ выбора шага зависит средняя сложность сортировки.
 * 2. Начиная от первого элемента выполняется сравнение элементов стоящих друг от друга на расстоянии выбранного шага.
 * Для значения элемента (Х) выбирается место в последовательности таких элементов, что а(i) <= X <= a(i+h). Где,
 * h- используемый шаг.
 * а(i), a(i+h) - значение элемента на i индексе, и на i+h индексе соответственно.
 * 3. После окончания прохода с текущим шагом, шаг уменьшают. Если текущий шаг равен 1 алгоритм заканчивается, если нет
 * его уменьшают согласно выбранному закону его изменения и возвращается к п2.
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 4};
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int step = array.length / 2;
        for (; step > 0; ) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                    int tmp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = tmp;
                }
            }
            step = step / 2;
        }
    }
}
