package com.javalessons.task3.task;

import java.util.SortedMap;

public class Calculator {

    //оголошення полів класа
    private static final int MONTHS = 12;
    private final int loanAmount;  // loanAmount (объем кредита)
    private final int years;     //years (количество лет на которое берется ипотека)
    private final double interestRate; //interestRate (ежегодный процент под который банк выдает кредит)
    private final int extraPayment; //extraPayment (дополнительный ежемесячный платеж или же сумма, которую вносит плательщик сверх обязательной, например для ускоренного погашения).

    //створення контрруктора для ініціалізації полів
    public Calculator(final int loanAmount, final int years, double interestRate, int extraPayment) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.extraPayment = extraPayment;
        this.years = years;
    }

    //оголошення методу для розрахунку таблиці
    public void tableCalculate() {
        // виведення назв стовбців
        System.out.println("MONTH,  STARING_BALANCE,  PAYMENT,  INTEREST,  PRINCIPAL,  ENDING_BALANCE,  TOTAL_INTEREST");
        //оголошення змінних
        int months = years * MONTHS;
        //period - номер платіжного місяця
        int period = 0;
        double startingBalance = loanAmount;
        double payment = paymentCalculate(startingBalance, interestRate);
        double interest = interestCalculate(startingBalance, interestRate);
        double endingBalance = endingBalanceCalculate(startingBalance, interest);
        double principal = 0;
        double otalInterest = 0;

        while (period < months) {
            period++;

            System.out.printf(period, startingBalance, payment, interest, principal, endingBalance, otalInterest);


            startingBalance = endingBalance;
            otalInterest = otalInterest + interest;
            principal = principal + payment;


        }
    }

    public double paymentCalculate(double startingBalance, double interestRate) {
        return (startingBalance * interestRate) / 1 - Math.pow((1 - interestRate), -MONTHS * years);

        public double interestCalculate ( double startingBalance, double interestRate){
            return startingBalance * interestRate;
        }

        public double endingBalanceCalculate ( double startingBalance, double payment){
            return loanAmount - interest;
        }


    }

}


