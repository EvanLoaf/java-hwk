package com.gmail.evanloafakahaitao.hwk13.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileFromConsoleService {
    
    public void fileWriter(String path) {
        
        InputService input = new InputService();
        System.out.println("How many numbers do u wanna enter?");
        int countOfNumbers = input.getNumber();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            
            System.out.printf("Enter %d numbers.\n", countOfNumbers);
            for (int i = 0; i < countOfNumbers; i++) {
                int currNumber = input.getNumber();
                bw.write(String.valueOf(currNumber));
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
