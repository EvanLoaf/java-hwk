package com.gmail.evanloafakahaitao.hwk13.task3;

import java.io.*;

public class RemoveShortWordsService {
    
    public String readText(String path) {
        
        String text = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
            text = sb.toString();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return text;
    }
    
    public String correctTheText(String text) {
        
        String[] lines = text.split(System.lineSeparator());
        StringBuilder myNewText = new StringBuilder();
        
        for (String line : lines) {
            String[] words = line.split(" ");
            
            for (String word : words) {
                
                String wordWithoutSymbols = word.replaceAll("\\W", "");
                
                if (wordWithoutSymbols.length() > 5 || wordWithoutSymbols.length() < 3) {
                    myNewText.append(word);
                    myNewText.append(" ");
                } else continue;
            }
            
            myNewText.append(System.lineSeparator());
        }
        
        String myNewTextString = myNewText.toString();
        
        return myNewTextString;
    }
    
    public void writeNewText(String text) {
    
        String path = "src/com/gmail/evanloafakahaitao/hwk13/task3/";
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "new_text_without_short_words.txt"))) {
            
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
