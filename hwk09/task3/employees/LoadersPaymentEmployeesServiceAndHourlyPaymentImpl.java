package com.gmail.evanloafakahaitao.hwk09.task3.employees;

import com.gmail.evanloafakahaitao.hwk09.task3.EmployeesService;
import com.gmail.evanloafakahaitao.hwk09.task3.HourlyPayment;

public class LoadersPaymentEmployeesServiceAndHourlyPaymentImpl extends EmployeesService implements HourlyPayment {
    
    private int workingHours;
    
    public LoadersPaymentEmployeesServiceAndHourlyPaymentImpl(String name, String surname, String department, String position, int workingHours) {
        super(name, surname, department, position);
        this.workingHours = workingHours;
    }
    
    @Override
    public double calcPayment(int workingHours) {
        return workingHours * this.HOURLY_RATE;
    }
    
    public int getWorkingHours() {
        return workingHours;
    }
}
