package com.gmail.evanloafakahaitao.hwk19.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CreatePeopleAndPrintService {
    
    public void createAndPrint() {
        InputService input = new InputService();
        List<PersonWithBuilder> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 10 obj
            PersonWithBuilder person = new PersonWithBuilder.MyPersonBuilder()
                    .withYear(input.getRandomNumberInRange(2000, 2002))
                    .withSurame(String.format("Surname%d", i + 1))
                    .withName(String.format("Name%d", i + 1))
                    .build();
            list.add(person);
        }
        Iterator<PersonWithBuilder> iterator = list.iterator();
        while (iterator.hasNext()) {
            PersonWithBuilder person = iterator.next();
            System.out.println(person);
        }
        PeopleComparator comparator = new PeopleComparator();
        System.out.println("-- Sorting --");
        Collections.sort(list, comparator);
        Iterator<PersonWithBuilder> sortedIterator = list.iterator();
        while (sortedIterator.hasNext()) {
            PersonWithBuilder person = sortedIterator.next();
            System.out.println(person);
        }
    }
    
}
