package problem1114;

import java.util.concurrent.Exchanger;

class Foo {

    public Foo() {

    }

    Exchanger<Integer> exchanger12 = new Exchanger<>();
    Exchanger<Integer> exchanger23 = new Exchanger<>();

    boolean canSecond = false;
    boolean canThird = false;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        exchanger12.exchange(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        exchanger12.exchange(1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        exchanger23.exchange(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        exchanger23.exchange(1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}