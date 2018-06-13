package com.gmail.evanloafakahaitao.hwk07.classTasks.task03;

public class DeleteDigitsService {
    
    // Sdelat kak na photo s ego prezent - tam DR Sposob!
    // Regexp:
    // String newLine = line.replaceAll("\\d", ""); cherez RegExp
    private String newWord;
    
    public String deleteDigitsCasual(String word) {
        newWord = word;
        for (int i = 0; i < 10; ++i) {
            newWord = newWord.replace(String.valueOf(i), "");
        }
        return newWord;
    }
    
    public String deleteDigitsRegexp(String word) {
        newWord = word;
        newWord = newWord.replaceAll("\\d", "");
        return newWord;
    }
    
}
