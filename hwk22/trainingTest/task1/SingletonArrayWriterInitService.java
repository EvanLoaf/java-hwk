package com.gmail.evanloafakahaitao.hwk22.trainingTest.task1;

public class SingletonArrayWriterInitService {

    private static volatile SingletonArrayWriterInitService instance = null;

    private SingletonArrayWriterInitService() {}

    public synchronized void threadManager(int threads) {
        for (int i = 0; i < threads; i++) {
            Runnable r = new ArrayWriterService();
            Thread thread = new Thread(r);
            thread.start();
        }
    }

    public static synchronized SingletonArrayWriterInitService getInstance() {
        if (instance == null) {
            synchronized (SingletonArrayWriterInitService.class) {
                if (instance == null) {
                    instance = new SingletonArrayWriterInitService();
                }
            }
        }
        return instance;
    }
}
