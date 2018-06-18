package com.gmail.evanloafakahaitao.hwk08;

import com.gmail.evanloafakahaitao.hwk08.classTasks.task1.Student;
import com.gmail.evanloafakahaitao.hwk08.classTasks.task2.Lorry;

public class Main {
    
    public static void main(String[] args) {
        
        // Task 1 - Man, Student
        Student evgeniy = new Student();
        evgeniy.setName("zhenya");
        evgeniy.setAge(11);
        evgeniy.setWeight(111);
        evgeniy.setYearOfStudy(2);
        evgeniy.getInfo();
        evgeniy.skipYear(2);
        evgeniy.getInfo();
        
        // Task 2 - Cars
        Lorry van = new Lorry("GEELY", 2000, 50, 300);
        van.printInfo();
        van.changeHp(999);
        van.changeCapacity(2000);
        van.changeBrand("AMG");
        van.printInfo("Never buy Geely");
        
    }
    
}
