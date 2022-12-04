import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int heightOfBus = scanner.nextInt();
        int numOfBridges = scanner.nextInt();
        int[] heightOfBridges = new int[numOfBridges];
        int codeOfBridgeWhichShouldCrash = 0;

        for (int i = 0; i < heightOfBridges.length; i++) {
            heightOfBridges[i] = scanner.nextInt();
        }

        for (int i = 0; i < heightOfBridges.length; i++) {
            if (heightOfBus >= heightOfBridges[i]) {
                codeOfBridgeWhichShouldCrash = i + 1;
                break;
            }
        }

        if (codeOfBridgeWhichShouldCrash == 0) {
            System.out.println("Will not crash");
        } else {
            System.out.println("Will crash on bridge " + codeOfBridgeWhichShouldCrash);
        }
    }
}