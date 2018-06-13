package com.gmail.evanloafakahaitao.hwk06;

import java.util.Random;

public class TestRandomCrackService {

    private static final long multiplier = 0x5DEECE66DL; // 25214903917
    private static final long addend = 0xBL; // 11
    private static final long mask = (1L << 48) - 1; // 281474976710655 = 2^48 – 1

    public void crack() {
        Random random = new Random();
        long num1 = random.nextInt();
        long num2 = random.nextInt();
        long num3 = random.nextInt();
        long num4 = random.nextInt();
        System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nNumber3 = " + num3 + "\nNumber4 = " + num4);

        for (int i = 0; i < 65536; ++i) { // 65536 = 2^16
            long seed1 = ((num1) << 16) + i;
            int calcNum2 = (int) (((seed1 * multiplier + addend) & mask) >>> 16);
            if (calcNum2 == num2) {
                long seed2 = (seed1 * multiplier + addend) & mask;
                long seed3 = (seed2 * multiplier + addend) & mask;
                int calcNum3 = (int) (((seed2 * multiplier + addend) & mask) >>> 16);
                int calcNum4 = (int) (((seed3 * multiplier + addend) & mask) >>> 16);
                System.out.println("Initial seed: " + seed1);
                System.out.println("These shouldve been numbers 3 and 4: " + calcNum3 + ", " + calcNum4);
                break;
            }
        }
    }

    public void crackLoop() {
        Random random = new Random();
        long num1 = random.nextInt();
        long num2 = random.nextInt();
        long num3 = random.nextInt();
        long num4 = random.nextInt();
        long num5 = random.nextInt();
        long num6 = random.nextInt();
        long num7 = random.nextInt();
        long num8 = random.nextInt();
        System.out.println(num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6 + ", " + num7 + ", " + num8);
        //System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nNumber3 = " + num3 + "\nNumber4 = " + num4);

        for (int i = 0; i < 65536; ++i) { // 65536 = 2^16
            long seed1 = ((num1) << 16) + i;
            int calcNum2 = (int) (((seed1 * multiplier + addend) & mask) >>> 16);
            if (calcNum2 == num2) {
                int k = 8; // Nr of random el-t we wanna calculate
                long seed = seed1;
                for (int j = 0; j < k - 2; ++j) {
                    seed = (seed * multiplier + addend) & mask;
                }
                int calcNum = (int) (((seed * multiplier + addend) & mask) >>> 16); // El-t Nr k
                System.out.println("Initial seed: " + seed1);
                System.out.println("Calculated element number " + k + " is: " + calcNum);
                System.out.println("This is what we randomed before: " + num8);
                break;
            }
        }
    }

}
