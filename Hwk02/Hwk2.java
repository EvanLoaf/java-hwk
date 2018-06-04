package com.gmail.evanloafakahaitao.Hwk02;

public class Hwk2 {

    public static void main(String[] args) {
        byte task1Num1 = 0x6F;
        short task1Num2 = 015;
        long task1Num3 = 10;
        System.out.println("first task: ");
        average(task1Num1, task1Num2, task1Num3);
        System.out.println("Second task: ");
        print();
        short task3Num1 = 100;
        short task3Num2 = 500;
        System.out.println("Third task: ");
        int funcResult = (int) calcExpression(task3Num1, task3Num2);
        System.out.println(funcResult);
        System.out.println("Test: ");
        calcExpressionTEST(task3Num1, task3Num2);
    }

    public static void average(byte num1, short num2, long num3) {
        System.out.println((((float) num1 + num2 + num3) / 3));
    }

    public static void print() {
        System.out.println("I can do it!");
    }

    public static long calcExpression(short num1, short num2) {
        int sum = 0;
        sum += num1 + num2;
        int mult = 1;
        mult *= num1 * num2;
        long result = 0;
        result += sum + mult;
        return result;
    }

    // Dont mind this part, just testing
    public static void calcExpressionTEST(short num1, short num2) {
        int sum = 0;
        sum += num1 += num2;
        System.out.println(sum);
        int mult = 1;
        mult *= num1 *= num2;
        System.out.println(mult);
        long result = 0;
        result += sum += mult;
        System.out.println(result);
    }
}
