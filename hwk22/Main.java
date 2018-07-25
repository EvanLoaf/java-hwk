package com.gmail.evanloafakahaitao.hwk22;

import com.gmail.evanloafakahaitao.hwk22.trainingTest.task1.SingletonArrayWriterInitService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task2.AppController;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task3.XMLValidator;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4.DOMParserService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4.JAXBParserService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4.SAXParserService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.ParseFactoryService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.Parser;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.Parsers;

public class Main {

    public static void main(String[] args) {

        //task1.
        System.out.println("task1");
        SingletonArrayWriterInitService instance = SingletonArrayWriterInitService.getInstance();
        instance.threadManager(5);
        System.out.println("----------");

        //task2.
        System.out.println("task2");
        AppController myApp = AppController.getInstance()
                .setConsumers(2) // any number of consumers
                .setProducers(10) // any number of consumers
                .setEachProducerToWrite(1); // any number of files to write per producer (file names somewhat unique)
        myApp.app();
        System.out.println("----------");
        
        //task3.
        System.out.println("task3");
        XMLValidator validator = new XMLValidator();
        boolean result = validator.validate("order.xml", "order.xsd");
        System.out.println("Result of XML validation against XSD: " + result);
        System.out.println("----------");
        
        //task4.
        System.out.println("task4");
        System.out.println("_____DOM_____");
        DOMParserService domParser = new DOMParserService();
        domParser.parse("order.xml");
        System.out.println("_____SAX_____");
        SAXParserService saxParser = new SAXParserService();
        saxParser.parse("order.xml");
        System.out.println("_____JAXB_____");
        JAXBParserService jaxbParser = new JAXBParserService();
        jaxbParser.unmarshal("order.xml");
        System.out.println("----------");
        
        //task4 with factory
        System.out.println("\nFactories:\n");
        ParseFactoryService parseFactory = new ParseFactoryService();
        Parser firstParser = parseFactory.getParser(Parsers.DOM);
        firstParser.parse("order.xml");
        Parser secondParser = parseFactory.getParser(Parsers.SAX);
        secondParser.parse("order.xml");
        Parser thirdParser = parseFactory.getParser(Parsers.JAXB);
        thirdParser.parse("order.xml");
        System.out.println("----------");
    }
}
