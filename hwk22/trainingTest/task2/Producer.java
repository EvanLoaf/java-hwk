package com.gmail.evanloafakahaitao.hwk22.trainingTest.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private final DataStorageDTO data;
    private final int filesToWrite;
    private final Random rd = new Random();

    public Producer(DataStorageDTO data, int filesToWrite) {
        this.data = data;
        this.filesToWrite = filesToWrite;
    }

    @Override
    public void run() {
        for (int i = 0; i < filesToWrite; i++) {
            System.out.println("Data is being written.. " + Thread.currentThread().getName());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) { // 10 numbers
                list.add(rd.nextInt(50));
            }
            System.out.println("List that was writted: ");
            for (Integer integer : list) {
                System.out.printf(integer + " ");
            }
            System.out.printf("\n");
            data.writeData(list);
        }
    }
}
