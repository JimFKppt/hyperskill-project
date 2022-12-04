import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();

        String[] allWords = strings.split(" ");

        int maxLengthOfWord = 0;
        String targetWord = null;
        for (String str : allWords) {
            int length = str.length();
            if (length > maxLengthOfWord) {
                maxLengthOfWord = length;
                targetWord = str;
            }
        }

        System.out.println(targetWord);
    }
}