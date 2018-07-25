package com.gmail.evanloafakahaitao.hwk22.trainingTest.task4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParserService {
    
    public void unmarshal(String xmlRoute) {
        try {
            File file = new File(xmlRoute);
            JAXBContext jaxbContext =JAXBContext.newInstance(Items.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Items items = (Items) unmarshaller.unmarshal(file);
            for (Item item : items.getItems()) {
                System.out.printf("item: %s\nprice: %f\n", item.getTitle(), item.getPrice());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
