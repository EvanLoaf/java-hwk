package com.gmail.evanloafakahaitao.hwk17;

/** Class tasks
 *
 * 1. Создать Callable, которая генерирует 10 файлов с 10 произвольными строками -> засыпает рандомно на 1-3 секунды,
 * результат выполнения – коллекция имен файлов.
 * 2. Создать Callable, которая генерирует коллекцию из 10 рандомных целых чисел -> засыпает рандомно на 1-10 секунд,
 * результат выполнения - сумму этих чисел в виде строки.
 * 3. Создать Callable, которая берет сообщение “Hello World” + текущее время и записывает его в файл. Запись в файл
 * должна производиться последовательно через синхронизированный метод.
 *
 * Для  каждой задачи:
 * Запустить 10 тасков параллельно в пуле из 3 потоков.
 * Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */

import com.gmail.evanloafakahaitao.hwk17.classTasks.task1.TextWriterCallableService;
import com.gmail.evanloafakahaitao.hwk17.classTasks.task2.RandomNumbersCallableService;
import com.gmail.evanloafakahaitao.hwk17.classTasks.task3.WriteSingleFileCallable;
import com.gmail.evanloafakahaitao.hwk17.task1.RandomFilesWriterService;
import com.gmail.evanloafakahaitao.hwk17.task1.ReadAndWriteResultService;
import com.gmail.evanloafakahaitao.hwk17.task2.NumberCollectionCallable;
import com.gmail.evanloafakahaitao.hwk17.task3.AppControllerService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/** Homework
 *
 * 1. Создать файл состоящий из 10 строк вида 'С:\WebServers\home\testsite\www\myfile.txt'. Выделите из этих строк
 * имена файлов без расширения и запишите в другой файл в отдельном потоке, который вернет результирующий размер файла.
 * 2. Создать пул из 4 потоков. Создать класс потока, который генерирует коллекцию из 10 рандомных целых чисел
 * и возвращает максимальный элемент.
 * Подсчитать среднее арифметическое результата работы 10 потоков.
 * 3. В отдельном потоке создать файл состоящий из 1000 строк содержащих 4 произвольных целых числа, разделенных
 * запятой. В другом потоке прочитать эти строки и на каждый массив из 10 строк запускать отдельный поток, который
 * возвращает сумму всех чисел в этих строках. Найти максимальную сумму среди результатов работы всех предыдущих потоков.
 */

public class Main {
    
    public static void main(String[] args) {
    
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        /*// Class task1
        System.out.println("\nClass Task1");
        List<Future<List<String>>> futuresWithFilenames = new ArrayList<>();
        Callable<List<String>> fileWriteCallable = new TextWriterCallableService();
        for (int i = 0; i < 10; i++) {
            Future<List<String>> future = executor.submit(fileWriteCallable);
            futuresWithFilenames.add(future);
        }
        for (Future<List<String>> future : futuresWithFilenames) {
            try {
                for (String s : future.get()) {
                    System.out.println(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------\n");

        // Class task2
        System.out.println("\nClass Task2");
        List<Future<String>> listOfFutures = new ArrayList<>();
        Callable<String> callable = new RandomNumbersCallableService();
        for (int i = 0; i < 10; i++) { // 10 concurrent tasks
            Future<String> future = executor.submit(callable);
            listOfFutures.add(future);
        }
        for (Future<String> future : listOfFutures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------------\n");

        // Class task3
        System.out.println("\nClass Task3");
        List<Future<String>> myFutures = new ArrayList<>();
        Callable<String> myCall = new WriteSingleFileCallable();
        for (int i = 0; i < 10; i++) { // 10 tasks
            Future<String> future = executor.submit(myCall);
            myFutures.add(future);
        }
        boolean futuresDone = false;
        for (Future<String> myFuture : myFutures) {
            if (!myFuture.isDone()) {
                futuresDone = false;
            }
        }
        while (!futuresDone) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futuresDone = true;
            for (Future<String> myFuture : myFutures) {
                if (!myFuture.isDone()) {
                    futuresDone = false;
                }
            }
        }
        ((WriteSingleFileCallable) myCall).closeStream();
        for (int i = 0; i < myFutures.size(); i++) {
            try {
                System.out.println(myFutures.get(i).get());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("---------------\n");*/
    
        /*// Homework task1
        System.out.println("\nHome Task1");
        RandomFilesWriterService writer = new RandomFilesWriterService();
        Scanner in = new Scanner(System.in);
        System.out.println("How many files do u wanna write?");
        int numOfFiles = in.nextInt();
        List<File> myFiles = writer.writeFiles(numOfFiles);
        Callable<Integer> Callable = new ReadAndWriteResultService(myFiles);
        Future<Integer> future = executor.submit(Callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("---------------\n");
    
        // Homework task2
        System.out.println("\nHome Task2");
        ExecutorService biggerExecutor = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> callList = new ArrayList<>();
        System.out.println("Number of threads?");
        int threads = in.nextInt();
        System.out.println("How many numbers per list?");
        int numbersPerList = in.nextInt();
        for (int i = 0; i < threads; i++) {
            callList.add(new NumberCollectionCallable(numbersPerList));
        }
        List<Future<Integer>> myFuturesList = null;
        try {
            myFuturesList = biggerExecutor.invokeAll(callList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sumMax = 0;
        for (Future<Integer> currentFuture : myFuturesList) {
            try {
                sumMax += currentFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Average max number: %d\n", sumMax / myFuturesList.size());
        System.out.println("---------------\n");*/
    
        // Homework task3
        /**
         * ДЗ обычно довольно простая, поэтому придумываю иногда что-то по делу и без
         * тут не просто говнокод, а говнокод, который делает то, что я хотел изначально
         * тут - в объект класса DataFile ходят receiver и sender
         * они обращаются к методам, которые синхронизированы по создаваемому файлу mydata.txt
         * и по очереди пишут - читают файл
         * читатель каждый раз яитает файл с отступом, который записывается при каждом считывании
         * получая данные, receiver пишет их в Deque в том же DataFile
         * сначала его сразу в receiver положил, но после закрытия трэда с ним не мог получать данные
         * Deque читается и пишется также синхронно. читается он отдельными трэдами из пула,
         * которые получают массивы чисел, полученных из Х взятых подряд строк
         * много чего накручено, в итоге было много багов и вещей, которые надо както реализовать.
         * В итоге это оказалось очень полезно - как и поискать что-то, так и на себе ощутить
         * какие-то "часто допускаемые ошибки" и их поиск в коде по выводу ошибок
         * пофиксил, пока остальные дз объяснялись. допилил этот текст-пояснение и перезалью на гит
         */
        System.out.println("\nHome Task3");
        AppControllerService myApp = new AppControllerService();
        myApp.runApp();
        System.out.println("---------------\n");
        
        
    }
    
}
