package com.gmail.evanloafakahaitao.hwk26.sqltask.dao.impl;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.HouseDao;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.connection.ConnectionSingletonService;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    @Override
    public Long save(House house) {
        String saveHouse = "insert into houses(address) values(?)";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(saveHouse, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, house.getAddress());
            int changes = preparedStatement.executeUpdate();
            System.out.println("House succesfully added");
            ResultSet generatedKeySet = preparedStatement.getGeneratedKeys();
            Long generatedKey;
            while (generatedKeySet.next()) {
                generatedKey = generatedKeySet.getLong(1);
                return generatedKey;
            }
        } catch (SQLException e) {
            System.out.println("Could not add flat");
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    @Override
    public List<House> getHouses() {
        List<House> listOfHouses = new ArrayList<>();
        String getHouses = "select * from houses";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getHouses)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                House house = new House(
                        resultSet.getLong("id"),
                        resultSet.getString("address")
                );
                listOfHouses.add(house);
            }
        } catch (SQLException e) {
            System.out.println("Cant generate houses from SQL");
            e.printStackTrace();
        }
        System.out.println("Returning houses");
        return listOfHouses;
    }
}
