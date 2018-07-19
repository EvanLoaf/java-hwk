package com.gmail.evanloafakahaitao.hwk22.trainingTest.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArrayWriterService implements Runnable {

    public void write() {
        Random rd = new Random();
        int[] numbers = new int[10];
        Integer maxNumber = null;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rd.nextInt();
            if (maxNumber == null) {
                maxNumber = numbers[i];
            } else {
                maxNumber = Math.max(maxNumber, numbers[i]);
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Thread.currentThread().getName() + ".txt"))) {
            for (int number : numbers) {
                bw.write(number);
                bw.newLine();
            }
            bw.write(maxNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
        write();
    }
}
