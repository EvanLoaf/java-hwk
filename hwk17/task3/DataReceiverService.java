package com.gmail.evanloafakahaitao.hwk17.task3;

import java.util.ArrayDeque;
import java.util.Deque;

public class DataReceiverService implements Runnable {
    
    private final Deque<Integer[]> dataQueue = new ArrayDeque<>();
    private DataFile dataFile;
    private int linesToWriteTotal;
    private int linesPerCycle;
    
    public DataReceiverService(DataFile dataFile, int linesToWriteTotal, int linesPerCycle) {
        this.dataFile = dataFile;
        this.linesToWriteTotal = linesToWriteTotal;
        this.linesPerCycle = linesPerCycle;
    }
    
    @Override
    public void run() {
        int numOfReads = (linesToWriteTotal + linesPerCycle - 1) / linesPerCycle;
        for (int j = 0; j < numOfReads; j++) {
            String currentData = dataFile.receiveData(linesPerCycle);
            if (currentData == null) {
                System.out.println("DT is over.");
                return;
            }
            String[] stringNumbersReceived = currentData.split(",");
            Integer[] currentCycleReceivedNumbers = new Integer[stringNumbersReceived.length];
            for (int i = 0; i < currentCycleReceivedNumbers.length; i++) {
                currentCycleReceivedNumbers[i] = Integer.valueOf(stringNumbersReceived[i]);
            }
            dataFile.writeToDeque(currentCycleReceivedNumbers);
        }
    }
    
    public Integer[] getDequeElement() {
        return dataFile.readFromDeque();
    }
}
