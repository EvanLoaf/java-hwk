package com.gmail.evanloafakahaitao.hwk17.task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomFilesWriterService {

    public List<File> writeFiles(int numOfFiles) {
        List<File> list = new ArrayList<>();
        for (int i = 0; i < numOfFiles; i++) {
            File file = new File(String.format("testfile%d.txt", i + 1));
            try {
                boolean fileCreated = file.createNewFile();
                if (fileCreated) {
                    System.out.println(String.format("File%d created.", i + 1));
                } else {
                    System.out.println(String.format("File%d already exists. Overriding.", i + 1));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(file);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
