package com.gmail.evanloafakahaitao.hwk21.avgPrice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "catalog", namespace = "https://gmail.com/evanloafakahaitao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {
    
    @XmlElement(name = "book")
    private List<Book> books = null;
    
    public List<Book> getBooks() {
        return this.books;
    }
}
