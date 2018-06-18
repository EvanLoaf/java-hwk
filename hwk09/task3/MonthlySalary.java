package com.gmail.evanloafakahaitao.hwk09.task3;

public interface MonthlySalary {
    
    String TYPE = "Monthly salary.";
    int MONTHLY_SALARY = 100;
    int WORKING_HOURS = 168;
    
    double calcPayment(int leaveHours); // leave days - days of absence
}
