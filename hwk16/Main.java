package com.gmail.evanloafakahaitao.hwk16;

import com.gmail.evanloafakahaitao.hwk16.task1.IntArrayMaxValueFinderService;
import com.gmail.evanloafakahaitao.hwk16.task2.WriteArrayToFileService;
import com.gmail.evanloafakahaitao.hwk16.task3.SyncMethodService;

/**
 *1. Создать класс поток, который генерирует массив целых чисел из 10 элементов, затем находит максимальный
 * элемент в этом массиве и выводит на экран в формате - имя потока: максимальный элемент. Запустить 10 потоков.
 * 2. Создать класс поток, который создает средствами Java файл и записать в него рандомно сгенерированный
 * массив из 10 целых чисел. Запустить 5 потоков.
 * 3. Создать класс с синхронизированным методом, который выводит на экран имя текущего потока, текущее время
 * и вызывает sleep на 5 секунд. Запустить 10 потоков, которые вызывают этот метод от созданного объекта.
 */

public class Main {
    
    public static void main(String[] args) {
        // Task1
        System.out.println("Task1.");
        for (int i = 0; i < 10; i++) { // 10 Threads 0-9
            Runnable runnable = new IntArrayMaxValueFinderService();
            Thread thread = new Thread(runnable);
            thread.start();
        }
        System.out.println("---------------");
    
        // Task2
        System.out.println("Task2.");
        WriteArrayToFileService writer = new WriteArrayToFileService();
        for (int i = 0; i < 5; i++) { // 5 threads 10-14
            new Thread(() -> writer.writeArrToFile()).start();
        }
        /**
         * При записи без synchronized в один и тот же файл одним и тем же методом
         * последнее число в файле каждый раз превышало значения Integer
         */
        System.out.println("---------------");
    
        // Task3
        System.out.println("Task3.");
        Runnable runnable = new SyncMethodService();
        for (int i = 0; i < 10; i++) { // 10 threads 15-24
            Thread thr = new Thread(runnable);
            thr.start();
        }
        System.out.println("---------------");
        
    }
    
}
