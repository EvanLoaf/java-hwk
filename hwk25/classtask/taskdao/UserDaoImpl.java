package com.gmail.evanloafakahaitao.hwk25.classtask.taskdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserDaoImpl implements UserDao {
    
    List<String> CITIES = new ArrayList<>(Arrays.asList("Minsk", "Grodno", "Gomel"));
    
    @Override
    public void createTable() {
        String createTableCommand = "create table if not exists users("
                + "id int auto_increment primary key,"
                + "first_name varchar(25) not null,"
                + "city varchar(30) not null,"
                + "salary int not null"
                + ")";
        execute(createTableCommand);
        System.out.println("Table 'users' was created");
    }
    
    @Override
    public void deleteTable(String tableName) {
        String deleteTableCommand = String.format("drop table if exists %s", tableName);
        execute(deleteTableCommand);
        System.out.printf("Table '%s' was deleted\n", tableName);
    }
    
    @Override
    public void addUsers(int numberToAdd, int minSalary, int maxSalary) {
        String insertUser = "insert into users value("
                + "?,"
                + "?,"
                + "?,"
                + "?"
                + ")";
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            if (connection != null) {
                Random rd = new Random();
                for (int i = 0; i < numberToAdd; i++) {
                    PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
                    User user = new User(
                            "RandomName" + (i + 1),
                            CITIES.get(rd.nextInt(CITIES.size())),
                            rd.nextInt(maxSalary - minSalary + 1) + minSalary
                    );
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.setString(2, user.getFirstName());
                    preparedStatement.setString(3, user.getCity());
                    preparedStatement.setInt(4, user.getSalary());
                    int changes = preparedStatement.executeUpdate();
                    System.out.printf("Fields added: %d\n", changes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updUserInSalaryRange(int minSalary, int maxSalary, String newCity) {
        String updateTable = "update users set city = ? where salary between ? and ?";
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTable);
            preparedStatement.setString(1, newCity);
            preparedStatement.setInt(2, minSalary);
            preparedStatement.setInt(3, maxSalary);
            int changes = preparedStatement.executeUpdate();
            System.out.printf("Updated users in salary range %d to %d: %d\n", minSalary, maxSalary, changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updUserWithSalaryFrom(int fromSalary, String newCity) {
        String updateTable = "update users set city = ? where salary > ?";
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTable);
            preparedStatement.setString(1, newCity);
            preparedStatement.setInt(2, fromSalary);
            int changes = preparedStatement.executeUpdate();
            System.out.printf("Updated users with salary from %d: %d\n", fromSalary, changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void delWithSalaryLower(int lowestSalary) {
        String deleteFromTable = "delete from users where salary < ?";
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteFromTable);
            preparedStatement.setInt(1, lowestSalary);
            int changes = preparedStatement.executeUpdate();
            System.out.printf("Deleted users with salary lower than %d: %d\n", lowestSalary, changes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<User> getUsers() {
        List<User> listOfUsers = new ArrayList<>();
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            String sqlQuery = "select * from users";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("city"),
                        resultSet.getInt("salary")
                );
                listOfUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }
    
    public void testTime() {
        try (Connection connection = ConnectionService.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists test(id int auto_increment primary key, time datetime not null)");
            statement.execute("insert into test values(0, now())");
            ResultSet resultSet = statement.executeQuery("SELECT IF(@@session.time_zone = 'SYSTEM', @@system_time_zone, @@session.time_zone)");
            while (resultSet.next()) {
                String timeZone = resultSet.getString(1);
                System.out.println("timezone: " + timeZone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void execute(String sqlCommand) {
        try (Connection conn = ConnectionService.getInstance().getConnection()) {
            if (conn != null) {
                Statement statement = conn.createStatement();
                boolean executionResult = statement.execute(sqlCommand);
                System.out.println("Execution processed");
            }
        } catch (SQLException e) {
            System.out.println("Execution failed");
            e.printStackTrace();
        }
    }
}
