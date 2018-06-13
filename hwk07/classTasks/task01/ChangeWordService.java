package com.gmail.evanloafakahaitao.hwk07.classTasks.task01;

public class ChangeWordService {
    
    private String myWord;
    private char[] charArray;
    
    // Mozhno prosto vivodit bilo po ocheredi String.chatAt(x)
    // My option works with any word that contains letters {т,о,р}
    
    public void getNewWord(String oldWord) {
        int letter1 = oldWord.indexOf("т");
        int letter2 = oldWord.indexOf("о");
        int letter3 = oldWord.indexOf("р");
        
        char char1 = oldWord.charAt(letter1);
        char char2 = oldWord.charAt(letter2);
        char char3 = oldWord.charAt(letter3);
        
        charArray = new char[]{char1, char2, char3, char1};
        
        myWord = new String(charArray);
        System.out.println(myWord);
    }
}
