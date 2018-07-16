package com.gmail.evanloafakahaitao.hwk19.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImplGenerateAndPrintList implements GenerateAndPrintList {
    
    @Override
    public List<Integer> generateList() {
        InputService input = new InputService();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(input.getRandomNumberInRange(0, 20));
        }
        return list;
    }
}
