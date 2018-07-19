package com.gmail.evanloafakahaitao.hwk21.avgPrice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AvgPriceJAXBService {
    
    public void unmarshal() {
        try {
            //File file = new File("onebook.xml");
            File file = new File("mybooks.xml");
            //JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            /*Book book = (Book) unmarshaller.unmarshal(file);
            System.out.println(book);*/
            Books books = (Books) unmarshaller.unmarshal(file);
            float priceSum = 0;
            for (Book book : books.getBooks()) {
                System.out.println(book);
                priceSum += book.getPrice();
            }
            System.out.println("Number of books: " + books.getBooks().size());
            System.out.println("Avg book price: " + priceSum / books.getBooks().size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
