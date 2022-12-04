import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String strOfInput = scanner.next();

        boolean result = strOfInput.toUpperCase().startsWith("J");
        System.out.println(result);
    }
}