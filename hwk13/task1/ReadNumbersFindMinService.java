package com.gmail.evanloafakahaitao.hwk13.task1;

import java.io.*;

public class ReadNumbersFindMinService {
    
    public int[] read(String path, int arrLength) {
        
        int[] numbersArray = null;
        
        try (FileInputStream fis = new FileInputStream(path)) {
            
            numbersArray = new int[arrLength];
            
            int nextChar = fis.read();
            char nextNum = (char) nextChar;
            String currentNumber = "";
            int numbersCount = 0;
            
            while (nextChar != -1) {
                
                if (nextNum == ' ') {
                    
                    numbersArray[numbersCount] = Integer.valueOf(currentNumber);
                    ++numbersCount;
                    nextChar = fis.read();
                    nextNum = (char) nextChar;
                    currentNumber = "";
                    continue;
                }
                
                currentNumber = currentNumber + nextNum;
                nextChar = fis.read();
                nextNum = (char) nextChar;
            }
            numbersArray[numbersCount] = Integer.valueOf(currentNumber);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numbersArray;
    }
    
    public int getMinNumber(int[] arr) {
        
        int min = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        }
        
        return min;
    }
    
}
