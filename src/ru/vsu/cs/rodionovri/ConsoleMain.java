package ru.vsu.cs.rodionovri;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        String answer = readString();
        runInterface(answer);
    }

    private static String readString() {
        System.out.print("Do you want to run a GUI? The answer is yes/no - ");
        String answer = (new Scanner(System.in)).next();

        if(answer.equals("no") || answer.equals("yes")) {
            return answer;
        }

        System.out.println("You entered the wrong answer. Repeat it");
        return readString();
    }

    private static void runInterface(String answer) throws IOException {
        if(answer.equals("no")) {
            (new ConsoleUI()).run();
        }
        else {
            new GuiWindow();
        }
    }
}