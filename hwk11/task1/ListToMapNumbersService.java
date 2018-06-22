package com.gmail.evanloafakahaitao.hwk11.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapNumbersService {
    
    public void generateList() {
        
        InputService input = new InputService();
        System.out.println("\nPlease, specify list capacity: ");
        int listCapacity = input.getNumber();
        List<Integer> numbers = new ArrayList<>(listCapacity);
        
        for (int i = 0; i < listCapacity; i++) {
            numbers.add(input.getRandomNumberInRange(0, 20));
        }
        System.out.println(numbers.size());
        
        uniqueValuesWithMap(numbers);
    }
    
    public void uniqueValuesWithMap(List<Integer> myList) {
        Map<Integer, String> map = new HashMap<>();
        for (Integer integer : myList) {
            map.put(integer, null);
        }
        
        System.out.printf("\nCount of unique numbers in our List: %d\n", map.size());
    }
    
}
