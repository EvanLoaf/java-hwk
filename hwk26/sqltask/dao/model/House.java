package com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model;

public class House {
    
    private Long id;
    private String address;
    
    public House(String address) {
        this.address = address;
    }
    
    public House(Long id, String address) {
        this.id = id;
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
