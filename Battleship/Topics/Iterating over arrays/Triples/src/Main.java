import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] ints = new int[sizeOfArray];
        int counter = 0;

        for (int i = 0; i < sizeOfArray; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = 1; i < sizeOfArray - 1; i++) {
            if (ints[i] - 1 == ints[i - 1] && ints[i] + 1 == ints[i + 1]) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}