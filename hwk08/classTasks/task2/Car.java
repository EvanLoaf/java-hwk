package com.gmail.evanloafakahaitao.hwk08.classTasks.task2;

public class Car {

    protected String brand;
    private int weight;
    private int hp;
    
    public Car(String brand, int weight, int hp) {
        this.brand = brand;
        this.weight = weight;
        this.hp = hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void changeHp(int deltaHp) {
        this.hp = this.hp + deltaHp;
    }
    
    public void printInfo() {
        System.out.println("\nBrand: " + brand + "\nWeight: " + weight + "\nHorse powers: " + hp);
    }
}
