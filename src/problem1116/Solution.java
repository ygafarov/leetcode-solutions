package problem1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    boolean canRunZero = true;
    boolean canRunEven = false;
    boolean canRunOdd = false;

    Condition runZero = lock.newCondition();
    Condition runEven = lock.newCondition();
    Condition runOdd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();

        for (int i = 1; i <= n; i++) {
            if (!canRunZero)
                runZero.await();

            canRunOdd = true;
            canRunZero = false;
            canRunEven = false;
            runOdd.signal();

            printNumber.accept(0);
        }

        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();

        for (int i = 1; i <= n; i++) {
            if (!canRunOdd)
                runOdd.await();

            canRunOdd = false;
            canRunZero = false;
            canRunEven = true;
            runEven.signal();

            if (i % 2 == 1)
                printNumber.accept(i);
        }
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();

        for (int i = 1; i <= n; i++) {
            if (!canRunEven)
                runEven.await();

            canRunOdd = false;
            canRunZero = true;
            canRunEven = false;
            runZero.signal();

            if (i % 2 == 0)
                printNumber.accept(i);
        }
        lock.unlock();
    }
}