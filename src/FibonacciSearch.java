/**
 * Принцип действия алгоритма:
 * 1. Последовательность сортируется в возрастающем порядке. Если отсортирована, то пропускаем этот пункт.
 * 2. Производим началную инициализацию. Нужно найти такое число k, что F(k+1) >= N+1. После чего нужно ввести следующие
 * значения. M=F(k+1)-(N+1), i=F(k)-M, p=F(k-1), q=F(k-2).
 * 3. Проверить корректность индекса. Если индекс меньше нуля перейти к п5. Если индекс больше или раньше N перейти к п4.
 * Выполнить сравнение К<К(i), если да то перейти к п4. Если К<К(i), перейти к п5. К=К(i) вернуть i поиск успешен.
 * 4. Выполнить проверку q=0. Если да, поиск неудачен, закончить выполнение. В противном случае установить:
 *   i=i-q, выпонить обмен (p,q) = (q,p-q), перейти к п3.
 * 5. Выполнить проверку р=1. Если да, поиск неудачен, закончить выполнение. В противном случае установить:
 *   i=i+q, p=p-q, q=q-р, перейти к п3.
 * Где, N- число элементов в последователньости. K- искомый элемент. K(i)- элемент последовательности расположенный
 * на i- индексе. F(k)-k-й элемент в последователньости Фиббоначи.
 */

public class FibonacciSearch {
    private int i;
    private int p;
    private int q;
    private boolean stop = false;

    public FibonacciSearch() {
    }

    private void init(int[] sequence) {
        stop = false;
        int k = 0;
        int n = sequence.length;
        for (; getFibonacciNumber(k + 1) < n + 1; ) {
            k += 1;
        }
        int m = (int) (getFibonacciNumber(k + 1) - (n + 1));
        i = (int) (getFibonacciNumber(k) - m);
        p = (int) getFibonacciNumber(k - 1);
        q = (int) getFibonacciNumber(k - 2);
    }

    private long getFibonacciNumber(int k) {
        long firsNum = 0;
        long secondNum = 1;
        for (int i = 0; i < k; i++) {
            long tmp = secondNum;
            secondNum += firsNum;
            firsNum = tmp;
        }
        return firsNum;
    }

    private void upIndex() {
        if (p == 1) {
            stop = true;
        }
        i = i + q;
        p = p - q;
        q = q - p;
    }

    private void downIndex() {
        if (q == 0) {
            stop = true;
        }
        i = i - q;
        int tmp = q;
        q = p - q;
        p = tmp;
    }

    public int search(int[] sequence, int elem) {
        init(sequence);
        int n = sequence.length;
        int resultIndex = -1;
        for (; !stop; ) {
            if (i < 0) {
                upIndex();
            } else if (i >= n) {
                downIndex();
            } else if (sequence[i] == elem) {
                resultIndex = i;
                break;
            } else if (elem < sequence[i]) {
                downIndex();
            } else if (elem > sequence[i]) {
                upIndex();
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{-2, 0, 3, 5, 7, 9, 11, 15, 18, 21};
        int elem =7;
        FibonacciSearch fs = new FibonacciSearch();
        int index = fs.search(sequence, elem);
        System.out.println(index);
    }
}
