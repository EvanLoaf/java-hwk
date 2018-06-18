package com.gmail.evanloafakahaitao.hwk09.task3;

public interface HourlyPayment {
    
    String TYPE = "Hourly payment.";
    int HOURLY_RATE = 2;
    
    double calcPayment(int workingHours);
}
