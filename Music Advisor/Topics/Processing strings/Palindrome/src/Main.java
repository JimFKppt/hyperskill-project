import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        word = word.toLowerCase();
        boolean flag = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "yes" : "no");
    }
}