import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int sum = 0;
        for (; num1 <= num2; num1++) {
            sum += num1;
        }
        System.out.println(sum);
    }
}