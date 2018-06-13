package com.gmail.evanloafakahaitao.hwk07.task02;

import com.gmail.evanloafakahaitao.hwk07.StringScannerService;

public class StringsWithSubstringService {
    
    private StringScannerService scannerService = new StringScannerService();
    private String[] stringsArray;
    private int countOfStrings;
    
    public void getStrings(int number) {
        stringsArray = new String[number];
        System.out.println("Please, enter " + number + " strings to complete our array: ");
        for (int i = 0; i < number; ++i) {
            stringsArray[i] = scannerService.getStringFromConsole();
        }
        printStringsWithSubstr(stringsArray);
    }
    
    public void printStringsWithSubstr(String[] arr) {
        System.out.println("Strings containing words 'cat' or 'dog': ");
        countOfStrings = 0;
        for (String x : arr) {
            if (x.contains("cat") || x.indexOf("dog") > -1) {
                ++countOfStrings;
                System.out.println("\n * ");
                System.out.println(x);
                System.out.println("String length: " + x.length());
            }
        }
        System.out.println("\n" + (arr.length - countOfStrings) + " strings do not meet the criteria.");
    }
    
}
