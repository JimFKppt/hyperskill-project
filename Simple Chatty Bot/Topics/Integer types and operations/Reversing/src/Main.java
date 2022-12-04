import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        int hundred = number / 100;
        int decimal = (number / 10) % 10;
        int digit = (number % 10) % 10;

        int output = digit * 100 + decimal * 10 + hundred;
        System.out.println(output);
    }
}
