package com.gmail.evanloafakahaitao.hwk19.classTask.builder;

public class Course {

    private String name;
    private String lecturer;
    private int numOfListeners;
    private int durationWeeks;
    private int numOfLessons;
    
    private Course(CourseBuilder builder) {
        this.name = builder.name;
        this.lecturer = builder.lecturer;
        this.numOfListeners = builder.numOfListeners;
        this.durationWeeks = builder.durationWeeks;
        this.numOfLessons = builder.numOfLessons;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLecturer() {
        return lecturer;
    }
    
    public int getNumOfListeners() {
        return numOfListeners;
    }
    
    public int getDurationWeeks() {
        return durationWeeks;
    }
    
    public int getNumOfLessons() {
        return numOfLessons;
    }
    
    public Course(String name, String lecturer, int numOfListeners, int durationWeeks, int numOfLessons) {
        this.name = name;
        this.lecturer = lecturer;
        this.numOfListeners = numOfListeners;
        this.durationWeeks = durationWeeks;
        this.numOfLessons = numOfLessons;
    }
    
    public static class CourseBuilder {
    
        private String name;
        private String lecturer;
        private int numOfListeners;
        private int durationWeeks;
        private int numOfLessons;
        
        public CourseBuilder(String name, String lecturer) {
            this.name = name;
            this.lecturer = lecturer;
        }
        
        public CourseBuilder setNumOfListeners(int numOfListeners) {
            this.numOfListeners = numOfListeners;
            return this;
        }
    
        public CourseBuilder setDurationWeeks(int durationWeeks) {
            this.durationWeeks = durationWeeks;
            return this;
        }
    
        public CourseBuilder setNumOfLessons(int numOfLessons) {
            this.numOfLessons = numOfLessons;
            return this;
        }
        
        public Course build() {
            return new Course(this);
        }
    }
}
