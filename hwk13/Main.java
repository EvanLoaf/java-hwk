package com.gmail.evanloafakahaitao.hwk13;

import com.gmail.evanloafakahaitao.hwk13.classTasks.InfoWriterService;
import com.gmail.evanloafakahaitao.hwk13.classTasks.TextReaderService;
import com.gmail.evanloafakahaitao.hwk13.task1.NumbersFileService;
import com.gmail.evanloafakahaitao.hwk13.task1.ReadNumbersFindMinService;
import com.gmail.evanloafakahaitao.hwk13.task2.WriteFileFromConsoleService;
import com.gmail.evanloafakahaitao.hwk13.task3.RemoveShortWordsService;
import com.gmail.evanloafakahaitao.hwk13.task4.BuildListFromFileService;
import com.gmail.evanloafakahaitao.hwk13.task4.CreateInitialDataFileService;
import com.gmail.evanloafakahaitao.hwk13.task4.Person;
import com.gmail.evanloafakahaitao.hwk13.task4.PrintOldestPersonService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// From class

/**
 * 1. Создать файл, в котором будет строка. Прочитать из файла строку. Вывести на экран количество символов ‘a’
 * 2. Создать объект Person c полями name, surname, age. Сгенерировать 10 объектов класса Person. С помощью
 * Java создать файл, в который запишется информация о этих людях
 */

// Home

/**
 * 1. Создать руками файл с массивом целых чисел. Прочитать из файлы данные, найти минимальный элемент
 * и вывести его на экран.
 * 2. Создать средствами Java файл и записать в него массив из n элементов(ввести все с консоли) целых чисел.
 * 3. Создать руками файл с текстом. Из файла удалить все слова, содержащие от трех до пяти символов.
 * Записать результат в другой файл который находится в другой директории средствами класса File.
 * 4.
 * a. Создать массив годов от 1960 до 1970.
 * b. Создать файл, который имеет структуру:
 * Имя|Фамилия|Год Рождения
 * <Name + i> <Surname + i> <Year>
 * где i - позиция до 7, Year - рандомный год из массива заданного выше, данные в строках разделены пробелами
 * Создать соответствующий класс Person для строк с данными и распарсить файл в коллекцию. Вывести на экран человека с наибольшим годом рождения.
 *
 * Имя|Фамилия|Год Рождения
 * Name1 Surname1 <Year>
 * Name2 Surname2 <Year>
 * Name3 Surname3 <Year>
 * Name4 Surname4 <Year>
 * Name5 Surname5 <Year>
 * Name6 Surname6 <Year>
 * Name7 Surname7 <Year>
 */


public class Main {
    
    public static void main(String[] args) {
        
        String path = "src/com/gmail/evanloafakahaitao/hwk13/";
        
        // Class Task 1
        TextReaderService tx = new TextReaderService();
        String filePath = path + "mytext.txt";
        System.out.println(tx.countSymbols(tx.getText(filePath)));
        
        // Class Task 2
        InfoWriterService iw = new InfoWriterService();
        String personFilePath = path + "personInfo.txt";
        iw.writeListToFile(iw.createListOfPeople(), personFilePath);
        
        
        // Task1.
        // File input stream взял изза .available(), которое в итоге оказалось бесполезно. Ну, зато покопался + работает
        System.out.println("\nTask1.");
        NumbersFileService numFile = new NumbersFileService();
        String numFilePath = path + "numbers_source.txt";
        int length = numFile.writeNumbersFile(numFilePath);
    
        ReadNumbersFindMinService min = new ReadNumbersFindMinService();
        System.out.println("Min number: " + min.getMinNumber(min.read(numFilePath, length)));
        System.out.println("---------------\n");
        
        
        // Task2.
        System.out.println("\nTask2.");
        File myFile = new File(path + "write_from_console.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteFileFromConsoleService writer = new WriteFileFromConsoleService();
        writer.fileWriter(myFile.toString());
        System.out.println("---------------\n");
        
        
        // Task3.
        System.out.println("\nTask3.");
        File textSource = new File("src/com/gmail/evanloafakahaitao/hwk13/text_to_remove_3_to_5_symbol_words.txt");
        RemoveShortWordsService removeWords = new RemoveShortWordsService();
        removeWords.writeNewText(removeWords.correctTheText(removeWords.readText(textSource.toString())));
        System.out.println("---------------\n");
        
        
        // Task4.
        System.out.println("\nTask4.");
        String personTemplatePath = path + "person_template_info.txt";
        
        CreateInitialDataFileService initData = new CreateInitialDataFileService();
        initData.createTemplate(personTemplatePath);
    
        BuildListFromFileService builder = new BuildListFromFileService();
        List<Person> myList = builder.buildList(personTemplatePath);
    
        PrintOldestPersonService print = new PrintOldestPersonService();
        print.printOldestPerson(myList);
        System.out.println("---------------\n");
        
    }
    
}
