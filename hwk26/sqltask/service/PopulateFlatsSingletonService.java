package com.gmail.evanloafakahaitao.hwk26.sqltask.service;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.connection.ConnectionSingletonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateFlatsSingletonService {
    
    private PopulateFlatsSingletonService() {
    }
    
    private static class Holder {
        
        private static final PopulateFlatsSingletonService instance = new PopulateFlatsSingletonService();
    }
    
    public static PopulateFlatsSingletonService getInstance() {
        return Holder.instance;
    }
    
    public void populateFlats(int numberOfRooms, int minSize, int maxSize) {
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        String populateQuery = "update flats set is_populated = true where count_of_rooms = ? and size between ? and ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(populateQuery)) {
            preparedStatement.setInt(1, numberOfRooms);
            preparedStatement.setInt(2, minSize);
            preparedStatement.setInt(3, maxSize);
            int changes = preparedStatement.executeUpdate();
            System.out.printf("Updated rows: %d\n", changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
