package com.gmail.evanloafakahaitao.hwk10.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class NumberCollectionService {
    
    private InputService input = new InputService();
    private List<Integer> numbersList;
    private int firstMax;
    private int secondMax;
    private int listLength;
    
    public void buildList() {
        System.out.println("How many numbers do you wanna have in this list?");
        listLength = input.getNumber();
        numbersList = new ArrayList<>((int) Math.ceil(listLength / 0.75));
        for (int i = 0; i < listLength; i++) {
            numbersList.add(input.getRandomNumberInRange(2, 98));
        }
        System.out.println("\nHere is the list: ");
        for (Integer integer : numbersList) {
            System.out.print(integer + " ");
        }
        printTwoMax(numbersList);
    }
    
    public void printTwoMax(List<Integer> myList) {
        
        if (myList.size() < 2) {
            System.out.println("\nList size is too small");
            return;
        }
        
        if (myList.get(0) > myList.get(1)) {
            firstMax = myList.get(0);
            secondMax = myList.get(1);
        } else if (myList.get(0) <= myList.get(1)) {
            firstMax = myList.get(1);
            secondMax = myList.get(0);
        }
        
        for (int i = 2; i < myList.size(); i++) {
            if (myList.size() == 2) {
                break;
            }
            
            if (myList.get(i) > secondMax) {
                if (myList.get(i) >= firstMax) {
                    secondMax = firstMax;
                    firstMax = myList.get(i);
                } else secondMax = myList.get(i);
            }
        }
        
        System.out.println("\nLargest number: " + firstMax + "\nSecond largest number: " + secondMax);
    }
    
}
