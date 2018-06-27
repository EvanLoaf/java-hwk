package com.gmail.evanloafakahaitao.hwk13.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NumbersFileService {
    
    public int writeNumbersFile(String path) {
        
        InputService input = new InputService();
        System.out.println("How many numbers do you want to generate?");
        int countOfNumbers = input.getNumber();
        System.out.println("Min number?");
        int min = input.getNumber();
        System.out.println("Max?");
        int max = input.getNumber();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            
            for (int i = 0; i < countOfNumbers; i++) {
                int randomNumber = input.getRandomNumberInRange(min, max);
                bw.write(String.valueOf(randomNumber));
                if (i != countOfNumbers - 1) {
                    bw.write(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return countOfNumbers;
    }
    
}
