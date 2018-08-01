package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.services;

import com.gmail.evanloafakahaitao.projprep.dao.connection.ConnectionSingletonService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecutorService {

    public void executeSQL(String filepath) {
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            Statement statement = connection.createStatement();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.indexOf(";") == -1) {
                    sb.append(line);
                } else {
                    sb.append(line);
                    statement.execute(sb.toString());
                    sb.setLength(0);
                }
            }
            System.out.println("Executed: " + filepath);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
