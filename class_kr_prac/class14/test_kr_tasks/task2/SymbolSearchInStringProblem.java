package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task2;

import java.util.Scanner;

public class SymbolSearchInStringProblem {

    public void getString() {

        Scanner in = new Scanner(System.in);
        System.out.println("String to work with: ");
        String str = in.nextLine();
        System.out.println("Char to find: ");
        char myChar = in.next().charAt(0);

        System.out.printf("Num of chars %s - %d", myChar, countChars(str, myChar));
    }

    public int countChars(String str, char myChar) {

        int numOfChars = 0;
        char[] stringToCharArray = str.toCharArray();
        for (char c : stringToCharArray) {
            if (c == myChar) {
                ++numOfChars;
            }
        }

        // Luchshe equals i String char vs chari 0 - length

        return numOfChars;
    }

}
