package com.gmail.evanloafakahaitao.hwk18.classTask;

public class RunnableThreadService implements Runnable {
    
    private static final int MAX_THREADS = 50;
    private static int threadNumber = 0;
    
    @Override
    public void run() {
        threadSequence();
    }
    
    public void threadSequence() {
        incrThreadsNumber();
        if (threadNumber <= MAX_THREADS) {
            Runnable r = new RunnableThreadService();
            Thread newThread = new Thread(r);
            newThread.start();
            try {
                newThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Hello from %s\n", Thread.currentThread().getName());
        } else {
            System.out.println("Threads created!");
        }
    }
    
    public void incrThreadsNumber() {
        threadNumber += 1;
    }
}
