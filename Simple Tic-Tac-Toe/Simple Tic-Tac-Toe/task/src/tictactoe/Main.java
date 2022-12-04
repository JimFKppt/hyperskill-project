package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        StringBuilder symbols = new StringBuilder("         ");
        String[][] chessboard = createChessboard(symbols);

        showField(chessboard);

        String[] coordinates = new String[0];
        int numberOfRounds = 1;

        while ("Game not finished".equals(analyzeTheGameState(chessboard))) {
            boolean coordinatesCorrect = false;
            while (!coordinatesCorrect) {
                coordinates = scanner.nextLine().split(" ");
                coordinatesCorrect = checkCoordinates(chessboard, coordinates);
            }
            if (numberOfRounds % 2 != 0) {
                placeChessman(chessboard, "X", Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            } else {
                placeChessman(chessboard, "O", Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            }
            numberOfRounds++;
            showField(chessboard);
        }

        System.out.println(analyzeTheGameState(chessboard));
    }

    public static String analyzeTheGameState(String[][] field) {
        int xs = 0;
        int os = 0;
        boolean xxx = false;
        boolean ooo = false;
        String result = "";

        // check if row or column or any of diagonals is win for someone
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int clm = 0;
            int mDiag = 0;
            int aDiag = 0;

            for (int j = 0; j < 3; j++) {
                if ("X".equals(field[i][j])) {
                    xs += 1;
                } else if ("O".equals(field[i][j])) {
                    os += 1;
                }
                row += field[i][j].charAt(0);
                clm += field[j][i].charAt(0);
                mDiag += field[j][j].charAt(0);
                aDiag += field[j][2 - j].charAt(0);
            }

            // ASCII value for X is 88 (X+X+X is 264)
            // ASCII value for O is 79 (O+O+O is 237)
            xxx = xxx || row == 264 || clm == 264 || mDiag == 264 || aDiag == 264;
            ooo = ooo || row == 237 || clm == 237 || mDiag == 237 || aDiag == 237;

            result = Math.abs(xs - os) > 1 || xxx && ooo ? "Impossible"
                    : xxx ? "X wins"
                    : ooo ? "O wins"
                    : xs + os == 9 ? "Draw"
                    : "Game not finished";
        }

        return result;
    }

    public static String[][] createChessboard(StringBuilder symbols) {
        String[][] field = new String[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String symbol = symbols.substring(0, 1);
                if ("_".equals(symbol)) {
                    field[i][j] = " ";
                } else {
                    field[i][j] = symbol;
                }
                symbols.replace(0, 1, "");
            }
        }
        return field;
    }

    public static void placeChessman(String[][] field, String chessman, int coordinateY, int coordinateX) {
        field[coordinateY - 1][coordinateX - 1] = chessman;
    }

    public static boolean checkCoordinates(String[][] field, String[] coordinates) {
        int coordinateY = 0;
        int coordinateX = 0;
        try {
            coordinateY = Integer.parseInt(coordinates[0]);
            coordinateX = Integer.parseInt(coordinates[1]);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (coordinateY < 1 || coordinateY > 3 || coordinateX < 1 || coordinateX > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if ("X".equals(field[coordinateY - 1][coordinateX - 1]) || "O".equals(field[coordinateY - 1][coordinateX - 1])) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public static void showField(String[][] field) {
        System.out.println("---------");
        for (String[] row : field) {
            System.out.println("| " + row[0] + " " + row[1] + " " + row[2] + " |");
        }
        System.out.println("---------");
    }
}
