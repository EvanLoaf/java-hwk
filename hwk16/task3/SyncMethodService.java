package com.gmail.evanloafakahaitao.hwk16.task3;

import java.time.LocalDateTime;

public class SyncMethodService implements Runnable {
    
    public synchronized void myMethod() {
        System.out.printf("Thread: %s, current time: %s, time ms: %s\n", Thread.currentThread().getName(), LocalDateTime.now(), System.nanoTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        myMethod();
    }
}
