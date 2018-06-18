package com.gmail.evanloafakahaitao.hwk09.task2;

public class EnglandAutomobileServiceImpl extends AutomobileService {
    
    @Override
    public int getRate() {
        return 7;
    }
    
    public String getDescription() {
        return super.getDescription() + "My country - Englando. Automobile rating: " + this.getRate();
    }
}
