package com.gmail.evanloafakahaitao.hwk24.sqltask;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSQLFileService {
    
    private final InputService input = new InputService();
    
    public void setCommandsAndWrite() {
        System.out.println("Filename?");
        String fileName = input.getString();
        StringBuilder sb = new StringBuilder();
        sb.append("create database Office;");
        sb.append(System.lineSeparator());
        sb.append("use Office;");
        sb.append(System.lineSeparator());
        sb.append("create table employees(id int primary key not null, first_name varchar(30) not null, last_name varchar(25) not null, salary int, title varchar(15), index(id));");
        sb.append(System.lineSeparator());
        sb.append("create table titles(id int primary key not null, title varchar(15));");
        sb.append(System.lineSeparator());
        sb.append("insert into titles values(1, 'junior');");
        sb.append(System.lineSeparator());
        sb.append("insert into titles values(2, 'middle');");
        sb.append(System.lineSeparator());
        sb.append("insert into titles values(3, 'senior');");
        sb.append(System.lineSeparator());
        System.out.println("How many employees to add?");
        int numOfEmployees = input.getNumber();
        for (int i = 0; i < numOfEmployees; i++) {
            sb.append(String.format("insert into employees values(%d, '%s', '%s', %d, %s);", i + 1, "name" + (i + 1), "surname" + (i + 1), input.getRandomNumberInRange(300, 3000), "(select title from titles where id = 1)"));
            sb.append(System.lineSeparator());
        }
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("update employees set title = (select title from titles where id = 2) where salary between 1000 and 1499;");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("update employees set title = (select title from titles where id = 3) where salary >= 1500;");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("delete from employees where salary < 700;");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".sql"))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
