package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4;

import javax.xml.bind.annotation.XmlElement;

public class Item {
    
    private String title;
    private String note;
    private String quantity;
    private float price;
    
    public String getTitle() {
        return title;
    }
    
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getNote() {
        return note;
    }
    
    @XmlElement
    public void setNote(String note) {
        this.note = note;
    }
    
    public String getQuantity() {
        return quantity;
    }
    
    @XmlElement
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public float getPrice() {
        return price;
    }
    
    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }
}
