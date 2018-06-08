package com.gmail.evanloafakahaitao.hwk05.loopsAndArraysPractice;

import java.util.Scanner;

public class Task3 {

    int[] createdArray;
    int arrayLength;
    Scanner in = new Scanner(System.in);

    public void arrayCreation() {
        System.out.print("\nTask3. Please specify the array length: ");
        arrayLength = in.nextInt();
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

    public void findSecondGreatestNumber() {
        int counterOfGreaterNumbers;
        int loopCounter;
        int selfMatch;
        int stopFlag = 0;
        for (int x : createdArray) {
            if (stopFlag == 1) break;
            System.out.println("Now checking: " + x);
            loopCounter = 0;
            counterOfGreaterNumbers = 0;
            selfMatch = 0;
            stopFlag = 0;
            for (int y : createdArray) {
                loopCounter++;
                if (x < y) {
                    counterOfGreaterNumbers++;
                }
                if (x == y) {
                    selfMatch++;
                }
                if (loopCounter == createdArray.length) {
                    if (selfMatch > 1 && counterOfGreaterNumbers == 0) {
                        System.out.println("The 2nd greatest number in the given array is: " + x);
                        System.out.println("It\'s also the greatest one\n" + "Notice: There are 2 or more numbers equal to " + x);
                        stopFlag++;
                    } else if (counterOfGreaterNumbers == 1) {
                        System.out.println("The 2nd greatest number in the given array is: " + x);
                        stopFlag++;
                    }
                }
            }
        }
        System.out.println("------------------------------");
    }

}
