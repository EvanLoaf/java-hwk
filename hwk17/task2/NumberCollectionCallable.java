package com.gmail.evanloafakahaitao.hwk17.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCollectionCallable implements Callable<Integer> {
    
    private int numbersPerList;
    
    public NumberCollectionCallable(int numbersPerList) {
        this.numbersPerList = numbersPerList;
    }
    
    public int getMaxInNumList(int numbersPerList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbersPerList; i++) {
            list.add(ThreadLocalRandom.current().nextInt(50));
        }
        int maxNumber = list.get(1);
        for (Integer integer : list) {
            maxNumber = Math.max(maxNumber, integer);
        }
        System.out.printf("%s Biggest number: %d\n", Thread.currentThread().getName(), maxNumber);
        
        return maxNumber;
    }
    
    @Override
    public Integer call() throws Exception {
        return getMaxInNumList(numbersPerList);
    }
}
