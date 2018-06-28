package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task4;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MonthCollectionProblem {

    public List<MonthInfo> createList() {

        List<MonthInfo> myList = new ArrayList<>();
        Locale locale = Locale.forLanguageTag("ru");
        for (int i = 0; i < 12; i++) {
            MonthInfo month = new MonthInfo(
                    Month.of(i + 1).getDisplayName(TextStyle.FULL_STANDALONE, locale),
                    Month.of(i + 1).name(),
                    i + 1
            );

            myList.add(month);
        }

        return myList;
    }

    public void printMonth(List<MonthInfo> list) {

        Scanner in = new Scanner(System.in);
        System.out.println("What month do you wanna display?");
        int numOfMonthToPrint = in.nextInt() - 1;

        if (list.get(numOfMonthToPrint) != null) {
            System.out.println(list.get(numOfMonthToPrint).toString());
        } else {
            System.out.println("Choose a number [1; 12]! ");
            printMonth(list);
        }
    }

}
