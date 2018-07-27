package com.gmail.evanloafakahaitao.hwk25.hwktask;

import com.gmail.evanloafakahaitao.hwk25.hwktask.impl.BookDaoImpl;
import com.gmail.evanloafakahaitao.hwk25.hwktask.impl.ClientDaoImpl;

import java.util.List;

public class LibraryApp {
    
    private LibraryApp() {
    }
    
    private static class Holder {
        private static final LibraryApp instance = new LibraryApp();
    }
    
    public static LibraryApp getInstace() {
        return Holder.instance;
    }
    
    public void runApp() {
        CreateTablesService createTablesService = new CreateTablesService();
        createTablesService.createTables();
        GeneratorService generatorService = GeneratorService.getInstance();
        List<Client> clients = generatorService.generateClients(5);
        List<Book> books = generatorService.generateBooks(clients, 5);
        ClientDao clientDao = new ClientDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        for (Client client : clients) {
            clientDao.save(client);
        }
        for (Book book : books) {
            bookDao.save(book);
        }
        List<Book> booksInDB = bookDao.getBooks();
        for (Book book : booksInDB) {
            System.out.println(book);
        }
    }
}


