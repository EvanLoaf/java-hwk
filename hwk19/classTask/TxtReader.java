package com.gmail.evanloafakahaitao.hwk19.classTask;

public class TxtReader implements TextReader {
    @Override
    public String read() {
        return String.format("This file is processed by %s", this.getClass().getSimpleName());
    }
}
