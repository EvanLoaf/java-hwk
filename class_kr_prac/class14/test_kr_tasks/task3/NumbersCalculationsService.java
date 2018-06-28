package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task3;

import java.util.Random;

public class NumbersCalculationsService {

    public int[] createArray() {

        Random rd = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }

        return arr;
    }

    public void calculations(int[] array) {

        long sumOfNegativeNumbers = 0;
        long countOfNegativeNumbers = 0;
        int smallestNumber = array[0];
        int smallestNumberIndex = 0;

        System.out.println("Our array: ");
        for (int i : array) {
            System.out.println(i);
            if (i < 0) {
                sumOfNegativeNumbers = sumOfNegativeNumbers + i;
                ++countOfNegativeNumbers;
            }
        }

        System.out.println("Sum of neg: " + sumOfNegativeNumbers);
        int average = (int) (sumOfNegativeNumbers / countOfNegativeNumbers);
        System.out.printf("Average negative number: %d\n", average);

        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallestNumber) {
                smallestNumber = array[i];
                smallestNumberIndex = i;
            }
        }

        System.out.println("Smallest number: " + smallestNumber);

        array[smallestNumberIndex] = average;

        System.out.println("New array: ");
        for (int i : array) {
            System.out.println(i);
        }

    }

}
