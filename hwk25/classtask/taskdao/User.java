package com.gmail.evanloafakahaitao.hwk25.classtask.taskdao;

public class User {

    private int id;
    private String firstName;
    private String city;
    private int salary;

    public User(int id, String firstName, String city, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.city = city;
        this.salary = salary;
    }
    
    public User(String firstName, String city, int salary) {
        this.firstName = firstName;
        this.city = city;
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}
