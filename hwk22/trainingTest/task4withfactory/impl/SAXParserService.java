package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.impl;

import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.UserHandler;
import com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserService implements Parser {
    
    @Override
    public void parse(String xmlRoute) {
        try {
            File file = new File(xmlRoute);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new UserHandler();
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
