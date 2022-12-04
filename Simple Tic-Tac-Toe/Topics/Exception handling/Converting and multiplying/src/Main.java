import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        List<String> results = new ArrayList<>();

        while (!"0".equals(next)) {
            int number = 0;
            try {
                number = Integer.parseInt(next);
                results.add(String.valueOf(number * 10));
            } catch (NumberFormatException e) {
                results.add("Invalid user input: " + next);
            }

            next = scanner.next();
        }

        results.forEach(System.out::println);
    }
}