import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int hoursFirst = scanner.nextInt();
        int minutesFirst = scanner.nextInt();
        int secondsFirst = scanner.nextInt();
        int hoursSecond = scanner.nextInt();
        int minutesSecond = scanner.nextInt();
        int secondsSecond = scanner.nextInt();

        int firstMomentsSeconds = hoursFirst * 3600 + minutesFirst * 60 + secondsFirst;
        int secondMomentsSeconds = hoursSecond * 3600 + minutesSecond * 60 + secondsSecond;

        System.out.println(secondMomentsSeconds-firstMomentsSeconds);
    }
}