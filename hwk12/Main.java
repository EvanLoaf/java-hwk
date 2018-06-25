package com.gmail.evanloafakahaitao.hwk12;

import com.gmail.evanloafakahaitao.hwk12.task1.NPEService;
import com.gmail.evanloafakahaitao.hwk12.task2.ExceptionService;
import com.gmail.evanloafakahaitao.hwk12.task3.MediaBox;
import com.gmail.evanloafakahaitao.hwk12.task3.Volume;

/**
 * 1. Сгенерировать код, который выбрасывает NullPuinterException. Написать обработчик этого исключения и вывести
 * на экран сообщение, которое будет содержать описание данного исключения.
 * 2. Сгенерировать код, который будет выбрасывать в секции try три различных собственных исключения, в зависимости
 * от цифры(от 1 до 3), которую введет пользователь с клавиатуры. Выводит сообщение об ошибке на экран.
 * Сделать программу бесконечной, пока пользователь не введет 0.
 * 3. Создать enum Volume. Определить в нем 3 уровня громкости с соответствующим полем описания.
 * Написать класс MediaBox, который внутри себя будет хранить переменную, в которой будет хранится текущая громкость.
 * Написать метод для увеличения и уменьшения громкости на 1 уровень. Отобразить работу программы на экран.
 */

public class Main {
    
    public static void main(String[] args) {
        
        // Task1
        System.out.println("Task1.");
        NPEService exc = new NPEService();
        exc.npe();
        System.out.println("---------------");
        
        // Task2
        System.out.println("Task2.");
        ExceptionService myExceptions = new ExceptionService();
        myExceptions.exceptionFactory();
        System.out.println("---------------");
        
        // Task3
        System.out.println("Task3.");
        System.out.println("Current volume is set to medium by default in hwk12/Main");
        MediaBox boombox = new MediaBox(Volume.MEDIUM);
        boombox.changeVolume();
        System.out.println("---------------");
        
    }
    
}
