package com.gmail.evanloafakahaitao.hwk05.loopsAndArraysPractice;

import java.util.Scanner;

public class MainAddTasks {

    public static void main(String[] args) {

        // Task 1
        Task1 task1 = new Task1();
        Scanner in = new Scanner(System.in);
        System.out.print("\nTask1. Please specify the array length: ");
        int arrLength = in.nextInt();
        System.out.println("Please choose an element to multiply by 1.1: ");
        int numOfElement = in.nextInt();
        task1.arrayOperations(arrLength, numOfElement);

        // Task 2
        Task2 task2 = new Task2();
        task2.arrayCreation();
        task2.arraySearch();

        // Task 3
        Task3 task3 = new Task3();
        task3.arrayCreation();
        task3.findSecondGreatestNumber();

        // Task 4
        Task4 task4 = new Task4();
        task4.arraysCreation();
        task4.findMatchingElement();
        task4.displayMatchingElement();

    }


}
