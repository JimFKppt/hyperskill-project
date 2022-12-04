import java.util.Scanner;

class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                a = twoDimArray[0][0];
                b = twoDimArray[0][twoDimArray[i].length - 1];
                c = twoDimArray[twoDimArray.length - 1][0];
                d = twoDimArray[twoDimArray.length - 1][twoDimArray[i].length - 1];
            }
        }

        System.out.printf("%d %d\n%d %d", a, b, c, d);

    }
}