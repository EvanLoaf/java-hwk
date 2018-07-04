package com.gmail.evanloafakahaitao.hwk16.task2;

import com.gmail.evanloafakahaitao.hwk16.task1.IntArrayMaxValueFinderService;

import java.io.*;

public class WriteArrayToFileService {
    
    public synchronized void writeArrToFile() {
        IntArrayMaxValueFinderService arrService = new IntArrayMaxValueFinderService();
        int[] array = arrService.createArray();
        String filename = "numbers.txt";
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < array.length; i++) {
                bw.write(String.valueOf(array[i]));
                if (i != array.length - 1) {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
