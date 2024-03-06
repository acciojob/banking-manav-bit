package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;

if(balance<5000){
    throw new Exception("Insufficient Balance");
}

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isvalid=true;
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                isvalid=false;
            }
        }
if(!isvalid){
    isvalid=true;
    char []ch=tradeLicenseId.toCharArray();
    Arrays.sort(ch);
    String rearrangedtradeLicenseId=new String(ch);
    for(int i=0;i<rearrangedtradeLicenseId.length()-1;i++){
        if(rearrangedtradeLicenseId.charAt(i)==rearrangedtradeLicenseId.charAt(i+1)){
            isvalid=false;
        }
    }

}
        if(!isvalid){
            throw new Exception("Valid License can not be generated");
        }
    }

}
