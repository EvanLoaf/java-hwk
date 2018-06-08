package com.gmail.evanloafakahaitao.hwk05;

import java.util.Scanner;

public class DivisibleNumbers {

    private int firstNumber;
    private int lastNumber;
    private String divByThree;
    private Scanner in = new Scanner(System.in);

    public void getRange() {
        System.out.println("\nTask3.");
        System.out.println("First number of the range: ");
        firstNumber = in.nextInt();
        System.out.println("Last number of the range: ");
        lastNumber = in.nextInt();
        getDivByThreeAndNotByFive();
    }

    public void getDivByThreeAndNotByFive() {
        divByThree = "";
        for (int i = firstNumber; i <= lastNumber; i++) {
            if (i % 5 != 0 && i % 3 == 0) {
                divByThree += i + "\n";
            }
        }
        display();
    }

    public void display() {
        System.out.println("Numbers within the given range which are divisible by 3 and not by 5: ");
        System.out.println(divByThree);
        System.out.println("------------------------");
    }

}
