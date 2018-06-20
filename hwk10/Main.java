package com.gmail.evanloafakahaitao.hwk10;

import com.gmail.evanloafakahaitao.hwk10.task1.NumberCollectionService;
import com.gmail.evanloafakahaitao.hwk10.task2.StringCollectionService;
import com.gmail.evanloafakahaitao.hwk10.task3.PersonListService;
import com.gmail.evanloafakahaitao.util.InputService;

/**
 * 1. Заполнить коллекцию 10 рандомными целыми числами в промежутке от 2 до 98. Найти два максимальных элемента и вывести их на экран.
 * 2. Заполнить коллекцию 5 строками введенными с консоли. В каждой строке заменить "+" на "+++". Вывести коллекцию-результат на экран.
 * 3. Напишите класс Person, предоставляющий информацию о его имени getName(), фамилии методом getSurname() и возрасте getAge(). Сгенерируйте группу из 20 человек в возрасте от 15 до 30. Если человек совершеннолетний, то вывести на экран информацию в формате "Adult: " + name + surname + age, если нет, то
 * "Infant: " + name + surname + age.
 */

public class Main {
    
    public static void main(String[] args) {
        
        // Task 1
        System.out.println("\nTask1.");
        NumberCollectionService numbers = new NumberCollectionService();
        numbers.buildList();
        System.out.println("--------------------");
        
        
        // Task 2
        System.out.println("\nTask2.");
        StringCollectionService strings = new StringCollectionService();
        strings.buildList();
        System.out.println("--------------------");
        
        // Task 3
        System.out.println("\nTask3.");
        PersonListService people = new PersonListService();
        people.makeGroup();
        System.out.println("--------------------");
        
    }
    
}
