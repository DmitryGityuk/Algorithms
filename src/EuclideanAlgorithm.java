/**
 * Принцип работы:
 * 1. Берём модуль чисел а и b. В качестве числа а выбираем большее из двух чисел, в качестве b выбираем меньшее.
 * 2. Вычисляем остаток от деления а на b (в дальнейшем будем обозначать его r). Если остаток от деления равен 0.
 *  Возвращаем b в качсетве gcd(a,b). Алгоритм окончен.
 * 3. Задаем новое значение а = b, b = r. Переход к пункту 2.
 */

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(30, 18));
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int r = a % b;
        for (; r != 0; ) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
}
