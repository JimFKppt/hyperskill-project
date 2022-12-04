import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int result = 0;

        for (int x = 0; x < 1001; x++) {
            result = a * x * x * x + b * x * x + c * x + d;
            if (result == 0) {
                System.out.println(x);
            }
        }
    }
}