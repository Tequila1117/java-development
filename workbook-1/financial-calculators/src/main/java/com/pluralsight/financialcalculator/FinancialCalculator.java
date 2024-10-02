package com.pluralsight.financialcalculator;

import java.util.Scanner;

public class FinancialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu options
        System.out.println("Welcome to the Financial Calculator!");
        System.out.println("Choose a calculation:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. CD Calculator");
        System.out.println("3. Annuity Calculator");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateMortgage(scanner);
                break;
            case 2:
                calculateCd(scanner);
                break;
            case 3:
                calculateAnnuity(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }

        scanner.close(); // Close the scanner
    }

    // Mortgage Calculator
    private static void calculateMortgage(Scanner scanner) {
        System.out.print("Enter the principal (loan amount): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100; // Convert to decimal

        System.out.print("Enter the loan length (in years): ");
        int loanLength = scanner.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, loanLength);
        double totalInterest = calculateTotalInterest(monthlyPayment, loanLength, principal);

        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);
    }

    // Method to calculate monthly payment
    private static double calculateMonthlyPayment(double principal, double annualInterestRate, int loanLength) {
        double monthlyInterestRate = annualInterestRate / 12; // Convert annual rate to monthly
        int totalPayments = loanLength * 12; // Total number of payments

        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)) /
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
    }

    // Method to calculate total interest paid
    private static double calculateTotalInterest(double monthlyPayment, int loanLength, double principal) {
        int totalPayments = loanLength * 12; // Total number of payments
        return (monthlyPayment * totalPayments) - principal; // Total paid minus principal
    }

    // Cd Calculator
    private static void calculateCd(Scanner scanner) {
        System.out.print("Enter the initial deposit amount: ");
        double deposit = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100; // Convert to decimal

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(deposit, annualInterestRate, years);
        double totalInterest = futureValue - deposit; // Total interest earned

        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);
    }

    // Method to calculate future value
    private static double calculateFutureValue(double deposit, double annualInterestRate, int years) {
        return deposit * Math.pow(1 + annualInterestRate, years); // Cd interest formula
    }

    // Annuity Calculator
    private static void calculateAnnuity(Scanner scanner) {
        System.out.print("Enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.print("Enter the expected annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100; // Convert to decimal

        System.out.print("Enter the number of years to pay out: ");
        int years = scanner.nextInt();

        double presentValue = calculatePresentValue(monthlyPayout, annualInterestRate, years);

        System.out.printf("The present value of the annuity is: $%.2f%n", presentValue);
    }

    // Method to calculate present value of an ordinary annuity
    private static double calculatePresentValue(double monthlyPayout, double annualInterestRate, int years) {
        double monthlyInterestRate = annualInterestRate / 12; // Convert annual rate to monthly
        int totalPayments = years * 12; // Total number of payments

        return monthlyPayout * ((1 - Math.pow(1 + monthlyInterestRate, -totalPayments)) / monthlyInterestRate);
    }
}

