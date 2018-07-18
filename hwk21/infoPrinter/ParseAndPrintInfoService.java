package com.gmail.evanloafakahaitao.hwk21.infoPrinter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ParseAndPrintInfoService {
    
    public void DOMParser(File file) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("book");
            System.out.println("Going through the books...");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.printf("Current book: %s\n", element.getAttribute("id"));
                    System.out.printf("Author : %s\n",
                            element.getElementsByTagName("author")
                                    .item(0)
                                    .getTextContent());
                    System.out.printf("Title : %s\n",
                            element
                                    .getElementsByTagName("title")
                                    .item(0)
                                    .getTextContent());
                    System.out.printf("Genre : %s\n",
                            element.getElementsByTagName("genre")
                                    .item(0)
                                    .getTextContent());
                    System.out.printf("Price : %s\n",
                            element.getElementsByTagName("price")
                                    .item(0)
                                    .getTextContent());
                    System.out.printf("Publish date : %s\n",
                            element.getElementsByTagName("publish_date")
                                    .item(0)
                                    .getTextContent());
                    System.out.printf("Description : %s\n",
                            element.getElementsByTagName("description")
                                    .item(0)
                                    .getTextContent()
                                    .replaceAll("\r\n?|\n", " ")
                                    .replaceAll("  *", " "));
                }
            }
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
