package com.gmail.evanloafakahaitao.hwk07;

import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        String string1 = "First String1";
        String string2 = "Second String2";
        String string4 = string2;
        String string5 = "7";
        String string6 = "QWERTY-123AAA";

        String string3 = string1.format("|%30.5s|", "Vadimio");
        System.out.println(string3);
        System.out.println(String.format(Locale.US, "|%,d|", 228228228));
        System.out.println("--------------------");
        System.out.println(string2.endsWith("2"));
        System.out.println(string2.endsWith("ing2"));
        System.out.println(string2.endsWith("Second String2"));
        System.out.println(string2.endsWith("ing"));
        System.out.println("--------------------");
        System.out.println(string2.equals(string4));
        System.out.println(string5.equals(String.valueOf(7)));
        System.out.println("--------------------");
        System.out.println(string2.compareTo(string4));
        System.out.println(string1.compareTo("First String1"));
        System.out.println(string1.compareTo("First Strin1g"));
        System.out.println("--------------------");
        System.out.println(" w or d ".trim() + "123");
        System.out.println("--------------------");
        System.out.println(string1.intern());
        System.out.println("--------------------");
        System.out.println(string1.startsWith("irs"));
        System.out.println(string1.startsWith("irs", 1));
        System.out.println("--------------------");
        char[] arr = string1.toCharArray();
        for (char x : arr) {
            System.out.println(x);
        }
        System.out.println("--------------------");
        String[] splitting = string6.split("([A-Z]{2})-(\\d+)");
        for (String y : splitting) {
            System.out.println(y);
        }
        String replacing = string6.replaceAll("([A-Z]{2})-(\\d+)", "omegalul");
        System.out.println(replacing);
        System.out.println("--------------------");
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(splitting));
        System.out.println(String.valueOf(arr, 2, 2));
        System.out.println(String.valueOf("omegalul"));
        System.out.println(String.valueOf((float) 5.71));
        
        // Init arr w/o cons
        int n = 10;
        String[][] myArr = new String[n][];
        String[] myArrSingle = new String[n];


    }

}
