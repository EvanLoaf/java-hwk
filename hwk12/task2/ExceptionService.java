package com.gmail.evanloafakahaitao.hwk12.task2;

import com.gmail.evanloafakahaitao.util.InputService;

public class ExceptionService {
    
    public void exceptionFactory() {
        
        InputService input = new InputService();
        
        try {
            System.out.println("Choose number from 0 to 3: ");
            int number = input.getNumber();
            switch (number) {
                case 0:
                    System.out.println("Great, its over");
                    break;
                case 1:
                    throw new BadException("Nr 1 - Run simulation again");
                case 2:
                    throw new VeryBadException("Nr 2 - Run simulation again");
                case 3:
                    throw new SuperVeryBadException("Nr 3 - Run simulation again");
                default:
                    System.out.println("Use numbers [0; 3]");
                    exceptionFactory();
            }
        } catch (BadException e) {
            System.out.println(e.getMessage());
            exceptionFactory();
        } catch (VeryBadException e) {
            System.out.println(e.getMessage());
            exceptionFactory();
        } catch (SuperVeryBadException e) {
            System.out.println(e.getMessage());
            exceptionFactory();
        }
    }
}
