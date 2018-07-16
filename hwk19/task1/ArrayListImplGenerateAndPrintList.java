package com.gmail.evanloafakahaitao.hwk19.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class ArrayListImplGenerateAndPrintList implements GenerateAndPrintList {
    
    @Override
    public List<Integer> generateList() {
        InputService input = new InputService();
        List<Integer> list = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            list.add(input.getRandomNumberInRange(0, 20));
        }
        return list;
    }
}
