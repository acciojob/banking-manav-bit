package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//    public void validateLicenseId() throws Exception {
//        // A trade license Id is said to be valid if no two consecutive characters are same
//        // If the license Id is valid, do nothing
//        // If the characters of the license Id can be rearranged to create any valid license Id
//        // If it is not possible, throw "Valid License can not be generated" Exception
//        boolean isvalid=true;
//        for(int i=0;i<tradeLicenseId.length()-1;i++){
//            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
//                isvalid=false;
//            }
//        }
//if(!isvalid){
//    isvalid=true;
//    char []ch=tradeLicenseId.toCharArray();
//    Arrays.sort(ch);
//    String rearrangedtradeLicenseId=new String(ch);
//    for(int i=0;i<rearrangedtradeLicenseId.length()-1;i++){
//        if(rearrangedtradeLicenseId.charAt(i)==rearrangedtradeLicenseId.charAt(i+1)){
//            isvalid=false;
//        }
//    }
//
//}
//        if(!isvalid){
//            throw new Exception("Valid License can not be generated");
//        }
//    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isvalid = true;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                isvalid = false;
                break;
            }
        }

        if (!isvalid) {
            // Try to rearrange characters
            isvalid = true;
            char[] ch = tradeLicenseId.toCharArray();
            Arrays.sort(ch);

            // Generate permutations
            List<String> permutations = new ArrayList<>();
            generatePermutations("", ch, permutations);

            // Check if any permutation is a valid license ID
            for (String permutation : permutations) {
                isvalid = true;
                for (int i = 0; i < permutation.length() - 1; i++) {
                    if (permutation.charAt(i) == permutation.charAt(i + 1)) {
                        isvalid = false;
                        break;
                    }
                }
                if (isvalid) {
                    tradeLicenseId = permutation;
                    break;
                }
            }
        }

        if (!isvalid) {
            throw new Exception("Valid License can not be generated");
        }
    }

    private void generatePermutations(String prefix, char[] chars, List<String> result) {
        if (prefix.length() == chars.length) {
            result.add(prefix);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (prefix.indexOf(chars[i]) < 0) {
                    generatePermutations(prefix + chars[i], chars, result);
                }
            }
        }
    }

}
