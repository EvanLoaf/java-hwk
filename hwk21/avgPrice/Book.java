package com.gmail.evanloafakahaitao.hwk21.avgPrice;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "book", namespace = "https://gmail.com/evanloafakahaitao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    
    private String id;
    private String author;
    private String title;
    private String genre;
    private float price;
    private Date date;
    private String description;
    
    public String getId() {
        return id;
    }
    
    //@XmlAttribute(name = "id")
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAuthor() {
        return author;
    }
    
    //@XmlElement(name = "author")
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    //@XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    //@XmlElement(name = "genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public float getPrice() {
        return price;
    }
    
    //@XmlElement(name = "price")
    public void setPrice(float price) {
        this.price = price;
    }
    
    public Date getDate() {
        return date;
    }
    
    //@XmlElement(name = "date")
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }
    
    //@XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
