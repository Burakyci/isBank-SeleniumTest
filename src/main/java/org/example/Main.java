package org.example;

import helpers.LoanCalculator;

public class Main {
    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator();
        double result = calculator.loanCalculator(4.2); // örnek değer

        System.out.println(result);
    }

}
