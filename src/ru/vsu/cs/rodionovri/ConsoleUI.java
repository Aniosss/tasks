package ru.vsu.cs.rodionovri;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private String inputFile;
    private String outputFile;

    private ConsoleCommand status = ConsoleCommand.Help;

    public void run() throws IOException {
        switch (status) {
            case Help:
                executeHelpCommand();
                parseArgsFromString();
                break;
            case Exit:
                executeExitCommand();
                break;
            case Error:
                executeErrorCommand();
                break;
            case RunMathLogic:
                executeRunMathLogicCommand();
                break;
        }
        run();
    }

    private void parseArgsFromString() {
        System.out.println("Enter the command that is listed in the help:");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        String[] args = line.split(" ");

        if (args.length == 0) {
            status = ConsoleCommand.Error;
            return;
        }

        for (int i = 0; i < args.length; i++) {
            if (args[0].equals("--help")) {
                status = ConsoleCommand.Help;
                return;
            }
            if (args[0].equals("--exit")) {
                status = ConsoleCommand.Exit;
                return;
            }
            if (args[i].startsWith("--input-file=")) {
                inputFile = args[i].replace("--input-file=", "");
            } else if (args[i].startsWith("--output-file=")) {
                outputFile = args[i].replace("--output-file=", "");
            } else {
                status = ConsoleCommand.Error;
                return;
            }
        }
        if (inputFile != null && outputFile != null) {
            status = ConsoleCommand.RunMathLogic;
        }
    }

    private void executeHelpCommand() {

        System.out.println("Справка:");
        System.out.println("--help              Help");
        System.out.println("--exit              Exiting the program");
        System.out.println("--input-file=       Input file name");
        System.out.println("--output-file=      Name of the output file");
    }

    private void executeExitCommand() {
        System.out.println("Exiting the program...");
        System.exit(0);
    }

    private void executeErrorCommand() {
        System.out.println("You entered the wrong argument format, try again.");

        status = ConsoleCommand.Help;
    }

    private void executeRunMathLogicCommand() throws IOException {
        List<String> fileTextLines = FileManager.readAllLinesFromFile(inputFile);
        String[] fileTextArray = ArrayUtils.toPrimitive(fileTextLines);

        int[][] array = ArrayUtils.readArray2FromLines(fileTextArray);
        ArrayUtils.printArray2(array);

        System.out.println("New array:");

        int[][] newArray = MathOperation.getNewDoubleArrayByRule(array);
        ArrayUtils.printArray2(newArray);

        FileManager.createFileWithText(outputFile, ArrayUtils.convertArray2ToString(newArray));

        status = ConsoleCommand.Exit;
    }
}
