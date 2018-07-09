package com.gmail.evanloafakahaitao.hwk18.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolGeneratesStringsService {
    
    private Scanner in = new Scanner(System.in);
    private InputService input = new InputService();
    private int numOfThreads;
    
    public PoolGeneratesStringsService(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }
    
    public void runPools() {
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
        System.out.println("Which letters do u wanna use? Type them in a row: ");
        String letters = in.nextLine();
        System.out.println("Min string length?");
        int minLength = in.nextInt();
        System.out.println("Max string length?");
        int maxLength = in.nextInt();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < numOfThreads; i++) {
            Future<String> future = executor.submit(() -> generateString(letters, minLength, maxLength));
            list.add(future);
        }
        int longetsStr = 0;
        List<String> longestStrings = new ArrayList<>();
        for (Future<String> stringFuture : list) {
            try {
                if (stringFuture.get().length() > longetsStr) {
                    longetsStr = stringFuture.get().length();
                    longestStrings.clear();
                    longestStrings.add(stringFuture.get());
                } else if (stringFuture.get().length() == longetsStr) {
                    longestStrings.add(stringFuture.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Longest generated strings: ");
        for (String longestString : longestStrings) {
            System.out.println(longestString);
        }
    }
    
    private String generateString(String letters, int minLength, int maxLength) {
        StringBuilder sb = new StringBuilder();
        char[] arr = letters.toCharArray();
        int myStringlength = input.getRandomNumberInRange(minLength, maxLength);
        for (int i = 0; i < myStringlength; i++) {
            sb.append(arr[input.getRandomNumberInRange(0, arr.length - 1)]);
        }
        System.out.printf("Generated string: %s\n", sb.toString());
        
        return sb.toString();
    }
    
}
