package com.gmail.evanloafakahaitao.hwk12.task1;

public class NPEService {
    
    public void npe() {
        
        try {
            throw new NullPointerException("E R R O R");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
}
