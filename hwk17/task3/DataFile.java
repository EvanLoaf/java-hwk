package com.gmail.evanloafakahaitao.hwk17.task3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class DataFile {

    private final Deque<Integer[]> dataQueue = new ArrayDeque<>();
    private final File dataFile = new File("mydata.txt");
    private long charactersProcessed = 0;
    private boolean newData = false;
    private int maxIterationsCount = 5;

    public void sendData(String data) {
        synchronized (dataFile) {
            while (newData) {
                try {
                    dataFile.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, true))) {
                if (dataFile.length() != 0) {
                    bw.newLine();
                }
                bw.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nData has been sent.");
            this.newData = true;
            dataFile.notifyAll();
        }
    }

    public String receiveData(int linesPerCycle) {
        StringBuilder received = new StringBuilder();
        synchronized (dataFile) {
            int countOfIterations = 0;
            while (!newData && countOfIterations < maxIterationsCount) {
                try {
                    dataFile.wait(1000);
                    ++countOfIterations;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (countOfIterations == maxIterationsCount) {
                System.out.println("NO data is being received anymore.");
                return null;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
                br.skip(charactersProcessed);
                for (int i = 0; i < linesPerCycle; i++) {
                    String line = br.readLine();
                    if (line != null && line != "") {
                        charactersProcessed += line.length();
                        System.out.println("line: " + line);
                        received.append(line);
                        if (i != linesPerCycle - 1) {
                            received.append(",");
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            charactersProcessed += 2 * linesPerCycle;
            System.out.println("processed: " + charactersProcessed);
            System.out.println("Data has been received.");
            this.newData = false;
            dataFile.notifyAll();
        }
        return received.toString();
    }

    public void writeToDeque(Integer[] array) {
        synchronized (dataQueue) {
            dataQueue.addLast(array);
            dataQueue.notifyAll();
        }
    }

    public Integer[] readFromDeque() {
        Integer[] data = null;
        synchronized (dataQueue) {
            if (dataQueue.isEmpty()) {
                try {
                    dataQueue.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data = dataQueue.pollFirst();
            dataQueue.notifyAll();
        }
        return data;
    }
}
