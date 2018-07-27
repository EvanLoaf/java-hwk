package com.gmail.evanloafakahaitao.hwk25.hwktask.impl;

import com.gmail.evanloafakahaitao.hwk25.hwktask.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void save(Book book) {
        String saveClient = "insert into book(title, client_id) values(?, ?)";
        try (Connection connection = ConnectionService.getInstance().getConnection("library")) {
            PreparedStatement preparedStatement = connection.prepareStatement(saveClient);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setLong(2, book.getClient().getId());
            int changes = preparedStatement.executeUpdate();
            System.out.println("Added books: " + changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Book> getBooks() {
        ClientDao clientDao = new ClientDaoImpl();
        List<Book> listOfBooks = new ArrayList<>();
        String getBooks = "select * from book";
        try (Connection connection = ConnectionService.getInstance().getConnection("library")) {
            PreparedStatement preparedStatement = connection.prepareStatement(getBooks);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = clientDao.getById(resultSet.getLong("client_id"));
                Book book = new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        client
                );
                listOfBooks.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Cant get books");
            e.printStackTrace();
        }
        return listOfBooks;
    }
}
