package com.gmail.evanloafakahaitao.hwk18.task2;

import java.util.concurrent.ThreadLocalRandom;

public class ProducerService implements Runnable {
    
    private MyData data;
    private int dataCount; // 20 pieces of data to send - example
    private String name;
    
    public ProducerService(MyData data, int dataCount, String name) {
        this.data = data;
        this.dataCount = dataCount;
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.println("Producer " + name + " works");
        for (int i = 0; i < dataCount; i++) {
            data.send(ThreadLocalRandom.current().nextInt(11));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer " + name + " sent data");
    }
}
