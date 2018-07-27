package com.gmail.evanloafakahaitao.hwk25;

import com.gmail.evanloafakahaitao.hwk25.classtask.taskdao.User;
import com.gmail.evanloafakahaitao.hwk25.classtask.taskdao.UserDao;
import com.gmail.evanloafakahaitao.hwk25.classtask.taskdao.UserDaoImpl;
import com.gmail.evanloafakahaitao.hwk25.hwktask.LibraryApp;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        // Got jdk1.8 installed so Class.forName is this case is deprecated
        // Got driver shown here right after adding connector library to the project
        listDrivers();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
        
        // Class task
        UserDao userDao = new UserDaoImpl();
        userDao.createTable();
        userDao.deleteTable("users");
        userDao.createTable();
        userDao.addUsers(20, 500, 1500);
        userDao.updUserInSalaryRange(800, 1200, "Vitebsk");
        userDao.updUserWithSalaryFrom(1200, "Vilnus");
        userDao.delWithSalaryLower(800);
        List<User> users = userDao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        ((UserDaoImpl) userDao).testTime();
        
        // Homework task
        LibraryApp libraryApp = LibraryApp.getInstace();
        libraryApp.runApp();
        /**
         * Что делать с клиентами, у которых ID повторяет уже существующий ID в базе? Или, точнее, как правильно
         * избежать данной проблемы и не наговнокодить?
         * Если создавать клиента без ID и класть его в таблицу, где автоматом auto_increment ему даст ID, то потом не
         * получится достать именно ТОГО же клиента, чтобы передать его в Book для поля client_id
         * Поэтому приходится задавать ID на этапе создания клиента, но мы же не знаем, какие ID свободны
         * Либо я не могу придумать, либо конкретное задание не делает это возможным.. тогда нужен какой-то сервис,
         * который постоянно онлайн и следит за всем? Сохраняет ID или что-то другое делает для уникальности
         * создаваемых новых клиентов. Иначе создадим одного клиента с ID=X, в базу пойдет книга с client_id=X,
         * а уже в базе она будет ассоциироваться в другим клиентом, у которого уже был ID=X.
         * Единственный придумавшийся 'костыль' - получать сначала max(id) из table client, но это мне кажется
         * немного кривым и неоптимальным способом. К тому же записи могут удаляться. Чисто теоретически будет таблица
         * с клиентами ID=2^60 и ID=1, max(id) = 2^60, тогда след клиент получит ID=2^60+1.
         */
    }
    
    private static void listDrivers() {
        Enumeration driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("   "+driverClass.getClass().getName());
        }
    }
}
