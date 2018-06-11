package com.gmail.evanloafakahaitao.hwk06;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        // BigInteger
        System.out.println("\nTask0. BigInteger. x*x + y/x.\n");
        BigIntegerService bigInt = new BigIntegerService();
        BigInteger firstNumber = new BigInteger("2"); // Value can be freely changed
        BigInteger secondNumber = new BigInteger("4"); // Value can be freely changed
        bigInt.calcBigInteger(firstNumber, secondNumber);

        // Number length and sum of digits
        System.out.println("\nTask1. Calculate number length and sum of digits.\n");
        NumberLengthService numLengthAndSum = new NumberLengthService();
        numLengthAndSum.numberInput();

        // Random array with ints within a given range
        System.out.println("\nTask2. Filling an array with random numbers from a given range.\n");
        RandomArrayService randArrayOperations = new RandomArrayService();
        randArrayOperations.getData();

        // Random number within a range
        System.out.println("\nTask3. Getting a random number within a [-n; n] range.\n");
        NumberGeneratorService myNumber = new NumberGeneratorService();
        myNumber.getRange();

    }

}
