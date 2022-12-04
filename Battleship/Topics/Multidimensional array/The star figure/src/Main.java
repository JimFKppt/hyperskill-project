import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];

        for (String[] strings : matrix) {
            Arrays.fill(strings, ".");
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = "*";
            matrix[i][n - 1 - i] = "*";
            matrix[n / 2][i] = "*";
            matrix[i][n / 2] = "*";
        }

        for (String[] strings : matrix) {
            for (String s : strings) {
                System.out.print(s + " ");
            }
            System.out.print("\n");
        }
    }
}