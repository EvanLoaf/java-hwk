package com.gmail.evanloafakahaitao.hwk22.trainingTest.task2;

import java.io.*;
import java.util.*;

public class DataStorageDTO {

    private final Deque<String> queue = new ArrayDeque<>();
    private final Map<String, File> filesMap = new HashMap<>();
    private final Random rd = new Random();

    public List<Integer> readData() {
        synchronized (queue) {
            List<Integer> numbersRead = new ArrayList<>();
            try {
                if (queue.isEmpty()) {
                    queue.wait(500);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String fileName = queue.pollFirst();
            if (fileName == null) {
                return null;
            } else {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line = br.readLine();
                    while (line != null) {
                        String cleanLine = line.replaceAll("\r\n?|\n", "");
                        numbersRead.add(Integer.valueOf(cleanLine));
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            queue.notifyAll();
            return numbersRead;
        }
    }

    public void writeData(List<Integer> numbers) {
        synchronized (queue) {
            String fileName = Thread.currentThread().getName() + "_" + rd.nextInt(101) + ".txt";
            File file = new File(fileName);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < numbers.size(); i++) {
                    bw.write(String.valueOf(numbers.get(i)));
                    if (i != numbers.size() - 1) {
                        bw.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            filesMap.put(fileName, file);
            queue.addLast(fileName);
            queue.notifyAll();
        }
    }
}
