package learn.concurrent.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class A {

    AtomicInteger num = new AtomicInteger();

    public int getNum(){
        return num.get();
    }

    public void increase(){
        int oldValue = num.get();
        int newValue = oldValue + 1;
        num.compareAndSet(oldValue, newValue);
    }


}
