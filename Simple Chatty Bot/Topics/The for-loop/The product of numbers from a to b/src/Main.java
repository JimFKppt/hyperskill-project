import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int product = 1;
        for (; a < b; a++) {
            product *= a;
        }
        System.out.println(product);
    }
}