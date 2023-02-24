package by.teachmeskills.lapeiko.homework14.exchange;

import java.math.BigDecimal;
import java.util.Scanner;

public class Homework14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Choose task:
                        1. Exchange rates today
                        2. Currency converter
                        0. Exit"""
        );
        while (true) {
            System.out.print("Task number: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            ExchangeService exchangeService = new ExchangeService();
            switch (taskNumber) {
                case 1 -> {
                    ExchangeRate[] rates = exchangeService.getTodayRates();
                    System.out.println("%-16s %-3s %s".formatted("Валюта", "Код", "Курс"));
                    for (int i = 0; i < rates.length ; i++) {
                        ExchangeRate rate = rates[i];
                        Currency currency = rate.getCurrency();
                        System.out.println("%-16s %-3s %s".formatted(
                                currency.getValueOnRus(),
                                currency,
                                rate.getBynRate()
                        ));
                    }
                }
                case 2 -> {
                    System.out.print("Исходная валюта");
                    Currency ourCurrency = Currency.valueOf(scanner.nextLine());
                    System.out.print("Исходная сумма денег");
                    BigDecimal moneyAmount = new BigDecimal(scanner.nextLine());
                    System.out.print("Целевая валюта");
                    Currency obtainedCurrency = Currency.valueOf(scanner.nextLine());
                    BigDecimal obtainedMoneyAmount = exchangeService.exchange(ourCurrency, moneyAmount, obtainedCurrency);
                    System.out.println("Результат перевода " + obtainedMoneyAmount);
                }
                case 0 -> {
                    return;
                }
                default -> System.err.println("Task doesn't exist");
            }
            System.out.println();
        }
    }
}
