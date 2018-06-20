package com.gmail.evanloafakahaitao.hwk10.task3;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class PersonListService {
    
    private InputService input = new InputService();
    private List<Person> people;
    private int groupSize;
    private int youngestAge;
    private int oldestAge;
    
    public void makeGroup() {
        System.out.println("How many people do u wanna have in ur group?");
        groupSize = Integer.valueOf(input.getString()); // To avoid nextInt() => nextLine() collision
        people = new ArrayList<>((int) Math.ceil(groupSize / 0.75));
        System.out.println("What would be the youngest age for ur group?");
        youngestAge = Integer.valueOf(input.getString());
        System.out.println("What would be the oldest age for ur group?");
        oldestAge = Integer.valueOf(input.getString());
        for (int i = 0; i < groupSize; i++) {
            Person person = new Person(
                    "PersonName" + i,
                    "mySurname" + i + i,
                    input.getRandomNumberInRange(youngestAge, oldestAge)
            );
            people.add(person);
        }
        ageDistribution(people);
    }
    
    public void ageDistribution(List<Person> myList) {
        System.out.println("Here is the group composition we got ourselves: ");
        for (int i = 0; i < groupSize; i++) {
            Person element = myList.get(i);
            
            if (element.getAge() < 18) {
                System.out.println("Infant: " + element.getName() + " " + element.getSurname() + " " + element.getAge());
            } else {
                System.out.println("Adult: " + element.getName() + " " + element.getSurname() + " " + element.getAge());
            }
        }
    }
    
}
