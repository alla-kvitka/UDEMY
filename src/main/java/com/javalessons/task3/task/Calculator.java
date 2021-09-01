package com.javalessons.task3.task;

public class Calculator {

    //оголошення полів класа
    private static final int MONTHS = 12;
    private final int loanAmount;  // loanAmount (объем кредита)
    private final double years;     //years (количество лет на которое берется ипотека)
    private final double monthlyinterestRate; //interestRate (ежегодный процент под который банк выдает кредит)
    private final int extraMonthlyPayment; //extraPayment (дополнительный ежемесячный платеж или же сумма, которую вносит плательщик сверх обязательной, например для ускоренного погашения).


    //створення контрруктора для ініціалізації полів
    public Calculator(final int loanAmount, final double years, double monthlyInterestRate, int extraMonthlyPayment) {
        this.loanAmount = loanAmount;
        this.monthlyinterestRate = monthlyInterestRate / 12;
        this.extraMonthlyPayment = extraMonthlyPayment;
        this.years = years;
    }

    //оголошення методу для розрахунку таблиці
    public void tableCalculate() {
        //оголошення змінних
        int periodCount = 0;
        double startingBalance = loanAmount;
        double totalInterest = 0;
        double payment = paymentMonCalculate(loanAmount, monthlyinterestRate);

        // виведення назв стовбців
        System.out.println("MONTH,  STARING_BALANCE,  PAYMENT,  INTEREST,  PRINCIPAL,  ENDING_BALANCE,  TOTAL_INTEREST");
        while (periodCount < MONTHS * years) {
            double interestMonRate = interestMonRateCalculate(startingBalance, monthlyinterestRate);
            double principalMon = principalMonCalculate(payment, extraMonthlyPayment, interestMonRate);
            double endingBalance = endingBalanceCalculate(startingBalance, principalMon);

            System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", periodCount, startingBalance,
                    payment + extraMonthlyPayment, interestMonRate, principalMon, endingBalance, interestMonRate);
            if (endingBalance <= payment){

                periodCount++;
            System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n",periodCount,0.0,0.0,0.0,0.0,0.0,0.0);
                break;}
            totalInterest =totalInterest+interestMonRate;
                    startingBalance = endingBalance;
            periodCount++;
        }
    }

    // розрахунок платежа на місяць
    public double paymentMonCalculate(double loanAmount, double interestMonRate) {
        return (loanAmount * interestMonRate) / (1 - Math.pow((1 - interestMonRate), -1 * MONTHS * years));
    }

    /* 4. INTEREST – Размер задолженности на начало периода(месяца) умножить на месячный процент по кредиту.
   Рассчитать в отдельном методе (не смотря на то что там всего одно действие, это нужно для того чтобы лучше усвоить
   работу с методами и понятие области видимости переменных).*/
    public double interestMonRateCalculate(double endingBalance, double interestRate) {
        return endingBalance * (interestRate / 12);
    }

    //5. PRINCIPAL – PAYMENT (платеж за текущий месяц рассчитанный в п.3) + extraMonthlyPayment (если такой имеется) - INTEREST ( вычесть процент
// рассчитанный в п.4)
    public double principalMonCalculate(double payment, double extraMonthlyPayment, double interestMonRate) {
        return payment + extraMonthlyPayment - interestMonRate;
    }

    /*
6. ENDING_BALANCE – сумма задолженности на конец периода = STARING_BALANCE (сумма задолженности на начало периода) - PRINCIPAL.
7. TOTAL_INTEREST – общая сумма которую заплатил заемщик в качестве процентов за все предыдущие месяцы плюс платеж текущего месяца.
*/
    public double endingBalanceCalculate(double startingBalance, double principalMon) {
        return startingBalance - principalMon;
    }
}


