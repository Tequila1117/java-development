package com.pluralsight.calculator;

import java.util.Scanner;
public class MortgageCalculator {
    double principal;
    double interestRate;
    int loanLength; // in years
    double monthlyPayment;
    double totalInterest;
    double amountRemaining;

    public void calculateMonthlyPayment() {

        double monthlyInterestRate = interestRate / 12;
        int totalNumberOfPayments = loanLength * 12;
        monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
        amountRemaining = principal;

        // Calculate total interest paid
        for (int i = 1; i < totalNumberOfPayments; i++) {
            double interest = amountRemaining * monthlyInterestRate;
            totalInterest += interest;
            amountRemaining = amountRemaining - (monthlyPayment - interest);
            System.out.println(interest);
            System.out.println(amountRemaining);
        }

    }

    public static void main(String[] args) {
        MortgageCalculator calculator = new MortgageCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Desired Mortgage Loan Amount: ");
        calculator.principal = scanner.nextDouble();
        System.out.println("Enter Annual Interest Rate: ");
        calculator.interestRate = scanner.nextDouble() / 100;
        System.out.println("Enter Desired Mortgage Loan Length: ");
        calculator.loanLength = scanner.nextInt();
        calculator.calculateMonthlyPayment();
        System.out.println("Monthly payment: " + calculator.monthlyPayment);
        System.out.println("Total Interest: " + calculator.totalInterest);

    }

}
