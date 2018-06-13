package com.gmail.evanloafakahaitao.hwk07.classTasks.task04;

public class DigitsCounterService {
    
    private String testString;
    private int initLength;
    private int finalLength;
    
    public int countDigitsNine(String str) {
        testString = str;
        initLength = testString.length();
        testString = testString.replaceAll("9", "");
        finalLength = testString.length();
        return initLength - finalLength;
    }
    
}
