package com.gmail.evanloafakahaitao.hwk25.hwktask;

public class Client {
    
    private Long id;
    private String name;
    
    public Client(String name) {
        this.name = name;
    }
    
    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
