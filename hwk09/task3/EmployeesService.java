package com.gmail.evanloafakahaitao.hwk09.task3;

public abstract class EmployeesService {
    
    private String name;
    private String surname;
    private String department;
    private String position;
    
    public EmployeesService(String name, String surname, String department, String position) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.position = position;
    }
    
    public String getEmployeeInfo() {
        return "\nName: " + this.name + "\nSurname: " + this.surname + "\nDepartment: " + this.department + "\nPosition: " + this.position;
    }
    
}
