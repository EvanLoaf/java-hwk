package com.gmail.evanloafakahaitao.hwk09.task2;

public class GermanyAutomobileServiceImpl extends AutomobileService {
    
    @Override
    public int getRate() {
        return 8;
    }
    
    public String getDescription() {
        super.getDescription();
        return super.getDescription() + "My country - Deutchland. Automobile rating: " + this.getRate();
    }
}
