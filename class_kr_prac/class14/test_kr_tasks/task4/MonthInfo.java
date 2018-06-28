package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task4;

public class MonthInfo {

    private String rusName;
    private String engName;
    private int number;

    public MonthInfo(String rusName, String engName, int number) {
        this.rusName = rusName;
        this.engName = engName;
        this.number = number;
    }

    public String getRusName() {
        return rusName;
    }

    public String getEngName() {
        return engName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "MonthInfo{" +
                "rusName='" + rusName + '\'' +
                ", engName='" + engName + '\'' +
                ", number=" + number +
                '}';
    }
}
