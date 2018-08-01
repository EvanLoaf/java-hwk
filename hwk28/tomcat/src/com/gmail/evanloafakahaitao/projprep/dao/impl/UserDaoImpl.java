package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.dao.impl;

import com.gmail.evanloafakahaitao.projprep.dao.UserDao;
import com.gmail.evanloafakahaitao.projprep.dao.model.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User save(Connection connection, User user) {
        String saveUser = "insert into users(email, password, first_name, last_name) values(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(saveUser, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            int changes = preparedStatement.executeUpdate();
            System.out.println("User succesfully added: " + changes);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            Long key;
            while (generatedKeys.next()) {
                key = generatedKeys.getLong(1);
                user.setId(key);
            }
            System.out.println(user);
        } catch (SQLException e) {
            System.out.println("Could not add a user");
            e.printStackTrace();
        }
        return user;
    }
}
