package com.gmail.evanloafakahaitao.hwk08.classTasks.task1;

public class Man {
    
    private String name;
    private int age;
    private String gender = "Male";
    private int weight;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public void getInfo() {
        System.out.println("\nMy name is: " + this.name + "\nMy age is: " + this.age + "\nMy gender is: " + this.gender + "\nMy weight is: " + this.weight);
    }
    
}
