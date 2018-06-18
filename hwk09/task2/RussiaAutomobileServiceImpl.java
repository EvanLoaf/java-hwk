package com.gmail.evanloafakahaitao.hwk09.task2;

public class RussiaAutomobileServiceImpl extends AutomobileService {
    
    @Override
    public int getRate() {
        return 6;
    }
    
    public String getDescription() {
        return super.getDescription() + "My country - Rusland. Automobile rating: " + this.getRate();
    }
}
