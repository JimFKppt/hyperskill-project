import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int quantity = scanner.nextInt();

        if (quantity < 1) {
            System.out.println("no army");
        } else if (quantity <= 19) {
            System.out.println("pack");
        } else if (quantity <= 249) {
            System.out.println("throng");
        } else if (quantity <= 999) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}