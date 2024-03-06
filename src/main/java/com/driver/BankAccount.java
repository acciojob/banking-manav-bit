package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    private double minBalance;
    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
this.balance=balance;
this.name=name;
this.minBalance=minBalance;
    }

    public static String generateAccountNumber(int digits, int sum) throws Exception {
        if (digits < 1 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        int[] numbers = new int[digits];
        for (int i = 0; i < digits - 1; i++) {
            int randomDigit = new Random().nextInt(10);
            numbers[i] = randomDigit;
            sum -= randomDigit;
        }
        numbers[digits - 1] = sum;

        StringBuilder accountNumber = new StringBuilder();
        for (int num : numbers) {
            accountNumber.append(num);
        }
        return accountNumber.toString();
    }
    public void deposit(double amount) {
        //add amount to balance
double b=getBalance();
setBalance(b+amount);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
if(amount>getBalance()){
    throw new Exception("Insufficient Balance");

}

double amountleft=getBalance()-amount;
        if(amountleft<getMinBalance()){
            throw new Exception("Insufficient Balance");
}
else{setBalance(amountleft);
}
    }

}