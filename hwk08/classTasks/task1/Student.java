package com.gmail.evanloafakahaitao.hwk08.classTasks.task1;

public class Student extends Man {
    
    private int yearOfStudy;
    
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    public void skipYear(int yearsToSkip) {
        this.yearOfStudy = this.yearOfStudy + yearsToSkip;
    }
    
    public void getInfo() {
        super.getInfo();
        System.out.println("I'm a student[year: " + this.yearOfStudy + "]");
    }
}
