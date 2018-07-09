package com.gmail.evanloafakahaitao.hwk18.task2;

public class ReceiverService implements Runnable {
    
    private MyData data;
    private static final int MAX_CHECKS = 3;
    private int currentChecks = 0;
    private String name;
    
    public ReceiverService(MyData data, String name) {
        this.data = data;
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.println("Consumer " + name + " works");
        Integer receivedNumber;
        while (currentChecks < MAX_CHECKS) {
            receivedNumber = data.receive();
            if (receivedNumber == null) {
                ++currentChecks;
                System.out.println("Check " + currentChecks + " failed by " + name);
            } else {
                System.out.println("Consumer " + name + " got " + receivedNumber);
                currentChecks = 0;
            }
        }
        System.out.println("Consumer " + name + " finished work");
    }
}
