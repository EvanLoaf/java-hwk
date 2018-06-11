package com.gmail.evanloafakahaitao.hwk06;

import java.math.BigInteger;

public class BigIntegerService {

    public void calcBigInteger(BigInteger num1, BigInteger num2) {
        System.out.println((num1.multiply(num1)).add(num2.divide(num1)));
    }

}
