/**
 * Принцип работы:
 * 1. Берем модули чисел а и b. В качестве числа а выбираем большее из двух чисел, в качестве b выбираем меньшее.
 *  Вводим множитель(factor) равный 1.
 * 2. Рассматривается несколько случаев. Если:
 *   a = b вернуть a * factor;
 *   a = 0, b != 0 вернуть b * factor;
 *   b = 0, a != 0 вернуть a * factor;
 *   a = 1,вернуть factor;
 *   b = 1,вернуть factor;
 * 3. Рассматривается несколько случаев:
 *   a,b - чётные. Установить а = а/2, b=b/2. Умножаем множитель на 2.
 *   а - чётное, b - нечетное. Установить а = а / 2.
 *   b - чётное, a - нечетное. Установить b = b / 2.
 *   а - нечетное, b - нечетное. а > b Установить а = (а-b)/2
 *   а - нечетное, b - нечетное. а < b Установить а = (b-a)/2, b = a.
 */

public class BinaryGCD {
    public static void main(String[] args) {
        System.out.println(binaryGCD(30, 18));
    }

    private static int binaryGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int factor = 1;
        for (; ; ) {
            if (a == b)
                return factor * a;
            if (a == 0)
                return b * factor;
            if (b == 0)
                return a * factor;
            if (a == 1 || b == 1)
                return factor;
            if (a % 2 == 0 && b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                factor = factor * 2;
            } else if (a % 2 == 0 && b % 2 != 0) {
                a = a / 2;
            } else if (a % 2 != 0 && b % 2 == 0) {
                b = b / 2;
            } else if (a > b) {
                a = (a - b) / 2;
            } else {
                int temp = a;
                a = (b - a) / 2;
                b = temp;
            }
        }
    }
}
