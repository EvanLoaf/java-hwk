package com.gmail.evanloafakahaitao.hwk09.task3.employees;

import com.gmail.evanloafakahaitao.hwk09.task3.BaseSalaryPlusPercentageOfSales;
import com.gmail.evanloafakahaitao.hwk09.task3.EmployeesService;

public class SalesManagerPaymentEmployeesServiceAndBaseSalaryPlusPercentageOfSalesImpl extends EmployeesService implements BaseSalaryPlusPercentageOfSales {
    
    private int departmentSales;
    
    public SalesManagerPaymentEmployeesServiceAndBaseSalaryPlusPercentageOfSalesImpl(String name, String surname, String department, String position, int departmentSales) {
        super(name, surname, department, position);
        this.departmentSales = departmentSales;
    }
    
    @Override
    public double calcPayment(int departmentSales) {
        return this.BASE_SALARY + (((double) this.PERCENTAGE / 100) * departmentSales);
    }
    
    public int getDepartmentSales() {
        return departmentSales;
    }
}
