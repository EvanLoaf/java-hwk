package com.gmail.evanloafakahaitao.hwk22.trainingTest.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Consumer implements Callable<List<Integer>> {

    private final DataStorageDTO data;
    private static final int MAX_CHECKS = 3;
    private int currentChecks = 0;

    public Consumer(DataStorageDTO data) {
        this.data = data;
    }

    @Override
    public List<Integer> call() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> maxNumbers = new ArrayList<>();
        while (currentChecks < MAX_CHECKS) {
            numbers = data.readData();
            Integer maxNumber = null;
            if (numbers == null) {
                ++currentChecks;
                System.out.println(Thread.currentThread().getName() + " Checks: " + currentChecks);
            } else {
                System.out.println("Data was read, operating.. " + Thread.currentThread().getName());
                currentChecks = 0;
                for (Integer number : numbers) {
                    if (maxNumber == null) {
                        maxNumber = number;
                    } else {
                        maxNumber = Math.max(maxNumber, number);
                    }
                }
                maxNumbers.add(maxNumber);
            }
        }
        return maxNumbers;
    }
}
