package ru.vsu.cs.kravtsova_n_e.task6;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);
        double x = 0;

        do {
            if (Math.abs(x) > 1){
                System.out.println("Было введено некорректное значение х.");
            }
            System.out.println("Введите значение х (|x| <= 1):");
            x = input.nextDouble();

        } while (Math.abs(x) > 1);

        System.out.println("Введите значение n: ");
        int n = input.nextInt();

        System.out.println("Введите значение e: ");
        double e = input.nextDouble();

        System.out.printf("arcsin(x), сумма %d слагаемых: %.8f%n", n, arcsinus(x, n));
        System.out.printf("arcsin(x), сумма слагаемых, которые по абсолютной величине больше e (%f): %.8f%n", e, arcsinus(x, n, e));
        System.out.printf("arcsin(x), сумма слагаемых, которые по абсолютной величине больше e/10 (%f): %.8f%n", e/10, arcsinus(x, n, e/10));
        System.out.printf("arcsin(x), значение с помощью метода Math: %.8f%n", Math.asin(x));
    }

    public static double arcsinus(double x, int n){
        double arcsin = x;
        double numerator = 1;
        double denominator = 1;

        for (int i = 1; i < n; i++){
            numerator *= (2 * i - 1);
            denominator *= 2 * i;
            arcsin += (numerator/denominator) * (Math.pow(x, (2 * i + 1)) / (2 * i + 1));
        }
        return arcsin;
    }

    public static double arcsinus(double x, int n, double e){
        double arcsin = x;
        double numerator = 1;
        double denominator = 1;
        double result;

        for (int i = 1; i <= n; i++){
            numerator *= (2 * i - 1);
            denominator *= 2 * i;
            result = (numerator/denominator) * (Math.pow(x, (2 * i + 1)) / (2 * i + 1));
            if (Math.abs(result) > e) {
                arcsin += result;
            }
        }
        return arcsin;
    }
}
