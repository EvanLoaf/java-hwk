package com.gmail.evanloafakahaitao.hwk26.sqltask.dao;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.connection.ConnectionSingletonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTablesService {
    public void createTables() {
        String houseTableCommand = "create table if not exists houses(id bigint(19) auto_increment, "
                + "address varchar(50) not null, primary key(id), index(id))";
        String flatTableCommand = "create table if not exists flats(id bigint(19) auto_increment, "
                + "size int not null, count_of_rooms int(2) not null, floor int(2) not null, "
                + "is_populated bool not null, house_id bigint(19) not null, primary key(id), index(id),"
                + "foreign key(house_id) references houses(id) on delete cascade)";
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (
                PreparedStatement preparedHouseStatement = connection.prepareStatement(houseTableCommand);
                PreparedStatement preparedFlatStatement = connection.prepareStatement(flatTableCommand)
        ) {
            preparedHouseStatement.execute();
            preparedFlatStatement.execute();
            System.out.println("Tables created or already exist");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error creating tables");
        }
    }
}
