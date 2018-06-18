package com.gmail.evanloafakahaitao.hwk08.classTasks.task2;

public class Lorry extends Car {
    
    private int capacity;
    
    public Lorry(String brand, int weight, int hp, int capacity) {
        super(brand, weight, hp);
        this.capacity = capacity;
    }
    
    public void changeCapacity(int deltaCapacity) {
        this.capacity = this.capacity + deltaCapacity;
    }
    
    public void changeBrand(String newBrand) {
        this.brand = newBrand;
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Lorry capacity: " + capacity);
    }
    
    public void printInfo(String advice) {
        this.printInfo();
        System.out.println("By the way: " + advice);
    }
    
}
