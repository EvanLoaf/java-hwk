package com.gmail.evanloafakahaitao.hwk05;

import java.util.Scanner;

public class DaysCounter {

    private int firstYear;
    private int lastYear;
    private int sumOfYears = 0;
    private Scanner in = new Scanner(System.in);

    public void daysCounter() {
        System.out.println("\nTask1.");
        sumOfYears = 0;
        System.out.println("The first year is: ");
        firstYear = in.nextInt();
        System.out.println("The last year is: ");
        lastYear = in.nextInt();
        if (lastYear < firstYear) {
            throw new Error("Range error. The last year of the range must be equal or greater than the first year.");
        }
        for (int i = firstYear; i <= lastYear; i++) {
            if (i % 400 == 0 || i % 100 != 0 && i % 4 == 0) {
                sumOfYears += 366;
            } else sumOfYears += 365;
        }

        displayDaysCounter();

    }

    public void displayDaysCounter() {
        System.out.println("There are " + sumOfYears + " days in " + firstYear + " - " + lastYear);
        System.out.println("------------------------");
    }

}
