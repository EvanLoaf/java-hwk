package com.gmail.evanloafakahaitao.hwk16.task1;

import com.gmail.evanloafakahaitao.util.InputService;

public class IntArrayMaxValueFinderService implements Runnable {
    
    public int[] createArray() {
        int[] array = new int[10]; // 10 numbers in each array
        InputService input = new InputService();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.getRandomNumber();
        }
        
        return array;
    }
    
    public void findMaxPrintResult(int[] array) {
        int maxNumber = array[0];
        for (int number : array) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), maxNumber);
    }
    
    @Override
    public void run() {
        findMaxPrintResult(createArray());
    }
}
