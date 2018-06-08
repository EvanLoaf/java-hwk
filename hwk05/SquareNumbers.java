package com.gmail.evanloafakahaitao.hwk05;

import java.util.Scanner;

public class SquareNumbers {

    private int firstNumberOfRange;
    private int lastNumberOfRange;
    private int counter;
    private Scanner in = new Scanner(System.in);

    public void calculateAndShowSquareNumbers() {
        System.out.println("\nTask2.");
        counter = 0;
        System.out.println("First number of the range: ");
        firstNumberOfRange = in.nextInt();
        System.out.println("Last number of the range: ");
        lastNumberOfRange = in.nextInt();
        for (int i = firstNumberOfRange; i <= lastNumberOfRange; i++) {
            counter++;
            System.out.print("Position " + counter + " in the given range: ");
            System.out.println((int) Math.pow(i, 2));
        }
        System.out.println("------------------------");
    }

}
