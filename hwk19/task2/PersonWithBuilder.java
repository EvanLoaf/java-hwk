package com.gmail.evanloafakahaitao.hwk19.task2;

public class PersonWithBuilder {

    private String name;
    private String surname;
    private Integer year;
    
    private PersonWithBuilder(MyPersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.year = builder.year;
    }
    
    public static class MyPersonBuilder {
    
        private String name;
        private String surname;
        private Integer year;
    
        public MyPersonBuilder withName(String name) {
            this.name = name;
            return this;
        }
    
        public MyPersonBuilder withSurame(String surname) {
            this.surname = surname;
            return this;
        }
        
        public MyPersonBuilder withYear(int year) {
            this.year = year;
            return this;
        }
        
        public PersonWithBuilder build() {
            return new PersonWithBuilder(this);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public Integer getYear() {
        return year;
    }
    
    @Override
    public String toString() {
        return "MyPersonBuilder{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                '}';
    }
}
