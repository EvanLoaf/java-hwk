package com.gmail.evanloafakahaitao.hwk13.task4;

import java.util.List;

public class PrintOldestPersonService {
    
    public void printOldestPerson(List<Person> myList) {
    
        int oldestPersonIndex = 0;
    
        for (int i = 0; i < myList.size(); i++) {
            
            if (myList.get(i).getYearOfBirth() < myList.get(oldestPersonIndex).getYearOfBirth()) {
                oldestPersonIndex = i;
            }
        }
    
        System.out.printf("\nThe oldest person info: \n%s\n", myList.get(oldestPersonIndex).toString());
    }
    
}
