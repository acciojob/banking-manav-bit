package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
super(name,balance,0);
this.maxWithdrawalLimit=maxWithdrawalLimit;
this.rate=rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
if(amount>getBalance()){
    throw new Exception("Insufficient Balance");

}
if(amount>maxWithdrawalLimit){
    throw new Exception("Maximum Withdraw Limit Exceed");
}
setBalance(getBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double r=rate/100.0;
double si=(getBalance()*r*years);
double amount=si+getBalance();
return amount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double r=rate/100.0;
double amount=getBalance()*Math.pow(1+(r/times),times*years);
return amount;
    }

}
