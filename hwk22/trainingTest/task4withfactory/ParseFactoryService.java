package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory;

import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.impl.DOMParserService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.impl.JAXBParserService;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.impl.SAXParserService;

public class ParseFactoryService {
    
    public Parser getParser(Parsers parserType) {
        Parser parser = null;
        System.out.println(parserType);
        switch (parserType) {
            case DOM:
                parser = new DOMParserService();
                System.out.println("creating" + parserType);
                break;
            case SAX:
                parser = new SAXParserService();
                System.out.println("creating" + parserType);
                break;
            case JAXB:
                parser = new JAXBParserService();
                System.out.println("creating" + parserType);
                break;
            default:
                try {
                    throw new Exception("No such parser type");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return parser;
    }
}
