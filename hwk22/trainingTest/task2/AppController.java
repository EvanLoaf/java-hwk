package com.gmail.evanloafakahaitao.hwk22.trainingTest.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AppController {

    private int producers;
    private int consumers;
    private int eachProducerToWrite;

    private AppController() {
    }

    private static class Holder {

        private static final AppController instance = new AppController();
    }

    public static AppController getInstance() {
        return Holder.instance;
    }

    public AppController setProducers(int producers) {
        this.producers = producers;
        return getInstance();
    }

    public AppController setConsumers(int consumers) {
        this.consumers = consumers;
        return getInstance();
    }

    public AppController setEachProducerToWrite(int eachProducerToWrite) {
        this.eachProducerToWrite = eachProducerToWrite;
        return getInstance();
    }

    public void app() {
        DataStorageDTO data = new DataStorageDTO();
        for (int i = 0; i < producers; i++) {
            Runnable r = new Producer(data, eachProducerToWrite);
            Thread thread = new Thread(r);
            thread.start();
        }
        ExecutorService executor = Executors.newFixedThreadPool(consumers);
        List<Future<List<Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < consumers; i++) {
            Callable<List<Integer>> callable = new Consumer(data);
            futures.add(executor.submit(callable));
        }
        int sumOfMaxNumbers = 0;
        int countOfMaxNumbers = 0;
        try {
            for (Future<List<Integer>> future : futures) {
                countOfMaxNumbers += future.get().size();
                for (Integer integer : future.get()) {
                    sumOfMaxNumbers += integer;
                    System.out.println("max: " + integer);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.printf("Avg max number is: %d\n", sumOfMaxNumbers / countOfMaxNumbers);
        executor.shutdown();
    }
}
