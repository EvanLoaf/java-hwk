package com.gmail.evanloafakahaitao.hwk25.hwktask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTablesService {
    public void createTables() {
        String clientTableCommand = "create table if not exists client(id bigint(19) auto_increment, "
                + "name varchar(50), primary key(id))";
        String bookTableCommand = "create table if not exists book(id bigint(19) auto_increment, title varchar(40), "
                + "client_id bigint(19), primary key(id), foreign key(client_id) references client(id)"
                + " on delete cascade)";
        try (
                Connection connection = ConnectionService.getInstance().getConnection("library");
                PreparedStatement preparedClientStatement = connection.prepareStatement(clientTableCommand);
                PreparedStatement preparedBookStatement = connection.prepareStatement(bookTableCommand)
        ) {
            preparedClientStatement.execute();
            preparedBookStatement.execute();
            System.out.println("Tables created or already exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
