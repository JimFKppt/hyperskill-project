import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] ticketCode = scanner.nextLine().split("");

        int first = 0, second = 0;
        for (int i = 0; i < 3; i++) {
            first += Integer.parseInt(ticketCode[i]);
            second += Integer.parseInt(ticketCode[ticketCode.length - 1 - i]);
        }

        System.out.println(first == second ? "Lucky" : "Regular");
    }
}