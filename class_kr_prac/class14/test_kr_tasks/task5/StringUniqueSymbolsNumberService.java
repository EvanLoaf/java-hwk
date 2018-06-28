package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringUniqueSymbolsNumberService {

    public String getStr() {

        Scanner in = new Scanner(System.in);
        System.out.println("I need any string: ");
        String str = in.nextLine();

        return str;
    }

    public void printUniqueSymbols(String str) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            String currChar = String.valueOf(str.charAt(i));
            if (map.get(currChar) == null) {
                map.put(currChar, 1);
            } else {
                map.put(currChar, map.get(currChar) + 1);
            }
        }

        System.out.println("Here are the symbols our string had: ");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("Symbol: %s | Repeats %d times.\n", entry.getKey(), entry.getValue());
        }
    }

}
