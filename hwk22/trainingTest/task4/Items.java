package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "shiporder")
public class Items {
    
    private List<Item> items = new ArrayList<>();
    
    public List<Item> getItems() {
        return items;
    }
    
    @XmlElement(name = "item")
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
