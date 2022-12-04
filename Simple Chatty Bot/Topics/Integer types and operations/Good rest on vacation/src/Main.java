import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int duration = scanner.nextInt();
        int foodCostOfDay = scanner.nextInt();
        int oneFlightCost = scanner.nextInt();
        int oneNightInHotelCost = scanner.nextInt();

        int costFood = duration * foodCostOfDay;
        int costFlight = oneFlightCost * 2;
        int costNightInHotel = (duration - 1) * oneNightInHotelCost;

        int total = costFood + costFlight + costNightInHotel;

        System.out.println(total);
    }
}