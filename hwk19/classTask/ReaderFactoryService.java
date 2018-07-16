package com.gmail.evanloafakahaitao.hwk19.classTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderFactoryService {

    private static volatile ReaderFactoryService instance = null;

    private ReaderFactoryService() {
    }

    public synchronized TextReader getReader(File file) {
        TextReader reader = null;
        String type = null;
        try {
            type = Files.probeContentType(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(type);
        if (type == null) {
            Pattern pattern = Pattern.compile("(?<=\\.)(?:.(?!\\.))+$");
            Matcher matcher = pattern.matcher(file.getName());
            if (matcher.find() && matcher.group().equals("properties")) {
                reader = new PropertiesReader();
            }
        } else if (type.equals("text/plain")) {
            reader = new TxtReader();
        } else if (type.equals("text/xml")) {
            reader = new XmlReader();
        } else throw new IllegalStateException();

        return reader;
    }

    public static synchronized ReaderFactoryService getInstance() {
        if (instance == null) {
            synchronized (ReaderFactoryService.class) {
                if (instance == null) {
                    instance = new ReaderFactoryService();
                }
            }
        }
        return instance;
    }
}
