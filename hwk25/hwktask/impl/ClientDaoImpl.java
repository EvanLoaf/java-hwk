package com.gmail.evanloafakahaitao.hwk25.hwktask.impl;

import com.gmail.evanloafakahaitao.hwk25.hwktask.Client;
import com.gmail.evanloafakahaitao.hwk25.hwktask.ClientDao;
import com.gmail.evanloafakahaitao.hwk25.hwktask.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl implements ClientDao {
    @Override
    public void save(Client client) {
        String saveClient = "insert ignore into client(id, name) values(?, ?)";
        try (Connection connection = ConnectionService.getInstance().getConnection("library")) {
            PreparedStatement preparedStatement = connection.prepareStatement(saveClient);
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setString(2, client.getName());
            int changes = preparedStatement.executeUpdate();
            System.out.println("Added clients: " + changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Client getById(Long id) {
        String getClientById = "select * from client where id = ?";
        try (Connection connection = ConnectionService.getInstance().getConnection("library")) {
            PreparedStatement preparedStatement = connection.prepareStatement(getClientById);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(
                        id,
                        resultSet.getString("name")
                );
                return client;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cant get client by id");
            return null;
        }
    }
    
    @Override
    public long getMaxId() {
        String getMaxId = "select max(id) from client";
        try (Connection connection = ConnectionService.getInstance().getConnection("library")) {
            PreparedStatement preparedStatement = connection.prepareStatement(getMaxId);
            ResultSet resultSet = preparedStatement.executeQuery();
            long maxId = 0;
            while (resultSet.next()) {
                maxId = resultSet.getLong("max(id)");
            }
            return maxId;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cant get max id");
            return 0;
        }
    }
}
