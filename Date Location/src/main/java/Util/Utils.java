package Util;

public class Utils {
    final private int EMPTY_LINE_COUNT = 50;

    public void clearScreen() {
        for (var i = 0; i < EMPTY_LINE_COUNT; i++)
            System.out.println();
    }
}
