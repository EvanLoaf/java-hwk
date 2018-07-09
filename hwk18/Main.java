package com.gmail.evanloafakahaitao.hwk18;

/** Class task:
 * Напишите программу, которая создает поток (назовем его Thread 1). Thread 1 создает другой поток (Thread 2); Thread 2
 * создает Thread 3; и т. д., вплоть до Thread 50. Каждый поток должен печатать «Hello from Thread <num>!», но вы
 * должны структурировать свою программу таким образом, чтобы потоки печатали свои приветствия в обратном порядке.
 */

import com.gmail.evanloafakahaitao.hwk18.classTask.RunnableThreadService;
import com.gmail.evanloafakahaitao.hwk18.task1.PoolGeneratesStringsService;
import com.gmail.evanloafakahaitao.hwk18.task2.MyData;
import com.gmail.evanloafakahaitao.hwk18.task2.ProducerService;
import com.gmail.evanloafakahaitao.hwk18.task2.ReceiverService;

import java.util.Scanner;

/** Homework:
 * 1. Написать программу, которая генерирует пул из 5 потоков. Запустить 5 потоков, которые генерируют строку
 * длинной от 5 до 10 из символов 'b', ‘v’, ‘x’. Вывести на экран все строки максимальной длины.
 * 2. Написать программу по шаблону "Производитель-Потребитель" для двух производителей(которые генерируют
 * произвольное целое число каждые пол секунды) и двух потребителей.
 */

public class Main {
    
    public static void main(String[] args) {
    
        // Class task
        System.out.println("\nClass task");
        Runnable r = new RunnableThreadService();
        Thread thread = new Thread(r);
        thread.start();
        try {
            Thread.sleep(500); // wait for result output
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------\n");
    
        // Homework task 1
        System.out.println("\nHwk task 1");
        System.out.println("Number of threads?");
        Scanner in = new Scanner(System.in);
        int threads = in.nextInt();
        PoolGeneratesStringsService myPool = new PoolGeneratesStringsService(threads);
        myPool.runPools();
        System.out.println("----------\n");
    
        // Homework task 2
        System.out.println("\nHwk task 2");
        int countToSend = 10;
        MyData myData = new MyData();
        Thread firstProducer = new Thread(new ProducerService(myData, countToSend, "First Producer"));
        Thread secondProducer = new Thread(new ProducerService(myData, countToSend, "Second Producer"));
        Thread firstReceiver = new Thread(new ReceiverService(myData, "First Receiver"));
        Thread secondReceiver = new Thread(new ReceiverService(myData, "Second Receiver"));
        firstProducer.start();
        firstReceiver.start();
        secondProducer.start();
        secondReceiver.start();
        System.out.println("----------\n");
        
    }
    
}
