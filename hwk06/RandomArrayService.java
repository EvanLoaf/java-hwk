package com.gmail.evanloafakahaitao.hwk06;

import java.util.Random;
import java.util.Scanner;

public class RandomArrayService {

    Scanner in = new Scanner(System.in);
    Random rd = new Random();
    int arrayLength;
    int lowerBound = 0;
    int upperBound = 0;
    int rangeSize;
    int evenNumbersCounter;
    int[] myArray;

    public void getData() {
        System.out.print("Specify the array length: ");
        arrayLength = in.nextInt();
        System.out.print("Specify the lower bound for the random numbers generator range: ");
        lowerBound = in.nextInt();
        System.out.print("Specify the upper bound for the random numbers generator range: ");
        upperBound = in.nextInt();
        rangeSize = upperBound - lowerBound;
        createArray();
    }

    public void createArray() {
        myArray = new int[arrayLength];
        System.out.println("Here goes the array: ");
        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = rd.nextInt(rangeSize + 1) + lowerBound;
            System.out.println(myArray[i]);
        }
        calcEvenNumber();
    }

    public void calcEvenNumber() {
        evenNumbersCounter = 0;
        for (int x : myArray) {
            if (x % 2 == 0) {
                ++evenNumbersCounter;
            } else continue;
        }
        System.out.println("There are " + evenNumbersCounter + " even numbers in the array.");
    }

}
