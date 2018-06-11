package com.gmail.evanloafakahaitao.hwk06;

import java.util.Random;
import java.util.Scanner;

public class NumberGeneratorService {

    Scanner in = new Scanner(System.in);
    Random rd = new Random();
    int rangeBound;
    int myNumber;
    double toMultiplyOrNotToMultiplyIsTheQuestion;
    int randomNumber;

    public void getRange() {
        System.out.print("Please specify the range bound n for the range [-n; n]: ");
        rangeBound = in.nextInt();
        generateNumberWithSubtraction(rangeBound);
        generateNumberWithMultiplication(rangeBound);
    }

    public void generateNumberWithSubtraction(int range) {
        myNumber = rd.nextInt(2 * range + 1) - range;
        System.out.println("Random number with subtraction method: " + myNumber);
    }

    public void generateNumberWithMultiplication(int range) {
        toMultiplyOrNotToMultiplyIsTheQuestion = Math.random();
        randomNumber = rd.nextInt(range + 1);
        if (toMultiplyOrNotToMultiplyIsTheQuestion < 0.5) {
            myNumber = -randomNumber;
        } else myNumber = randomNumber;
        System.out.println("Random number with multiplication method: " + myNumber);
    }

}
