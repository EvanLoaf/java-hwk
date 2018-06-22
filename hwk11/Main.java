package com.gmail.evanloafakahaitao.hwk11;

import com.gmail.evanloafakahaitao.hwk11.task1.ListToMapNumbersService;
import com.gmail.evanloafakahaitao.hwk11.task2.StringsMapService;
import com.gmail.evanloafakahaitao.hwk11.task3.PeopleService;

/**
 * 1. Сгенерируйте List коллекцию целых чисел из 50 элементов от нуля до 20, используя класс Random(). Oпределите
 * количество каждого уникального числа c помощью Map.
 * 2. Создать коллекцию HashMap<String, String>, туда занести 10 различных строк как ключи и любое значение для ключа.
 * Вывести на экран список ключей, каждый элемент с новой строки.
 * 3. Создайте класс Person с полями - имя, фамилия, год рождения. Создать 10 объектов этого типа. Вывести на экран
 * в порядке возрастания года рождения фамилии и имена людей. Подумать о случае, когда нескольно людей будут иметь
 * один и тот же год рождения.
 */

public class Main {
    
    public static void main(String[] args) {
        
        // Task 1
        System.out.println("\nTask1.");
        ListToMapNumbersService myList = new ListToMapNumbersService();
        myList.generateList();
        System.out.println("---------------");
        
        // Task 2
        System.out.println("\nTask2.");
        StringsMapService map = new StringsMapService();
        map.buildAndPrintMap();
        System.out.println("---------------");
        
        // Task 3
        System.out.println("\nTask3.");
        PeopleService people = new PeopleService();
        people.createPeopleSet();
        System.out.println("\n---------------");
        
    }
    
}
