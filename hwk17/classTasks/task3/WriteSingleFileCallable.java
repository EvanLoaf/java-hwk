package com.gmail.evanloafakahaitao.hwk17.classTasks.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Callable;

public class WriteSingleFileCallable implements Callable<String> {
    
    private static BufferedWriter bw;
    
    static {
        try {
            bw = new BufferedWriter(new FileWriter("helloworld.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String call() throws Exception {
        return writeFile();
    }
    
    public void closeStream() {
        try {
            this.bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private synchronized String writeFile() {
        String str = Thread.currentThread().getName() + " Hello World " + LocalDateTime.now();
        try {
            bw.write(str);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
