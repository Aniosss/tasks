package ru.vsu.cs.rodionovri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int h = input();
        int w = input();
        int cnt = 1;
        int cur_first_space = 0;
        int mem_cnt = 1;
        int cur_count;
        boolean flag = false;
        for (int i = 0; i < h + 2; ++i) {
            if (i == 0 || i == h + 1) {
                System.out.print(' ');
                for (int j = 0; j < w; ++j) {
                    System.out.print('-');
                }
                System.out.print(" \n");
                continue;
            }
            System.out.print('|');
            for (int j = 0; j < cur_first_space % w; ++j) {
                System.out.print(' ');
            }
            cur_count = mem_cnt;
            if (cur_first_space + cnt > w) {
                cur_count = w - (cur_first_space % w);
            }
            for (int j = 0; j < cur_count; ++j) {
                System.out.print('!');
            }
            for (int j = 0; j < w - cur_count - (cur_first_space%w); ++j) {
                System.out.print(' ');
            }
            System.out.print("|\n");
            if (cur_count != cnt){
                if(flag){
                    cur_first_space += cur_count;
                    mem_cnt = ++cnt;
                    flag = false;
                }
                else{
                    mem_cnt = cnt - cur_count;
                    cur_first_space = 0;
                    flag = true;
                }
            }
            else{
                cur_first_space += mem_cnt;
                cnt++;
                mem_cnt = cnt;
            }
        }
    }

    private static int input(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }


}