import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int threeDigit = scanner.nextInt();
        int one = threeDigit / 100;
        int two = (threeDigit / 10) % 10;
        int three = (threeDigit % 100) % 10;

        System.out.println(one + two + three);
    }
}