package com.gmail.evanloafakahaitao.Hwk04;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task1:");

        int firstArray[] = new int[4];
        int secondArray[] = new int[4];

        firstArray[0] = 1;
        firstArray[1] = 2;
        firstArray[2] = 3;
        firstArray[3] = 4;

        secondArray[0] = 5;
        secondArray[1] = 6;
        secondArray[2] = 7;
        secondArray[3] = 8;

        int mergedArray[] = {firstArray[0], firstArray[1], firstArray[2], firstArray[3], secondArray[0], secondArray[1], secondArray[2], secondArray[3]};

        // Checking if you can init an array like above, if it works correctly
        System.out.println(mergedArray[3] + mergedArray[7]);

        int mergedMulttidimArray[][] = new int[2][];

        mergedMulttidimArray[0] = firstArray;
        mergedMulttidimArray[1] = secondArray;

        // Checking if the above code works properly
        System.out.println(mergedMulttidimArray[0][1]);
        System.out.println(mergedMulttidimArray[1][1]);


        System.out.println("\nTask2:");

        int randomYear = 12345;
        int lessRandomYear = 2020;
        numberOfDays(randomYear);
        numberOfDays(lessRandomYear);


        System.out.println("\nTask3:");

        int someNumber = 3;
        timeOfTheYear(someNumber);
    }

    private static void numberOfDays(int year) {
        int leapYear = 366;
        int ordinaryYear = 365;
        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            System.out.println("In " + year + " there are " + leapYear + " days.");
        } else {
            System.out.println("In " + year + " there are " + ordinaryYear + " days.");
        }
    }

    private static void timeOfTheYear(int someNumber) {
        switch (someNumber) {
            case 1:
                System.out.println("Winter");
                break;
            case 2:
                System.out.println("Spring");
                break;
            case 3:
                System.out.println("Summer");
                break;
            case 4:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Allowed range exceeded");
                break;
        }
    }
}
