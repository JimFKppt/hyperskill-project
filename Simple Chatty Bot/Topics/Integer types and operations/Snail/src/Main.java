import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int H = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int day = (H - B - 1) / (A - B) + 1;
        System.out.println(day);
    }
}