package com.gmail.evanloafakahaitao.hwk07.classTasks.task02;

public class ReplaceLettersService {
    
    private String newWord;
    
    public void replaceLetters(String word) {
        newWord = word.replace("а", "б");
        System.out.println("New word: ");
        System.out.println(newWord);
    }
    
}
