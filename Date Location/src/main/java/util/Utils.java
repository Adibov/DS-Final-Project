package util;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    final private int EMPTY_LINE_COUNT = 50;

    final private Scanner inputScanner;

    public Utils(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void clearScreen() {
        for (var i = 0; i < EMPTY_LINE_COUNT; i++)
            System.out.println();
    }

    public void getInput() {
        System.out.println("Press any key to continue...");
        inputScanner.nextLine();
    }

    public int nextInt() {
        var result = inputScanner.nextInt();
        inputScanner.nextLine();
        return result;
    }

    public int[] nextInt(int intCount) {
        var result = new int[intCount];
        for (var i = 0; i < intCount; i++)
            result[i] = inputScanner.nextInt();
        inputScanner.nextLine();
        return result;
    }

    public String nextLine() {
        return inputScanner.nextLine();
    }
}
