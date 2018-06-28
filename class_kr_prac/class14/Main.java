package com.gmail.evanloafakahaitao.class_kr_prac.class14;

import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task1.ApplesProblem;
import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task2.SymbolSearchInStringProblem;
import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task3.NumbersCalculationsService;
import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task4.MonthCollectionProblem;
import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task5.StringUniqueSymbolsNumberService;
import com.gmail.evanloafakahaitao.class14.test_kr_tasks.task6.WriteStudentsProblem;

import java.io.File;

/**
 * 1.	Программа получает на вход числа N и K, где N – количество школьников,а K –
 * количество  яблок в корзине. N школьников делят K яблок поровну, неделящийся
 * остаток остается в корзинке. Сколько яблок достанется каждому школьнику?
 * Программа должна вывести искомое количество яблок и остаток яблок в корзине на экран.
 * 2.	Ввести строку с консоли. Ввести символ с консоли. Написать программу которая
 * определяет, как часто встречается символ в строке.
 * 3.	Сгенерировать массив из 10 целых чисел. Написать программу расчета среднего
 * арифметического отрицательных элементов в этом массиве. Заменить минимальный
 * элемент в одномерном массиве на полученное среднее арифметическое.
 * // v kr bydet Find min n max elements, replace min(or max) with max(or min) * / + y etc
 * 4.	Создать класс MonthInfo с полями russianName, englishName, number.
 * Пользователь вводит с клавиатуры номер месяца. Программа выводит  на экран
 * информацию о месяце на экран, например «May(Май) is 5 month». Используйте
 * коллекции и класс MonthInfo.
 * 5.	Ввести строку с консоли. Вывести на экран символы и их количество повторений
 * в этой строке. Использовать Map.
 * 6.	Cоздать файл  из списка 10 студентов с их оценками (номер,  Ф.И.О. и
 * три оценки). Вывести его содержимое на экран, изменить фамилию студента с
 * номером, введенным с клавиатуры, заново прочитать файл.
 */

public class Main {

    public static void main(String[] args) {

        // Task1
        System.out.println("\nTask1.");
        ApplesProblem apples = new ApplesProblem();
        apples.dataInput();
        System.out.println("\n----------\n");

        // Task2
        System.out.println("\nTask2.");
        SymbolSearchInStringProblem symbols = new SymbolSearchInStringProblem();
        symbols.getString();
        System.out.println("\n----------\n");

        // Task3
        System.out.println("\nTask3.");
        NumbersCalculationsService calc = new NumbersCalculationsService();
        calc.calculations(calc.createArray());
        System.out.println("\n----------\n");

        // Task4
        System.out.println("\nTask4.");
        MonthCollectionProblem month = new MonthCollectionProblem();
        month.printMonth(month.createList());
        System.out.println("\n----------\n");

        // Task5
        System.out.println("\nTask5.");
        StringUniqueSymbolsNumberService unique = new StringUniqueSymbolsNumberService();
        unique.printUniqueSymbols(unique.getStr());
        System.out.println("\n----------\n");

        // Task6
        System.out.println("\nTask6.");
        String myPath = "src/com/gmail/evanloafakahaitao/class14/test_kr_tasks/task6/my_students.txt";
        File students = new File(myPath);

        WriteStudentsProblem writeStudent = new WriteStudentsProblem();
        writeStudent.writeStudentsToFile(students.toString());
        writeStudent.readPrintFIle(students.toString());
        writeStudent.changeStudent(students.toString());
        System.out.println("\n----------\n");

    }

}
