package com.gmail.evanloafakahaitao.hwk06;

import java.util.Scanner;

public class NumberLengthService {

    private Scanner in = new Scanner(System.in);
    private int myNumber;
    private int numberInWork;
    private int countOfDigits;
    private int sumOfDigits;
    private int[] digitsArray;

    public void numberInput() {
        System.out.print("Please, specify the number you wanna analyze: ");
        myNumber = in.nextInt();
        numberAnalysis(myNumber);
    }

    public void numberAnalysis(int num) {
        numberInWork = Math.abs(num);
        if (numberInWork == 0) {
            System.out.println("Number length: " + 0 + " digits.");
            System.out.println("Sum of digits: " + 0 + ".");
        } else {
            countOfDigits = (int) Math.ceil(Math.log10(numberInWork + 0.1));
            System.out.println("Number length: " + countOfDigits + " digits.");
        }

        digitsArray = new int[countOfDigits];

        for (int i = 0; i < countOfDigits; ++i) {
            digitsArray[i] = (int) (numberInWork / Math.pow(10, countOfDigits - i - 1));
            numberInWork -= digitsArray[i] * Math.pow(10, countOfDigits - i - 1);
        }

        sumOfDigits = 0;
        for (int i = 0; i < digitsArray.length; ++i) {
            sumOfDigits += digitsArray[i];
        }
        System.out.println("Sum of digits: " + sumOfDigits + ".");
    }

}
