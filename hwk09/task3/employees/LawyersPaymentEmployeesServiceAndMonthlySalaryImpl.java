package com.gmail.evanloafakahaitao.hwk09.task3.employees;

import com.gmail.evanloafakahaitao.hwk09.task3.EmployeesService;
import com.gmail.evanloafakahaitao.hwk09.task3.MonthlySalary;

public class LawyersPaymentEmployeesServiceAndMonthlySalaryImpl extends EmployeesService implements MonthlySalary {
    
    private int leaveHours;
    
    public LawyersPaymentEmployeesServiceAndMonthlySalaryImpl(String name, String surname, String department, String position, int leaveHours) {
        super(name, surname, department, position);
        this.leaveHours = leaveHours;
    }
    
    @Override
    public double calcPayment(int leaveHours) {
        return (((double) this.WORKING_HOURS - leaveHours) / this.WORKING_HOURS) * this.MONTHLY_SALARY;
    }
    
    public int getLeaveHours() {
        return leaveHours;
    }
}
