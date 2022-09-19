package ru.vsu.cs.rodionovri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(MatrixFibonacci.get_number(input()));
    }

    private static int input(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci: N = ");
        int n = scanner.nextInt();
        return n;
    }
}