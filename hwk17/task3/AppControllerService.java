package com.gmail.evanloafakahaitao.hwk17.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppControllerService {
    
    public void runApp() {
        DataFile dataFile = new DataFile();
        Scanner in = new Scanner(System.in);
        System.out.println("How many lines do u wanna write in total?");
        int linesToWriteTotal = in.nextInt();
        System.out.println("How many lines at a time?");
        int linesPerCycle = in.nextInt();
        System.out.println("How many numbers do u wanna write to each line?");
        int numbersPerLine = in.nextInt();
        
        Runnable senderRun = new DataSenderService(dataFile, linesToWriteTotal, linesPerCycle, numbersPerLine);
        Thread senderThread = new Thread(senderRun);
        Runnable receivedRun = new DataReceiverService(dataFile, linesToWriteTotal, linesPerCycle);
        Thread receiverThread = new Thread(receivedRun);
        senderThread.start();
        receiverThread.start();
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future<Integer>> listOfFutures = new ArrayList<>();
        int numOfResults = (linesToWriteTotal + linesPerCycle - 1) / linesPerCycle;
        for (int i = 0; i < numOfResults; i++) {
            Integer[] myData = ((DataReceiverService) receivedRun).getDequeElement();
            System.out.println("Data from deque: ");
            for (Integer integer : myData) {
                System.out.printf("%d ", integer);
            }
            if (myData == null) {
                System.out.println("\nData transfer error occurred.");
            } else {
                System.out.println("\nData is being transferred to a task - success");
            }
            Future<Integer> future = executor.submit(() -> {
                int sumOfNumbers = 0;
                for (Integer integer : myData) {
                    sumOfNumbers += integer;
                }
                return sumOfNumbers;
            });
            listOfFutures.add(future);
        }
        System.out.println("Fut list length: " + listOfFutures.size());
        boolean complete = false;
        while (!complete) {
            complete = true;
            for (Future<Integer> future : listOfFutures) {
                if (!future.isDone()) {
                    complete = false;
                }
            }
        }
        int maxArraySum = 0;
        for (Future<Integer> future : listOfFutures) {
            try {
                int sumOfNumbers = future.get();
                System.out.printf("Sum of numbers: %d\n", sumOfNumbers);
                maxArraySum = Math.max(maxArraySum, sumOfNumbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Max result: %d\n", maxArraySum);
        executor.shutdown();
    }
    
}
