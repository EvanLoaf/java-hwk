package com.gmail.evanloafakahaitao.hwk26.sqltask.dao.impl;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.FlatDao;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.connection.ConnectionSingletonService;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.Flat;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlatDaoImpl implements FlatDao {
    @Override
    public void save(Flat flat) {
        String saveFlat = "insert into flats(size, count_of_rooms, floor, is_populated, house_id) values(?, ?, ?, ?, ?)";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(saveFlat)) {
            preparedStatement.setInt(1, Integer.valueOf(flat.getSize()));
            preparedStatement.setInt(2, flat.getCountOfRooms());
            preparedStatement.setInt(3, flat.getFloor());
            preparedStatement.setBoolean(4, flat.isPopulated());
            preparedStatement.setLong(5, flat.getHouse().getId());
            int changes = preparedStatement.executeUpdate();
            System.out.println("Flat succesfully added");
        } catch (SQLException e) {
            System.out.println("Could not add flat");
            e.printStackTrace();
        }
    }
    
    @Override
    public Flat getById(Long id) {
        String getFlatById = "select f.id, f.size, f.count_of_rooms, f.floor, f.is_populated, f.house_id, h.address "
                + "from flats f join houses h on f.house_id = h.id where f.id = ?";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getFlatById)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Flat flat = Flat.newBuilder()
                        .withId(resultSet.getLong("id"))
                        .withSize(String.valueOf(resultSet.getInt("size")))
                        .withCountOfRooms(resultSet.getInt("count_of_rooms"))
                        .withFloor(resultSet.getInt("floor"))
                        .withIsPopulated(resultSet.getBoolean("is_populated"))
                        .withHouse(resultSet.getLong(
                                "house_id"),
                                resultSet.getString("address"))
                        .build();
                System.out.println("Returning flat by id");
                return flat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not return flat by id");
            return null;
        }
        return null;
    }
    
    public void getAndPrintPopulatedFlats() {
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        String sqlQuery = "select c.mycount, f.id, f.size, f.count_of_rooms, f.floor, f.is_populated, f.house_id, "
                + "h.address from flats f join houses h join (select count(f.id) as mycount from flats f where "
                + "f.is_populated = true) c on f.house_id = h.id where f.is_populated = true";
        Long countOfPopulatedFlats = null;
        List<Flat> listOfFlats = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (countOfPopulatedFlats == null) {
                    countOfPopulatedFlats = resultSet.getLong("mycount");
                }
                Flat flat = Flat.newBuilder()
                        .withId(resultSet.getLong("id"))
                        .withSize(String.valueOf(resultSet.getInt("size")))
                        .withCountOfRooms(resultSet.getInt("count_of_rooms"))
                        .withFloor(resultSet.getInt("floor"))
                        .withIsPopulated(resultSet.getBoolean("is_populated"))
                        .withHouse(
                                new House(
                                        resultSet.getLong("house_id"),
                                        resultSet.getString("address")
                                )
                        )
                        .build();
                listOfFlats.add(flat);
            }
            System.out.printf("Count of populated flats: %d\n", countOfPopulatedFlats);
            System.out.println("These flats are: ");
            for (Flat flat : listOfFlats) {
                System.out.println(flat);
            }
        } catch (SQLException e) {
            System.out.println("Error getting populated flats..");
            e.printStackTrace();
        }
    }
    
    public List<Flat> getFlats() {
        List<Flat> listOfFlats = new ArrayList<>();
        String getFlats = "select f.id, f.size, f.count_of_rooms, f.floor, f.is_populated, f.house_id, h.address "
                + "from flats f join houses h on f.house_id = h.id";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getFlats)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Flat flat = Flat.newBuilder()
                        .withId(resultSet.getLong("id"))
                        .withSize(String.valueOf(resultSet.getInt("size")))
                        .withCountOfRooms(resultSet.getInt("count_of_rooms"))
                        .withFloor(resultSet.getInt("floor"))
                        .withIsPopulated(resultSet.getBoolean("is_populated"))
                        .withHouse(
                                new House(
                                        resultSet.getLong("house_id"),
                                        resultSet.getString("address")
                                )
                        )
                        .build();
                listOfFlats.add(flat);
            }
        } catch (SQLException e) {
            System.out.println("Cant generate flats from SQL");
            e.printStackTrace();
        }
        System.out.println("Returning flats");
        return listOfFlats;
    }
}
