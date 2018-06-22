package com.gmail.evanloafakahaitao.hwk11.task3;

import java.util.Objects;

public class Person {
    
    private String name;
    private String surname;
    private int yearOfBirth;
    
    public Person(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(name, surname, yearOfBirth);
    }
}
