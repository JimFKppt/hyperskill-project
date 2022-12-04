import java.util.Scanner;

class Main {

    public static int n;
    public static int m;
    public static int[][] matrix;
    public static int max;
    public static int row;
    public static int column;


    public static void main(String[] args) {

        readInput();

        max = matrix[0][0];

        // Find the maximum value in matrix, then record the row and column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        System.out.println(row + " " + column);
    }


    public static void readInput() {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        matrix = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}