package com.gmail.evanloafakahaitao.hwk07.task01;

public class SymbolsSimilarToLastService {
    
    private int counter;
    
    public void indicesOfSymbolsSimilarToTheLastOne(String str) {
        System.out.println("Here are the indices of chars similar to last char of the given String: ");
        counter = 0;
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(str.length() - 1)) {
                System.out.println(i);
                ++counter;
            }
        }
        if (counter < 1) {
            System.out.println("\nNone were found :(");
        }
    }
    
}
