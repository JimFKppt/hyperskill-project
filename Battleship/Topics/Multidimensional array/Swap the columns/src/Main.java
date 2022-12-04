import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boundOfFirstDimension = scanner.nextInt();
        int boundOfSecondDimension = scanner.nextInt();
        int column1;
        int column2;
        int[][] matrix = new int[boundOfFirstDimension][boundOfSecondDimension];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        column1 = scanner.nextInt();
        column2 = scanner.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][column1];
            matrix[i][column1] = matrix[i][column2];
            matrix[i][column2] = temp;
        }

        for (int[] row : matrix) {
            for (int item : row) {
                System.out.printf("%d ", item);
            }
            System.out.print("\n");
        }
    }
}