package com.gmail.evanloafakahaitao.hwk10.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class StringCollectionService {
    
    private InputService input = new InputService();
    private List<String> stringList;
    private int listLength;
    private String toReplace;
    private String replaceWith;
    private String currentElement;
    
    public void buildList() {
        System.out.println("How many strings do you wanna have in this list?");
        listLength = Integer.valueOf(input.getString()); // To avoid nextInt() => nextLine() collision
        stringList = new ArrayList<>((int) Math.ceil(listLength / 0.75));
        System.out.println("\nType in " + listLength + " strings to fill in the List");
        for (int i = 0; i < listLength; i++) {
            stringList.add(input.getString());
        }
        System.out.println("\nHere is the initial List: ");
        for (String s : stringList) {
            System.out.println(s);
        }
        
        replace(stringList);
    }
    
    public void replace(List<String> myList) {
        System.out.println("\nWhat part of the strings do u wanna replace?");
        toReplace = input.getString();
        System.out.println("\nWhat do u wanna replace it with?");
        replaceWith = input.getString();
        for (int i = 0; i < listLength; i++) {
            if (myList.get(i).indexOf(toReplace) > -1) {
                currentElement = myList.get(i);
                myList.remove(i);
                currentElement = currentElement.replace(toReplace, replaceWith);
                myList.add(i, currentElement);
            }
        }
        
        printResult(myList);
    }
    
    public void printResult(List<String> myList) {
        System.out.println("\nHere is the List we got: ");
        for (String s : myList) {
            System.out.println(s);
        }
    }
    
}
