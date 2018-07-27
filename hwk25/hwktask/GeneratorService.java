package com.gmail.evanloafakahaitao.hwk25.hwktask;

import com.gmail.evanloafakahaitao.hwk25.hwktask.impl.ClientDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorService {
    
    private static final ClientDao clientDao = new ClientDaoImpl();
    private static final Random rd = new Random();
    private static volatile long clientsGenerated = 0;
    
    private static volatile GeneratorService instance = null;
    
    private GeneratorService() {
    }
    
    public static synchronized GeneratorService getInstance() {
        if (instance == null) {
            synchronized (GeneratorService.class) {
                if (instance == null) {
                    instance = new GeneratorService();
                }
            }
        }
        return instance;
    }
    
    public List<Client> generateClients(long clientsToGenerate) {
        List<Client> generatedClients = new ArrayList<>();
        long maxId = clientDao.getMaxId();
        for (long i = 0; i < clientsToGenerate; i++) {
            Client client = new Client(
                    clientsGenerated + 1 + maxId,
                    "client_name" + rd.nextInt(1000)
            );
            ++clientsGenerated;
            generatedClients.add(client);
        }
        return generatedClients;
    }
    
    public List<Book> generateBooks(List<Client> clients, int booksPerClient) {
        List<Book> generatedBooks = new ArrayList<>();
        for (Client client : clients) {
            for (int i = 0; i < booksPerClient; i++) {
                Book book = generateBook(client);
                generatedBooks.add(book);
            }
        }
        return generatedBooks;
    }
    
    public Book generateBook(Client client) {
        Book book = new Book(
                "super_book_title" + rd.nextInt(1000),
                client
        );
        return book;
    }
}
