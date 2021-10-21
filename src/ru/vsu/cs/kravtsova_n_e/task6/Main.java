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

        Solution solution = calculate(x, n, e);

        System.out.printf("arcsin(x)%nСумма %d слагаемых: %.010f%n", n, solution.sumN);
        System.out.printf("Сумма %d слагаемых, которые по абсолютной величине больше e (%f): %.010f%n", solution.nE, e, solution.sumE);
        System.out.printf("Сумма %d слагаемых, которые по абсолютной величине больше e/10 (%f): %.010f%n", solution.nE10, e/10, solution.sumE10);
        System.out.printf("Значение, полученное с помощью метода Math.asin(x): %.010f%n", solution.fValue);
    }

    public static Solution calculate(double x, int n, double e){
        Solution solution = new Solution();
        solution.fValue = Math.asin(x);

        double a = x;

        for (int i = 0; i < n || Math.abs(a) > e / 10; i++) {
            if (i < n) {
                solution.sumN += a;
            }
            if (Math.abs(a) > e) {
                solution.sumE += a;
                solution.nE++;
            }
            if (Math.abs(a) > e / 10) {
                solution.sumE10 += a;
                solution.nE10++;
            }
            a = next(a, i + 1, x);
        }
        return solution;
    }

    public static double next(double a, int i, double x){
        a *= x * x * (2 * i - 1) * (2 * i - 1) / ((2 * i) * (2 * i + 1));

        return a;
    }
}
