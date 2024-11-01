package Second_Task;

import java.util.Scanner;

public class main {
    private static final double USD_RATE = 75.34;   // Курс рубля к доллару
    private static final double EUR_RATE = 90.55;   // Курс рубля к евро
    private static final double GBP_RATE = 105.23;  // Курс рубля к фунту
    private static final double JPY_RATE = 0.65;   // Курс рубля к иене
    private static final double CNY_RATE = 10.52;   // Курс рубля к юаню

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в рублях: ");
        double amountInRubles = scanner.nextDouble();

        convertAndDisplay(amountInRubles);
    }

    public static void convertAndDisplay(double amountInRubles) {
        System.out.println("Конвертация суммы " + amountInRubles + " рублей в другие валюты:");
        System.out.printf("USD: %.2f\n", convert(amountInRubles, USD_RATE));
        System.out.printf("EUR: %.2f\n", convert(amountInRubles, EUR_RATE));
        System.out.printf("GBP: %.2f\n", convert(amountInRubles, GBP_RATE));
        System.out.printf("JPY: %.2f\n", convert(amountInRubles, JPY_RATE));
        System.out.printf("CNY: %.2f\n", convert(amountInRubles, CNY_RATE));
    }

    private static double convert(double amount, double rate) {
        return amount / rate;
    }
}
