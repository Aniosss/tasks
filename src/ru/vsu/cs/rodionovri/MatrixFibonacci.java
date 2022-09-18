package ru.vsu.cs.rodionovri;

import java.util.*;

public class MatrixFibonacci {
    static int[][] Q = new int[][]{{1, 1}, {1, 0}};
    static HashMap<Integer, int[][]> memory = new HashMap<Integer, int[][]>() {
    };

    private static int[][] multiply_matrices(int[][] M1, int[][] M2) {
        int a11 = M1[0][0] * M2[0][0] + M1[0][1] * M2[1][0];
        int a12 = M1[0][0] * M2[0][1] + M1[0][1] * M2[1][1];
        int a21 = M1[1][0] * M2[0][0] + M1[1][1] * M2[1][0];
        int a22 = M1[1][0] * M2[0][1] + M1[1][1] * M2[1][1];
        int[][] r = new int[][]{{a11, a12}, {a21, a22}};
        return r;
    }

    private static int[][] get_matrix_power(int[][] M, int p) {
        if (p == 1) return M;
        Set<Integer> keysOfMemory = memory.keySet();
        if (keysOfMemory.contains(p)) return memory.get(p);
        int[][] k = get_matrix_power(M, p / 2);
        int[][] r = multiply_matrices(k, k);
        return r;
    }

    private static List<Integer> decompToPowersTwo(int number) {
        List<Integer> powers = new ArrayList<Integer>();
        int power = 0;
        while (number != 0) {
            if ((number & 1) != 0) {
                powers.add(1 << power);
            }
            ++power;
            number >>>= 1;
        }
        return powers;
    }

    private static int get_number(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        List<Integer> powersOfNumbers = decompToPowersTwo(number);
        int[][][] matrices = new int[][][]{};
        for (int i = 0; i < powersOfNumbers.size(); ++i){

        }
    }
}
