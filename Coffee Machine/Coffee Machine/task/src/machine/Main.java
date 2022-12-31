package machine;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        boolean keepRun = true;
        while (keepRun) {
            keepRun = machine.action();
        }
    }
}
