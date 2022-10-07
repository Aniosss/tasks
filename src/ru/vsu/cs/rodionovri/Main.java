package ru.vsu.cs.rodionovri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test.test();

        int size = readNumber("length of array");
        int[] array = inputArray(size);
        int length = readNumber("count of subsequence's symbols");

        printAnswer(getIndex(array, length));
    }

    private static int readNumber(String text) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.printf("Enter %s - ", text);
            return scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Incorrect number, please repeat input");
        }
        return 0;
    }

    private static int[] inputArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = readNumber(String.format("%s element of array", i));
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static int getIndex(int[] array, int size) {
        if (size < 1 || size > array.length)
            return -1;

        int maxSize = 0;
        int tempSize;
        int index = -1;
        int currSize;

        for (int i = 0; i < array.length - size - 1; i++) {
            tempSize = 0;
            currSize = 0;
            for (int j = i + size; j < array.length; j++) {
                if (array[j] == array[i + tempSize]) {
                    tempSize++;
                } else if (array[j] != array[i + tempSize]) {
                    tempSize = 0;
                }
                if (size == tempSize) {
                    tempSize = 0;
                    currSize++;
                }
            }
            if (currSize > maxSize) {
                maxSize = currSize;
                index = i;
            }
        }

        return index;
    }

    private static void printAnswer(int index) {
        if (index < 0) {
            System.out.println("The data was incorrect");
        } else {
            System.out.printf("Index of the first element of the longest subsequence - %s", index);
        }
    }

}