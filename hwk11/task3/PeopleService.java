package com.gmail.evanloafakahaitao.hwk11.task3;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.*;

public class PeopleService {
    
    public void createPeopleSet() {
        
        InputService input = new InputService();
        System.out.println("\nHow many people do u wanna create?");
        int numberOfPeople = input.getNumber();
        
        Set<Person> set = new HashSet<>();
        System.out.println("\nEarliest year of birth: ");
        int earlierYearOfBirth = input.getNumber();
        System.out.println("\nLatest year of birth: ");
        int latestYearOfBirth = input.getNumber();
        for (int i = 0; i < numberOfPeople; i++) {
            Person person = new Person(
                    "Name" + (i + 1),
                    "Surname" + (i + 1),
                    input.getRandomNumberInRange(earlierYearOfBirth, latestYearOfBirth)
            );
            set.add(person);
        }
    
        System.out.println("\nPeople with their birth years in ascending order: ");
        for (int i = earlierYearOfBirth; i <= latestYearOfBirth; i++) {
            Iterator<Person> iterator = set.iterator();
            while (iterator.hasNext()) {
                Person iter = iterator.next();
                if (iter.getYearOfBirth() == i) {
                    System.out.printf("\nYear: %d, Surname: %s, Name: %s", iter.getYearOfBirth(), iter.getSurname(), iter.getName());
                }
            }
        }
        
        /*Iterator<Person> iterator = set.iterator();
        
        Map<Integer, Integer> yearsOfBirthMap = new HashMap<>();
        
        while (iterator.hasNext()) {
            Person iter = iterator.next();
            if (yearsOfBirthMap.containsKey(iter.getYearOfBirth())) {
                int currYearCount = yearsOfBirthMap.get(iter.getYearOfBirth());
                yearsOfBirthMap.put(iter.getYearOfBirth(), currYearCount + 1);
                continue;
            }
            yearsOfBirthMap.put(iter.getYearOfBirth(), 1);
        }
    
        System.out.println("\nPeople with their birth years in ascending order: ");
        for (int i = earlierYearOfBirth; i <= latestYearOfBirth; i++) {
            if (yearsOfBirthMap.containsKey(i)) {
                for (int j = 0; j < yearsOfBirthMap.get(i); j++) {
                    iterator = set.iterator();
                    while ()
                    System.out.printf("\nYear: %d, Surname: %s, Name: %s", );
                }
            }
        }*/
        
        
    }
}
