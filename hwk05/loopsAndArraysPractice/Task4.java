package com.gmail.evanloafakahaitao.hwk05.loopsAndArraysPractice;

import java.util.Scanner;

public class Task4 {

    int[] firstArray;
    int[] secondArray;
    int arrayLength;
    int smallestNumberIndex;
    Scanner in = new Scanner(System.in);

    public void arraysCreation() {
        System.out.print("\nTask4. Please specify the array length: ");
        arrayLength = in.nextInt();
        if (arrayLength < 1) {
            throw new Error("Serious Mistake! Array Length is [1;+inf)");
        }
        int[] myArrayOne = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            myArrayOne[i] = (int) (Math.random() * 10);
        }
        firstArray = myArrayOne;
        System.out.println("The first array is: ");
        for (int x : firstArray) {
            System.out.println(x);
        }
        int[] myArrayTwo = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            myArrayTwo[i] = (int) (Math.random() * 10);
        }
        secondArray = myArrayTwo;
        System.out.println("The second array is: ");
        for (int x : secondArray) {
            System.out.println(x);
        }
    }

    public void findMatchingElement() {
        int counterOfLesserNumbers;
        int loopCounter;
        int indexCounter = -1;
        int stopFlag = 0;
        for (int x : firstArray) {
            indexCounter++;
            if (stopFlag == 1) break;
            stopFlag = 0;
            System.out.println("Now checking: " + x);
            loopCounter = 0;
            counterOfLesserNumbers = 0;
            for (int y : firstArray) {
                loopCounter++;
                if (x > y) {
                    counterOfLesserNumbers++;
                }
                if (loopCounter == arrayLength && counterOfLesserNumbers == 0) {
                    System.out.println("The smallest number in the first array is: " + x);
                    stopFlag++;
                    smallestNumberIndex = indexCounter;
                }
            }
        }
    }

    public void displayMatchingElement() {
        System.out.println("The index of the smallest number in the first array is: " + smallestNumberIndex);
        System.out.println("Here is an item from the second array with the same index: " + secondArray[smallestNumberIndex]);
        System.out.println("------------------------------");
    }

}
