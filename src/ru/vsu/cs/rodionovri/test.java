package ru.vsu.cs.rodionovri;

public class test {
    public static void test() {
        int[] array1 = new int[]{-3, 7, 3, 4, 8, 4, 8, 4, 7, 3, 4, 8, 0, 6, -1, 4, 7, 3, 3};
        int[] array2 = new int[]{4, 6, 7, 13, 5, 4, 7, 13, 5};
        int[] strangeArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        Main.printArray(array1);
        System.out.printf("Substring length -1. Index - %s ", Main.getIndex(array1, -1));
        System.out.println();

        Main.printArray(array1);
        System.out.printf("Substring length 0. Index - %s ", Main.getIndex(array1, 0));
        System.out.println();

        Main.printArray(array1);
        System.out.printf("Substring length %s. Index - %s ", array1.length + 1, Main.getIndex(array1, array1.length + 1));
        System.out.println();

        Main.printArray(array1);
        System.out.printf("Substring length 3. Index - %s ", Main.getIndex(array1, 3));
        System.out.println();

        Main.printArray(array1);
        System.out.printf("Substring length %s. Index - %s ", array1.length, Main.getIndex(array1, array1.length));
        System.out.println();

        Main.printArray(strangeArray);
        System.out.printf("Substring length 1. Index - %s ", Main.getIndex(strangeArray, 1));
        System.out.println();

        Main.printArray(strangeArray);
        System.out.printf("Substring length -1. Index - %s ", Main.getIndex(strangeArray, -1));
        System.out.println();

        Main.printArray(strangeArray);
        System.out.printf("Substring length -. Index - %s ", Main.getIndex(strangeArray, 0));
        System.out.println();

        Main.printArray(array2);
        System.out.printf("Substring length 3. Index - %s ", Main.getIndex(array2, 3));
        System.out.println();

        Main.printArray(array2);
        System.out.printf("Substring length 1. Index - %s ", Main.getIndex(array2, 1));
        System.out.println();

        // Не существует такой последовательности
        Main.printArray(array2);
        System.out.printf("Substring length 4. Index - %s ", Main.getIndex(array2, 4));
        System.out.println();
    }
}
