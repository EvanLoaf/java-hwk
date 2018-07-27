package com.gmail.evanloafakahaitao.hwk25.hwktask;

import java.util.List;

public interface BookDao {
    
    void save(Book book);
    
    List<Book> getBooks();
}
