package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task1;

import java.util.Scanner;

public class ApplesProblem {

    public void dataInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("Number of students: ");
        int N = in.nextInt();
        System.out.println("Number of apples: ");
        int K = in.nextInt();

        solveProblem(N, K);
    }

    public void solveProblem(int students, int apples) {

        if (students == 0) {
            System.out.println("Apples for each student: 0\n");
            System.out.println("Apples left in the basket: 0");
        } else {
            System.out.printf("Apples for each student: %d\n", (int) Math.floor(apples / students));
            System.out.printf("Apples left in the basket: %d", apples % students);
        }
    }


}
