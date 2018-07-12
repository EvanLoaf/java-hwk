package com.gmail.evanloafakahaitao.hwk17.task3;

import java.util.concurrent.ThreadLocalRandom;

public class DataSenderService implements Runnable {
    
    private DataFile dataFile;
    private int linesToWriteTotal;
    private int linesPerCycle;
    private int numbersPerLine;
    
    public DataSenderService(DataFile dataFile, int linesToWriteTotal, int linesPerCycle, int numbersPerLine) {
        this.dataFile = dataFile;
        this.linesToWriteTotal = linesToWriteTotal;
        this.linesPerCycle = linesPerCycle;
        this.numbersPerLine = numbersPerLine;
    }
    
    @Override
    public void run() {
        int writingOperationsCount = (linesToWriteTotal + linesPerCycle - 1) / linesPerCycle;
        for (int k = 0; k < writingOperationsCount; k++) {
            StringBuilder sb = new StringBuilder();
            if (k != writingOperationsCount - 1) {
                for (int i = 0; i < linesPerCycle; i++) {
                    for (int j = 0; j < numbersPerLine; j++) {
                        sb.append(ThreadLocalRandom.current().nextInt(101));
                        if (j != numbersPerLine - 1) {
                            sb.append(",");
                        }
                    }
                    if (i != linesPerCycle - 1) {
                        sb.append(System.lineSeparator());
                    }
                }
            } else {
                for (int i = 0; i < linesToWriteTotal % linesPerCycle; i++) {
                    for (int j = 0; j < numbersPerLine; j++) {
                        sb.append(ThreadLocalRandom.current().nextInt(101));
                        if (j != numbersPerLine - 1) {
                            sb.append(",");
                        }
                    }
                    if (i != linesPerCycle - 1) {
                        sb.append(System.lineSeparator());
                    }
                }
            }
            dataFile.sendData(sb.toString());
        }
        System.out.println("Writing file is finished.");
    }
}
