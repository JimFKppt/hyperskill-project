package battleship;

import java.util.Scanner;

public class InputUnit {

    static int yOfShot;
    static int xOfShot;

    private static String[] getInput() {
        String[] strings;
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        String string = inputLine.trim();

        if (string.isEmpty()) {
            throw new RuntimeException("Empty input.");
        } else {
            strings = string.split("\\s");
        }

        return strings;
    }

    public static int[] getCoordsOfShot() {
        String[] input = getInput();
        int y = input[0].charAt(0) - 64;
        int x = Integer.parseInt(input[0].substring(1));

        if (y < 1 || y > 10 || x < 1 || x > 10) {
            throw new RuntimeException("You entered the wrong coordinates!");
        }

        return new int[]{y, x};
    }

    public static int[][] getCoordsOfCreateShip() {
        String[] input = getInput();
        int y1 = input[0].charAt(0) - 64;
        int x1 = Integer.parseInt(input[0].substring(1));
        int y2 = input[1].charAt(0) - 64;
        int x2 = Integer.parseInt(input[1].substring(1));

        if (y1 < 1 || y1 > 10 || y2 < 1 || y2 > 10) {
            throw new RuntimeException("Out of the range!");
        }
        if (x1 < 1 || x1 > 10 || x2 < 1 || x2 > 10) {
            throw new RuntimeException("Out of the range!");
        }

        int start;
        int end;
        int depth;
        int direction;

        if (y1 == y2 && x1 != x2) {
            start = Math.min(x1, x2);
            end = Math.max(x1, x2);
            depth = y1;
            direction = 0;
        } else if (y1 != y2 && x1 == x2) {
            start = Math.min(y1, y2);
            end = Math.max(y1, y2);
            depth = x1;
            direction = 1;
        } else {
            throw new RuntimeException("Wrong ship location!");
        }

        int[][] coords = new int[2][2];
        coords[0][0] = direction;
        coords[0][1] = depth;
        coords[1][0] = start;
        coords[1][1] = end;

        return coords;
    }
}
