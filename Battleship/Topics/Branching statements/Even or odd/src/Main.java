import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        while (true) {
            if (number != 0) {
                if (number % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
            } else {
                break;
            }
            number = scanner.nextInt();
        }
    }
}