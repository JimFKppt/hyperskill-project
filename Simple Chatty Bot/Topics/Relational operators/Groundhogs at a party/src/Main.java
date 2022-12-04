import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value
        int num = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        boolean one = !isWeekend && (num >= 10 && num <= 20);
        boolean two = isWeekend && (num >= 15 && num <= 25);
        boolean isSuccessful = one || two;
        System.out.println(isSuccessful);

    }
}