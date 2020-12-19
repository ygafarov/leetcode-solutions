package problem1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    boolean canPrintFoo = true;
    boolean canPrintBar = false;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (!canPrintFoo)
                condition.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            canPrintFoo = false;
            canPrintBar = true;
            condition.signal();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (!canPrintBar)
                condition.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            canPrintFoo = true;
            canPrintBar = false;
            condition.signal();
        }
        lock.unlock();
    }
}