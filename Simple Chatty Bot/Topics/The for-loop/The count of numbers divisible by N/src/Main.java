import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        int numberN = scanner.nextInt();
        int count = 0;
        for (; numberA <= numberB; numberA++) {
            if (numberA % numberN == 0) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}