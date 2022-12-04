import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int n = scanner.nextInt();

        int i = 1;
        int a = 1;
        int c = 0;

        for (int j = 0; j < n; j++) {
            if (c < a) {
                System.out.print(a + " ");
                c++;
            } else {
                c = 1;
                a++;
                System.out.print(a + " ");
            }
        }


    }
}
