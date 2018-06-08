package com.gmail.evanloafakahaitao.hwk05.loopsAndArraysPractice;

public class Task1 {

    public void arrayOperations(int n, int m) {
        //  - array length, m - num of element [1 ; +inf)
        if (m > n) {
            throw new Error("Range exceeded. Array Length (n) < index of element (m)");
        } else {
            int[] myArray = new int[n];
            for (int i = 0; i < n; i++) {
                myArray[i] = (int) (Math.random() * 1e5);
            }
            int initial = myArray[m - 1];
            myArray[m - 1] = (int) (myArray[m - 1] * 1.1);
            System.out.println("Initial value of an element Nr " + m + " is " + initial + ", new value is " + myArray[m - 1]);
            System.out.println("------------------------------");
        }
    }

}
