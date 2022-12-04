import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        System.out.println(AClass.getStr());
        AClass aClass = new AClass();
        System.out.println(AClass.getStr());
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] letters = word.toCharArray();
        String isOrder = "true";

        for (int i = 1; i < letters.length; i++) {
            if (((int) letters[i - 1]) + 1 != (int) letters[i]) {
                isOrder = "false";
                break;
            }
        }

        System.out.println(isOrder);
    }
}

class AClass {

    private static String str = "a string";

    static {
        str = "another string";
    }

    public AClass() {
        str = "yet another string";
    }

    public static String getStr() {
        return str;
    }
}