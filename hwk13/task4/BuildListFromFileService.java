package com.gmail.evanloafakahaitao.hwk13.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildListFromFileService {
    
    public List<Person> buildList(String path) {
        
        List<Person> people = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        
            String line = br.readLine();
            while (line != null) {
                
                String[] fields = line.split(" ");
                Person person = new Person(
                        fields[0],
                        fields[1],
                        Integer.valueOf(fields[2])
                );
                
                people.add(person);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("Here is the list we got: ");
        for (Person person : people) {
            System.out.println(person.toString());
        }
        
        return people;
    }
    
}
