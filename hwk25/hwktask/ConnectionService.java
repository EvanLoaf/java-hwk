package com.gmail.evanloafakahaitao.hwk25.hwktask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    
    private static volatile ConnectionService instance = null;
    
    private ConnectionService() {
    }
    
    public static synchronized ConnectionService getInstance() {
        if (instance == null) {
            synchronized (ConnectionService.class) {
                if (instance == null) {
                    instance = new ConnectionService();
                }
            }
        }
        return instance;
    }
    
    public Connection getConnection(String dbName) {
        System.out.println("Establishing connection...");
        String connectionURL = "jdbc:mysql://localhost:3306/" + dbName + "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "root", "root");
            System.out.println("Returning connection to specific method");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
