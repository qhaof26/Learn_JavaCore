package service;

import java.util.concurrent.atomic.AtomicInteger;
/*
* Method auto generate number
* Quoc Hao
*/
public class NumberGenerator {
    private static final AtomicInteger currentNumber = new AtomicInteger(0);
    public static int generateId() {
        return currentNumber.getAndIncrement();
    }
}
