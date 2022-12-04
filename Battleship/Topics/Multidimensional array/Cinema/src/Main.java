import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // rows
        int m = scanner.nextInt();  // seats

        int[][] matrixOfSeats = new int[n][m]; // matrix

        for (int i = 0; i < matrixOfSeats.length; i++) {
            for (int j = 0; j < matrixOfSeats[i].length; j++) {
                matrixOfSeats[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt(); // target
        int counter;
        int temp1 = 0;
        int targetOfRow = 0;
        boolean stop = false;

        for (int i = 0; i < matrixOfSeats.length; i++) {
            counter = 0;
            for (int j = 0; j < matrixOfSeats[i].length; j++) {
                if (matrixOfSeats[i][j] == 0) {
                    counter++;
                    temp1 = counter;

                    if (temp1 >= k) {
                        targetOfRow = i + 1;
                        stop = true;
                        break;
                    }

                } else {
                    counter = 0;
                }
            }
            if (stop) {
                break;
            }
        }

        System.out.println(targetOfRow);

    }
}