import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        int counter = 0;
        double sum = 0.0;

        for (int i = numberA; i <= numberB; i++) {
            if (i % 3 == 0) {
                counter++;
                sum += i;
            }
        }

        System.out.println(sum / counter);
    }
}