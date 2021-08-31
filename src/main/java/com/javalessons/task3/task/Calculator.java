package com.javalessons.task3.task;
/*Для успешного выполнения задания Вам нужно будет рассчитать и вывести в несколько колонок
следующие значения: "MONTH, STARING_BALANCE, PAYMENT, INTEREST, PRINCIPAL, ENDING_BALANCE,
TOTAL_INTEREST". Где MONTH – номер платежного месяца (в случае если кредит
оформлен на 10 лет то номера идут от 1 до 120),
STARING_BALANCE – баланс на начало месяца
(т.е сумма задолженности до того как мы внесли очередной платеж,
в самом начале равна объему кредита), PAYMENT – размер платежа за период (месяц),
INTEREST – какую сумму от платежа составляет процент который клиент платит банку в текущем месяце,
PRINCIPAL – сумма которая уходит на погашение тела кредита, ENDING_BALANCE – сумма задолженности,
которая остается на конец месяца, после того как был внесен очередной платеж
(эту же сумму нужно вывести в качестве STARING_BALANCE в следующем цикле),
TOTAL_INTEREST – сколько суммарно денег заплатил банку
заемщик в качестве процентов за пользование кредитом на конец текущего периода. Для вывода в
консоль отформатированного текста Вы можете использовать оператор printf. Пример:

System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
        payment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount);
%15.2f%n - тут %15 отвечает за отступ вправо при выводе переданного аргумента, .
2 отвечает за количество десятичных знаков после запятой в случае использования типа с плавающей точкой,
 f - указывает что мы передаем значение типа с плавающей точкой,
 %n - знак переноса строки. Больше можно почитать тут: easycode*/

public class Calculator {
    private  final int loanAmount;  // loanAmount (объем кредита)
    private static final int MONTHS = 12;
    private  final int years ;     //years (количество лет на которое берется ипотека)
    private  final int interestRate; //interestRate (ежегодный процент под который банк выдает кредит)
    private  final int extraPayment; //extraPayment (дополнительный ежемесячный платеж или же сумма, которую вносит плательщик сверх обязательной, например для ускоренного погашения).

    public Calculator(int loanAmount,int years, int interestRate, int extraPayment) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.extraPayment = extraPayment;
        this.years = years;
    }
}
