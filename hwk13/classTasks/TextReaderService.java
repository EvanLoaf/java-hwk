package com.gmail.evanloafakahaitao.hwk13.classTasks;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderService {
    
    public String getText(String path) {
        
        String line;
        String resultStr = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            resultStr = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return resultStr;
    }
    
    public int countSymbols(String str) {
        
        InputService input = new InputService();
        System.out.println("What symbol are we looking for?");
        char charToFind = input.getString().charAt(0);
        int counter = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charToFind) {
                ++counter;
            }
        }
        
        return counter;
    }
    
}
