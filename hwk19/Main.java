package com.gmail.evanloafakahaitao.hwk19;

import com.gmail.evanloafakahaitao.hwk19.classTask.ReaderFactoryService;
import com.gmail.evanloafakahaitao.hwk19.classTask.TextReader;
import com.gmail.evanloafakahaitao.hwk19.classTask.builder.Course;
import com.gmail.evanloafakahaitao.hwk19.task1.ListFactory;
import com.gmail.evanloafakahaitao.hwk19.task1.ListTypeEnum;
import com.gmail.evanloafakahaitao.hwk19.task2.CreatePeopleAndPrintService;

import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        
        // Class task
        System.out.println("Class tasks");
        File file1 = new File("abc.xml");
        File file2 = new File("asd.properties");
        File file3 = new File("qwe.txt");
        ReaderFactoryService readerFactory = ReaderFactoryService.getInstance();
        TextReader reader1 = readerFactory.getReader(file1);
        TextReader reader2 = readerFactory.getReader(file2);
        TextReader reader3 = readerFactory.getReader(file3);
        System.out.println(reader1.read());
        System.out.println(reader2.read());
        System.out.println(reader3.read());
        
        // Class task builder
        System.out.println("\nCourse builder:");
        Course course = new Course.CourseBuilder("Java course", "Artem Perevoznikov")
                .setNumOfListeners(20)
                .setDurationWeeks(30)
                .setNumOfLessons(40)
                .build();
        System.out.printf("Course name: %s, lecturer: %s, listeners: %d, weeks: %d, lessons: %d\n",
                course.getName(),
                course.getLecturer(),
                course.getNumOfListeners(),
                course.getDurationWeeks(),
                course.getNumOfLessons()
        );
        System.out.println("---------------");
    
        // Homework task 1
        System.out.println("\nHomework task1.");
        ListFactory firstFactory = new ListFactory();
        ListFactory secondFactory = new ListFactory();
        firstFactory.getList(ListTypeEnum.LINKED);
        secondFactory.getList(ListTypeEnum.ARRAY);
        firstFactory.printList();
        secondFactory.printList();
        firstFactory.getList(ListTypeEnum.ARRAY);
        firstFactory.printList();
        System.out.println("---------------");
    
        // Homework task 2
        System.out.println("\nHomework task2.");
        CreatePeopleAndPrintService peoplePrint = new CreatePeopleAndPrintService();
        peoplePrint.createAndPrint();
        System.out.println("---------------");
    }
}
