package com.gmail.evanloafakahaitao.hwk21;

import com.gmail.evanloafakahaitao.hwk21.avgPrice.AvgPriceJAXBService;
import com.gmail.evanloafakahaitao.hwk21.infoPrinter.ParseAndPrintInfoService;
import com.gmail.evanloafakahaitao.hwk21.validator.XMLValidator;

import java.io.File;

/**
 * 1. Написать схему для данного файла
 * 2. Вывести на экран информацию о книгах.
 * 3. Посчитать количество элементов book и вычислить среднее арифметическое цены книг.
 */

public class Main {
    
    public static void main(String[] args) {
        
        //Validation of my schema
        System.out.println("Validation.");
        XMLValidator XMLValidator = new XMLValidator();
        boolean valid = XMLValidator.validate("books.xml", "schema.xsd");
        System.out.printf("%s validation = %b.\n", "books.xml", valid);
        System.out.println("----------");
        
        // Retrieving info and printing it
        System.out.println("Printing info.");
        File file = new File("books.xml");
        ParseAndPrintInfoService printer = new ParseAndPrintInfoService();
        printer.DOMParser(file);
        System.out.println("----------");
        
        // Retrieving number of books and their average price
        System.out.println("Books count and their avg price.");
        AvgPriceJAXBService jaxbService = new AvgPriceJAXBService();
        jaxbService.unmarshal();
        System.out.println("----------");
    }
}
