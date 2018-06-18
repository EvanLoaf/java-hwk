package com.gmail.evanloafakahaitao.hwk09.task3.employees;

import com.gmail.evanloafakahaitao.hwk09.task3.EmployeesService;
import com.gmail.evanloafakahaitao.hwk09.task3.PercOfSalesPayment;

public class SalesPersonPaymentEmployeesServiceAndPercOfSalesPaymentImpl extends EmployeesService implements PercOfSalesPayment {
    
    private int sales;
    
    public SalesPersonPaymentEmployeesServiceAndPercOfSalesPaymentImpl(String name, String surname, String department, String position, int sales) {
        super(name, surname, department, position);
        this.sales = sales;
    }
    
    @Override
    public double calcPayment(int sales) {
        return ((double) this.PERCENTAGE / 100) * sales;
    }
    
    public int getSales() {
        return sales;
    }
}
