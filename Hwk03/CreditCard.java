package com.gmail.evanloafakahaitao.Hwk03;

public class CreditCard {

    private int accNumber;
    private float currentBalance;

    public CreditCard(int numberOfAccount, float currentAccountBalance) {
        this.accNumber = numberOfAccount;
        this.currentBalance = currentAccountBalance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getCurrentBalance() {
        return currentBalance + " USD";
    }

    // Можно обойтись одним методом в зав-ти от знака sum, но делаю уже так, по пунктам
    protected void addFunds(float sum) {
        this.currentBalance += sum;
    }

    protected void withdraw(float sum) {
        this.currentBalance -= sum;
    }

    protected void cardInfo() {
        System.out.println("Your account number: \n" + accNumber + "\nYour current balance: \n" + currentBalance + " USD");
    }
}
