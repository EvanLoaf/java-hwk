package com.gmail.evanloafakahaitao.hwk07;

import java.util.Scanner;

public class StringScannerService {
    
    private Scanner in = new Scanner(System.in);
    
    public String getStringFromConsole() {
        return in.nextLine();
    }
    
}
