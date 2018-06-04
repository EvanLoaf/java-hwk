package com.gmail.evanloafakahaitao.Hwk03;

public class Main {

    public static void main(String[] args) {
        CreditCard priorbank = new CreditCard(123456789, 1500.5f);
        CreditCard barclays = new CreditCard(111222333, 2308.44f);
        CreditCard bankOfChina = new CreditCard(444444444, 1000f);
        priorbank.addFunds(100.1f);
        barclays.addFunds(200);
        bankOfChina.withdraw(999.99f);
        System.out.println("Priorbank:\n");
        priorbank.cardInfo();
        System.out.println("\nBarclays:\n");
        barclays.cardInfo();
        System.out.println("\nBank of China:\n");
        bankOfChina.cardInfo();
        System.out.println("Вот и проверил float, который не используют в банковских системах. Хотя первые 2 результата - нормальные");
    }
}
