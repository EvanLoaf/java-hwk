package com.gmail.evanloafakahaitao.hwk05.loopsAndArraysPractice;

import java.util.Scanner;

public class Task2 {

    int[] createdArray;
    Scanner in = new Scanner(System.in);

    public void arrayCreation() {
        System.out.print("\nTask2. Please specify the array length: ");
        int arrayLength = in.nextInt();
        if (arrayLength < 1) {
            throw new Error("Serious Mistake! Array Length is [1;+inf)");
        }
        int[] myArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            myArray[i] = (int) (Math.random() * 10);
        }
        createdArray = myArray;
        System.out.println("Created array is: ");
        for (int x : createdArray) {
            System.out.println(x);
        }
    }

    public void arraySearch() {
        System.out.print("\nPlease choose the number to look for: ");
        int number = in.nextInt();
        int counter = -1;
        for (int x : createdArray) {
            counter++;
            if (x == number) {
                int sumBefore = 0;
                int sumAfter = 0;
                for (int i = 0; i < counter; i++) {
                    sumBefore += createdArray[i];
                }
                System.out.println("The sum of numbers before \'" + number + "\' is: " + sumBefore);
                for (int i = counter + 1; i < createdArray.length; i++) {
                    sumAfter += createdArray[i];
                }
                System.out.println("The sum of numbers after \'" + number + "\' is: " + sumAfter);
                break;
            } else if (counter + 1 == createdArray.length) {
                System.out.println("There is no \'" + number + "\' in the array.");
            }
        }
        System.out.println("------------------------------");
    }

}
