package com.gmail.evanloafakahaitao.hwk17.classTasks.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TextWriterCallableService implements Callable<List<String>> {
    @Override
    public List<String> call() throws Exception {
        List<String> files = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 10 files
            String fileName = Thread.currentThread().getName() + ThreadLocalRandom.current().nextInt(1000) + "_" + i + "_" + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write("Random string::" + Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(fileName);
        }
        Thread.sleep((ThreadLocalRandom.current().nextInt(3) + 1) * 1000);
        
        return files;
    }
}
