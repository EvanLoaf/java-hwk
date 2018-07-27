package com.gmail.evanloafakahaitao.hwk25.hwktask;

public class Book {
    
    private Long id;
    private String title;
    private Client client;
    
    public Book(String title, Client client) {
        this.title = title;
        this.client = client;
    }
    
    public Book(Long id, String title, Client client) {
        this.id = id;
        this.title = title;
        this.client = client;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Client getClient() {
        return client;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", client=" + client +
                '}';
    }
}
