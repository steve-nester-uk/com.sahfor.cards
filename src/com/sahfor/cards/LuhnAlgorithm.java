/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sahfor.cards;

/**
 *
 * @author Steve Nester <com.sahfor>
 */
public class LuhnAlgorithm
{
    //http://en.wikipedia.org/wiki/Luhn_algorithm
    public static void main(String[] args) {
        char[] cardNumber = "4111111111111112".toCharArray();
        System.out.println("Valid card number: " + new LuhnAlgorithm().luhnCheck(cardNumber));
    }
    
    public boolean luhnCheck(char[] cardNumber) {
        char checkDigit = cardNumber[cardNumber.length- 1];
        //Step 1 - compute the sun of the digits after adjusting
        int runningTotal = 0;
        for (int i = cardNumber.length - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                String value = String.valueOf( (Integer.parseInt(String.valueOf(cardNumber[i])) * 2) );
                if (value.length() == 2) {
                    int sumOfDigits = Integer.parseInt(value.substring(0,1)) + Integer.parseInt(value.substring(1,2));
                    runningTotal = runningTotal + sumOfDigits ;
                }
                else {
                    runningTotal = runningTotal + (Integer.parseInt(value)) ;
                }
            }
            else {
                runningTotal = runningTotal + Integer.parseInt(String.valueOf(cardNumber[i]));
            }
        }
        //Step 2 - multiply by 9
        runningTotal = runningTotal * 9;
        //Step 3 - last digit of runningTotal is the check digit
        String v = String.valueOf(runningTotal);
        v = v.substring(v.length() - 1);
        return (Integer.parseInt(v) == Integer.parseInt(String.valueOf(checkDigit)));
    }
}
