import java.io.Serializable;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int numOfParts = scanner.nextInt();
        int shippedOfParts = 0;
        int fixedOfParts = 0;
        int rejectOfParts = 0;
        int numOfError = 0;

        for (int i = 0; i < numOfParts; i++) {
            int sizeOfPart = scanner.nextInt();
            if (sizeOfPart == 0) {
                shippedOfParts += 1;
            } else if (sizeOfPart == 1) {
                fixedOfParts += 1;
            } else if (sizeOfPart == -1) {
                rejectOfParts += 1;
            } else {
                numOfError += 1;
            }
        }
        System.out.println(shippedOfParts + " " + fixedOfParts + " " + rejectOfParts);
    }
}