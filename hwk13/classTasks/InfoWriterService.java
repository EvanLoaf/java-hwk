package com.gmail.evanloafakahaitao.hwk13.classTasks;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoWriterService {
    
    public List<Person> createListOfPeople() {
        
        InputService input = new InputService();
        System.out.println("How many people to create?");
        int numOfPeople = input.getNumber();
        List<Person> ppl = new ArrayList<>(numOfPeople);
        
        for (int i = 0; i < numOfPeople; i++) {
            Person person = new Person(
                    "Name " + i,
                    "Surname " + i,
                    input.getRandomNumberInRange(1980, 2000)
            );
            ppl.add(person);
        }
        
        return ppl;
    }
    
    public void writeListToFile(List<Person> list, String path) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            
            for (Person person : list) {
                bw.write(person.toString());
                bw.write(System.lineSeparator());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
}
