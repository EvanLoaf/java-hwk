package com.gmail.evanloafakahaitao.hwk24;

import com.gmail.evanloafakahaitao.hwk24.sqltask.WriteSQLFileService;

public class Main {
    
    public static void main(String[] args) {
        WriteSQLFileService writeSQL = new WriteSQLFileService();
        writeSQL.setCommandsAndWrite();
    }
}
