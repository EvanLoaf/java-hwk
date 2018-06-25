package com.gmail.evanloafakahaitao.hwk12.task2;

public class BadException extends Exception {
    
    public BadException(String msg) {
        
        super("BadException: " + msg);
    }
    
}
