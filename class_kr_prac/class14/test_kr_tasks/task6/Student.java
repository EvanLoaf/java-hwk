package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task6;

public class Student {

    private int number;
    private String fio;
    private int mathMark;
    private int englishMark;
    private int russianMark;

    public Student(int number, String fio, int mathMark, int englishMark, int russianMark) {
        this.number = number;
        this.fio = fio;
        this.mathMark = mathMark;
        this.englishMark = englishMark;
        this.russianMark = russianMark;
    }

    public int getNumber() {
        return number;
    }

    public String getFio() {
        return fio;
    }

    public int getMathMark() {
        return mathMark;
    }

    public int getEnglishMark() {
        return englishMark;
    }

    public int getRussianMark() {
        return russianMark;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", fio='" + fio + '\'' +
                ", mathMark=" + mathMark +
                ", englishMark=" + englishMark +
                ", russianMark=" + russianMark +
                '}';
    }
}
