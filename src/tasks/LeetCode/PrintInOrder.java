package tasks.LeetCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114.
 * https://leetcode.com/problems/print-in-order/
 */

public class PrintInOrder {
    public int threadNumber;

    public PrintInOrder() {
        this.threadNumber = 1;
    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        while (threadNumber != 1) {
            wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        threadNumber++;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while (threadNumber != 2) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        threadNumber++;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while (threadNumber != 3) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        threadNumber++;
        notifyAll();
    }

    class SolutionTwo {
        private int threadNumber;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public SolutionTwo() {
            this.threadNumber = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                this.threadNumber++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (this.threadNumber != 2) {
                    condition.await();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                this.threadNumber++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (this.threadNumber != 3) {
                    condition.await();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                this.threadNumber++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    class SolutionThree {
        private Semaphore s1 = new Semaphore(0);
        private Semaphore s2 = new Semaphore(0);

        public SolutionThree() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            s1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            s1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            s2.release();

        }

        public void third(Runnable printThird) throws InterruptedException {
            s2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

