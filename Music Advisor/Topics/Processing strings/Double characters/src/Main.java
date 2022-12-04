import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] letters = scanner.nextLine().split("");

        for (String s : letters) {
            System.out.print(s + s);
        }
    }
}