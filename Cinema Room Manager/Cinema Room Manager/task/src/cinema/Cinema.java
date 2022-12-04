package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static int rows;
    public static int seats;
    public static int totalSeats;
    public static int rowNumber;
    public static int seatNumber;
    public static int rowIndex;
    public static int seatIndex;
    public static String[][] matrixOfSeats;
    private static int numOfPurchasedTickets = 0;
    private static int price;
    private static int currentIncome = 0;
    private static int totalIncome;
    private static double percentageOfPurchasedTickets;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");

        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");

        seats = scanner.nextInt();

        totalSeats = rows * seats;

        if (totalSeats <= 60) {
            totalIncome = rows * seats * 10;
        } else if (rowNumber <= rows / 2) {
            totalIncome = (rows / 2) * seats * 10 + (rows / 2 + 1) * seats * 8;
        }

        initializeMatrix();

        LOOP:
        while (true) {

            String option1 = "1. Show the seats";
            String option2 = "2. Buy a ticket";
            String option3 = "3. Statistics";
            String option0 = "0. Exit";

            System.out.printf("\n%s\n%s\n%s\n%s\n", option1, option2, option3, option0);

            // TODO Alter user's input type of selected
            switch (scanner.nextInt()) {
                case 1:
                    printAllSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    break LOOP;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    private static void statistics() {
        System.out.printf("\nNumber of purchased tickets: %d", numOfPurchasedTickets);
        System.out.printf("\nPercentage: %.2f%%", percentageOfPurchasedTickets);
        System.out.printf("\nCurrent income: $%d", currentIncome);
        System.out.printf("\nTotal income: $%d\n", totalIncome);
    }


    public static void initializeMatrix() {
        matrixOfSeats = new String[rows][seats];

        for (String[] row : matrixOfSeats) {
            Arrays.fill(row, "S");
        }
    }


    public static void printAllSeats() {
        System.out.print("\nCinema:\n  ");

        // print the first line (number of seats)
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < matrixOfSeats.length; i++) {
            System.out.println();
            System.out.print(i + 1 + " ");  // print the number of each row

            for (int j = 0; j < matrixOfSeats[i].length; j++) {
                System.out.print(matrixOfSeats[i][j] + " ");
            }
        }

        System.out.print("\n");
    }


    public static void buyTicket() {
        selectSeat();

        while ("B".equals(matrixOfSeats[rowIndex][seatIndex])) {
            System.out.print("\nThat ticket has already been purchased!\n\n");
            selectSeat();
        }

        matrixOfSeats[rowIndex][seatIndex] = "B";

        calculateTicketPrice();

        numOfPurchasedTickets++;
        currentIncome += price;
        percentageOfPurchasedTickets = ((numOfPurchasedTickets / (double) (rows * seats))) * 100d;

        System.out.printf("\nTicket price: $%d\n", price);
    }

    private static void selectSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a row number:\n");

        rowNumber = scanner.nextInt();

        System.out.print("Enter a seat number in that row:\n");

        seatNumber = scanner.nextInt();

        if (rowNumber > rows || seatNumber > seats) {
            System.out.print("\nWrong input!");
            selectSeat();
        } else {
            rowIndex = rowNumber - 1;
            seatIndex = seatNumber - 1;
        }
    }


    private static void calculateTicketPrice() {
        if (totalSeats <= 60) {
            price = 10;
        } else if (rowNumber <= rows / 2) {
            price = 10;
        } else {
            price = 8;
        }
    }
}