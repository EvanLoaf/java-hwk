package com.gmail.evanloafakahaitao.hwk09.task3;

public interface PercOfSalesPayment {
    
    String TYPE = "Percentage of sales.";
    int PERCENTAGE = 15;
    
    double calcPayment(int sales);
}
