package com.gmail.evanloafakahaitao.util;

import java.util.Random;
import java.util.Scanner;

public class InputService {
    
    private Scanner in = new Scanner(System.in);
    private Random rd = new Random();
    
    public int getNumber() {
        return in.nextInt();
    }
    
    public String getString() {
        return in.nextLine();
    }
    
    public int getRandomNumber() {
        return rd.nextInt();
    }
    
    public int getRandomNumberInRange(int from, int to) {
        return rd.nextInt(to - from + 1) + from;
    }
    
}
