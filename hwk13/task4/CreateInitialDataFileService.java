package com.gmail.evanloafakahaitao.hwk13.task4;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateInitialDataFileService {
    
    public void createTemplate(String path) {
        
        InputService input = new InputService();
        System.out.println("How many records do u wanna create?");
        int countOfRecords = input.getNumber();
        
        int[] yearsArray = new int[11];
        for (int i = 0; i < yearsArray.length; i++) {
            yearsArray[i] = 1960 + i;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            
            for (int i = 0; i < countOfRecords; i++) {
                
                bw.write(String.format("Name%d Surname%d %d", i + 1, i + 1, yearsArray[new Random().nextInt(yearsArray.length)]));
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
