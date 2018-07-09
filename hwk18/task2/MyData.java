package com.gmail.evanloafakahaitao.hwk18.task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyData {
    
    private final Deque<Integer> myData = new ArrayDeque<>();
    
    public void send(Integer data) {
        synchronized (myData) {
            myData.add(data);
            myData.notifyAll();
        }
    }
    
    public Integer receive() {
        synchronized (myData) {
            if (myData.isEmpty()) {
                try {
                    myData.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            return myData.poll();
        }
    }
    
}
