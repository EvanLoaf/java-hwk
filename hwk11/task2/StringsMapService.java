package com.gmail.evanloafakahaitao.hwk11.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringsMapService {
    
    public void buildAndPrintMap() {
        
        InputService input = new InputService();
        Map<String, String> map = new HashMap<>();
        System.out.println("\nHow many strings do u wanna enter: ");
        int mapSize = input.getNumber();
        input.getString(); // collision with nextInt
        
        for (int i = 0; i < mapSize; i++) {
            System.out.printf("String %d\n", i + 1);
            map.put(input.getString(), null);
        }
        
        System.out.println("\nHere is the map we got: ");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
    
}
