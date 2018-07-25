package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4withfactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
    
    private boolean bTitle = false;
    private boolean bPrice = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) {
        if (bTitle) {
            System.out.println("Item title: " + new String(ch, start, length));
            bTitle = false;
        } else if (bPrice) {
            System.out.println("Price: " + new String(ch, start, length));
            bPrice = false;
        }
    }
}
