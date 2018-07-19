package com.gmail.evanloafakahaitao.hwk22;

import com.gmail.evanloafakahaitao.hwk22.trainingTest.task1.SingletonArrayWriterInitService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task2.AppController;

public class Main {

    public static void main(String[] args) {

        //task1.
        System.out.println("task1");
        SingletonArrayWriterInitService instance = SingletonArrayWriterInitService.getInstance();
        instance.threadManager(5);
        System.out.println("----------");

        //task2.
        System.out.println("task2");
        AppController myApp = AppController.getInstance()
                .setConsumers(2) // any number of consumers
                .setProducers(10) // any number of consumers
                .setEachProducerToWrite(1); // any number of files to write per producer (file names somewhat unique)
        myApp.app();
        System.out.println("----------");
    }
}
