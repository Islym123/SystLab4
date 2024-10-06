package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа (a и b):");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("""
                Выберите метод умножения:
                1) Сложение
                2) Математическое выражение
                3) Побитовые операции
                4) Логарифмы
                5) Деление
                6) Рекурсия""");

        int method = scanner.nextInt();
        int product = 0;

        switch (method) {
            case 1:
                product = multiplyByAddition(num1, num2);
                break;
            case 2:
                product = multiplyByFormula(num1, num2);
                break;
            case 3:
                product = multiplyByBitwise(num1, num2);
                break;
            case 4:
                product = multiplyByLogarithms(num1, num2);
                break;
            case 5:
                product = multiplyByDivision(num1, num2);
                break;
            case 6:
                product = multiplyByRecursion(num1, num2);
                break;
            default:
                System.out.println("Неверный выбор метода.");
                return;
        }

        System.out.println("Результат: " + product);
    }

    // Умножение через сложение
    public static int multiplyByAddition(int a, int b) {
        int result = 0;
        int absB = Math.abs(b);
        for (int i = 0; i < absB; i++) {
            result += a;
        }
        return (b < 0) ? -result : result;
    }

    // Математическое выражение
    public static int multiplyByFormula(int a, int b) {
        return (int) ((Math.pow(a + b, 2) - Math.pow(a, 2) - Math.pow(b, 2)) / 2);
    }

    // Побитовые операции
    public static int multiplyByBitwise(int a, int b) {
        int result = 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        while (absB > 0) {
            if ((absB & 1) == 1) {
                result += absA;
            }
            absA <<= 1; // Умножение на 2
            absB >>= 1; // Деление на 2
        }

        return (a < 0 && b > 0) || (a > 0 && b < 0) ? -result : result;
    }

    // Умножение через логарифмы
    public static int multiplyByLogarithms(int a, int b) {
        return (int) Math.pow(2, (Math.log(Math.abs(a)) / Math.log(2)) + (Math.log(Math.abs(b)) / Math.log(2))) * ((a < 0 && b > 0) || (a > 0 && b < 0) ? -1 : 1);
    }

    // Умножение через деление
    public static int multiplyByDivision(int a, int b) {
        return (int) (a / (1.0 / b));
    }

    // Умножение через рекурсию
    public static int multiplyByRecursion(int a, int b) {
        if (b == 0 || a == 0) return 0;
        if (b > 0) return a + multiplyByRecursion(a, b - 1);
        return -multiplyByRecursion(a, -b);
    }
}
