package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingletonService {
    
    private Connection connection = null;
    
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/site_user"
                    + "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC", "root", "root");
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldnt establish connection");
        }
    }
    
    private static volatile ConnectionSingletonService instance = null;
    
    private ConnectionSingletonService() {
    }
    
    public static synchronized ConnectionSingletonService getInstance() {
        if (instance == null) {
            synchronized (ConnectionSingletonService.class) {
                if (instance == null) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Sql driver class.forName loading wasnt succesful");
                        e.printStackTrace();
                    }
                    instance = new ConnectionSingletonService();
                }
            }
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error closing connection");
            e.printStackTrace();
        }
    }
}
