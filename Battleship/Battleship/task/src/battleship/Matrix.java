package battleship;

public class Matrix {

    final static int SIZE = 11;
    private String[][] field;

    public Matrix() {
    }

    public Matrix(boolean createMatrix) {
        if (createMatrix) {
            this.crateField();
        }
    }

    public void crateField() {
        field = new String[SIZE][SIZE];
        field[0][0] = " ";
        char horStart = 'A';
        char verStart = '1';
        for (int i = 1; i < SIZE; i++) {
            field[i][0] = String.valueOf(horStart++);

            if (i != 10) {
                field[0][i] = String.valueOf(verStart++);
            } else {
                field[0][i] = String.valueOf(10);
            }

            for (int j = 1; j < SIZE; j++) {
                field[i][j] = "~";
            }
        }
    }

    public void viewField() {
        System.out.print("\n");
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.print("\n");
        }
    }

    public void placeShip(int[][] coordsOfWholeShip, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            field[coordsOfWholeShip[0][i]][coordsOfWholeShip[1][i]] = "O";
        }
    }

    public void checkTouch(int[][] tempCoordsOfShip, int shipLength) {
        int direction = tempCoordsOfShip[0][0];
        int depth = tempCoordsOfShip[0][1];
        int start = tempCoordsOfShip[1][0];
        int end = tempCoordsOfShip[1][1];
        if (end - start + 1 != shipLength) {
            throw new RuntimeException("Wrong length!");
        }

        for (int i = start - 1; i <= end + 1; i++) {
            if (i < 0 || i >= 11) {
                continue;
            }
            for (int j = depth - 1; j <= depth + 1; j++) {
                if (j < 0 || j >= 11) {
                    continue;
                }
                if (direction == 0 && "O".equals(field[j][i])) {
                    throw new RuntimeException("You placed it too close to another one.");
                } else if (direction == 1 && "O".equals(field[i][j])) {
                    throw new RuntimeException("You placed it too close to another one.");
                }
            }
        }
    }

    public boolean scanTarget(String target) {
        return target.equals(field[InputUnit.yOfShot][InputUnit.xOfShot]);
    }

    public void addBullet(String bullet) {
        field[InputUnit.yOfShot][InputUnit.xOfShot] = bullet;
    }

    public boolean isTargetBeing(int[][] coordsOfWholeShip, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            if ("O".equals(field[coordsOfWholeShip[0][i]][coordsOfWholeShip[1][i]])) {
                return true;
            }
        }
        return false;
    }

    public boolean scanAllFiled() {
        for (String[] row : field) {
            for (String cell : row) {
                if ("O".equals(cell)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[][] getField() {
        return field;
    }
}
