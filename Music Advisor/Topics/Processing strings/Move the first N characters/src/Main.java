import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();

        if (n != 0 && n <= s.length()) {
            String substringFirst = s.substring(0, n);
            String substringSecond = s.substring(n);
            s = substringSecond + substringFirst;
        }

        System.out.println(s);
    }
}