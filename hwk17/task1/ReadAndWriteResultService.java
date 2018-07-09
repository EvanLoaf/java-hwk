package com.gmail.evanloafakahaitao.hwk17.task1;

import java.io.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAndWriteResultService implements Callable<Integer> {

    private List<File> myList;

    public ReadAndWriteResultService(List<File> myList) {
        this.myList = myList;
    }

    public int readFiles(List<File> list) {
        File resultFile = new File("result.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));
            for (File file : list) {
                if (resultFile.length() != 0) {
                    bw.newLine();
                }
                BufferedReader br = new BufferedReader(new FileReader(file));
                String str = br.readLine();
                System.out.println("Canonical path: " + str);
                if (br.readLine() != null) {
                    System.out.println("File is formatted incorrectly");
                }
                Pattern pattern = Pattern.compile("(?<=\\\\)(?:.(?!\\\\))+(?=\\.)");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    System.out.printf("File name: %s\n", matcher.group());
                    System.out.println("Group count: " + matcher.groupCount());
                }
                bw.write(matcher.group());
                bw.flush();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return (int) resultFile.length();
    }
    
    @Override
    public Integer call() throws Exception {
        return readFiles(myList);
    }
}
