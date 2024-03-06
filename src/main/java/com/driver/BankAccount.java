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

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Validate inputs
        if (digits <= 0 || sum < 0 || sum >= 9 * digits) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        // Generate account number
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        int currentSum = 0;
        for (int i = 0; i < digits; i++) {
            int randomNumber = random.nextInt(10); // Generate a random digit between 0 and 9
            // Ensure the last digit doesn't make the sum exceed the desired sum
            if (i == digits - 1 && currentSum + randomNumber != sum) {
                randomNumber = sum - currentSum;
            }
            currentSum += randomNumber;
            accountNumber.append(randomNumber);
        }

        // Check if the sum matches the desired sum
        if (currentSum == sum) {
            return accountNumber.toString();
        } else {
            throw new Exception("Account Number can not be generated");
        }
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