package com.gmail.evanloafakahaitao.hwk17.classTasks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumbersCallableService implements Callable<String> {

    public String operations() {
        Random rd = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(rd.nextInt(101));
        }
        int sumOfNumbers = 0;
        for (Integer integer : list) {
            sumOfNumbers += integer;
        }
        String value = String.valueOf(sumOfNumbers);

        return value;
    }

    @Override
    public String call() throws Exception {
        String result = operations();
        Random rd = new Random();
        int sleepDur = (rd.nextInt(10) + 1) * 1000;
        Thread.sleep(sleepDur);
        return result + "::" + Thread.currentThread().getName();
    }
}
