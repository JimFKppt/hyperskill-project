import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number_1 = scanner.nextInt();
        int number_2 = scanner.nextInt();
        int number_3 = scanner.nextInt();
        int number_4 = scanner.nextInt();

        System.out.print(--number_1 + " " + --number_2 + " " + --number_3 + " " + --number_4);
    }
}