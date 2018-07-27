package com.gmail.evanloafakahaitao.hwk25.classtask.taskdao;

import java.util.List;

public interface UserDao {

    void createTable();

    void deleteTable(String tableName);

    void addUsers(int numberToAdd, int minSalary, int maxSalary);
    
    void updUserInSalaryRange(int minSalary, int maxSalary, String newCity);

    void updUserWithSalaryFrom(int fromSalary, String newCity);

    void delWithSalaryLower(int lowestSalary);

    List<User> getUsers();
}
