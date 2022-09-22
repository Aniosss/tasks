package ru.vsu.cs.rodionovri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double n = input();
        double x = input();
        double sum_of_members = get_sum_of_members(n, x);
        double sum_of_members_greater_e = get_sum_of_members_greater_e(n, x);
        double sum_of_members_greater_e10 = get_sum_of_members_greater_e10(n, x);
        double value_of_funciton = get_value_of_funciton(x);
        output_result(sum_of_members, sum_of_members_greater_e, sum_of_members_greater_e10, value_of_funciton);
    }

    private static double input() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLong();
    }

    private static double get_member(double n, double x) {
        if (n == 0) return 1;
        else return ((get_member(n - 1, x) * (-1) * x) / n);
    }

    private static double get_sum_of_members(double n, double x) {
        double sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += get_member(i, x);
        }
        return sum;
    }

    private static double get_sum_of_members_greater_e(double n, double x) {
        double sum = 0;
        for (int i = 0; i < n; ++i) {
            double temp = get_member(n, x);
            if (Math.abs(temp) > Math.E) {
                sum += temp;
            }
        }
        return sum;
    }

    private static double get_sum_of_members_greater_e10(double n, double x) {
        double sum = 0;
        for (int i = 0; i < n; ++i) {
            double temp = get_member(n, x);
            if (Math.abs(temp) > (Math.E / 10)) {
                sum += temp;
            }
        }
        return sum;
    }

    private static double get_value_of_funciton(double x) {
        return Math.pow(Math.E, -x);
    }

    private static void output_result(double sum_of_members, double sum_of_members_greater_e,
                                      double sum_of_members_greater_e10, double value_of_funciton) {
        System.out.printf("The sum of all members of the series is %f\n", sum_of_members);
        System.out.printf("The sum of all terms of a series greater than e is %f\n", sum_of_members_greater_e);
        System.out.printf("The sum of all terms of a series greater than e/10 is %f\n", sum_of_members_greater_e10);
        System.out.printf("The value of the function is %f\n", value_of_funciton);
    }
}