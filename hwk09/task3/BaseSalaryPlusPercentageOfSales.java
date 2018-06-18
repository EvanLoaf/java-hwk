package com.gmail.evanloafakahaitao.hwk09.task3;

public interface BaseSalaryPlusPercentageOfSales {
    
    String TYPE = "Base + percentage of sales.";
    int BASE_SALARY = 40;
    int PERCENTAGE = 20;
    
    double calcPayment(int departmentSales);
    
}
