package com.gmail.evanloafakahaitao.hwk25.classtask.taskdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private static volatile ConnectionService instance = null;

    private ConnectionService() {}

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

    public Connection getConnection() {
        System.out.println("Establishing connection...");
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user", "root", "root")
        // autoReconnect=true&useSSL=false - could not create connection
        // nothing - WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
        // no timezone things - The server time zone value 'Áåëàðóñü (çèìà)' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
        // timezone works without useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&
        // the UTC time i set is 3 hours behind...
        // select timediff(now(),convert_tz(now(),@@session.time_zone,'+00:00')); says my timeZone is '03:00:00' aka GMT+3
        String connectionURL = "jdbc:mysql://localhost:3306/db_user?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
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
