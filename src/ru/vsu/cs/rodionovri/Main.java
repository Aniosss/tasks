package ru.vsu.cs.rodionovri;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> powers = new ArrayList<Integer>();
        int n = 10978; // something > 0
        int power = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                powers.add(1 << power);
                // or, if you just need the exponents:
                // powers.add(power);
            }
            ++power;
            n >>>= 1;
        }

        for(int i : powers){
            System.out.println(i);
        }
    }
}