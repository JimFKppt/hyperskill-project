package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        Matrix fogField = new Matrix(true);

        System.out.printf("%s, place your ships on the game field\n", p1.playerName);

        p1.shipField.viewField();

        for (Ship ship : p1.allShips) {
            placeShip(p1.shipField, ship);
        }

        System.out.print("\nPress Enter and pass the move to another player\n...");
        Scanner scanner = new Scanner(System.in);
        String pressEnter = scanner.nextLine();
        System.out.printf("%s, place your ships on the game field\n", p2.playerName);

        p2.shipField.viewField();

        for (Ship ship : p2.allShips) {
            placeShip(p2.shipField, ship);
        }

        boolean gameNotOver = true;
        boolean p1Moment = true;
        while (gameNotOver) {
            System.out.print("\nPress Enter and pass the move to another player\n...");
            pressEnter = scanner.nextLine();
            if (p1Moment) {
                playerScreen(p1, fogField);
                if (attack(p2, p2.allShips)) {
                    gameNotOver = false;
                }
                p1Moment = false;
            } else {
                playerScreen(p2, fogField);
                if (attack(p1, p1.allShips)) {
                    gameNotOver = false;
                }
                p1Moment = true;
            }
        }
    }

    public static boolean attack(Player victim, ArrayList<Ship> allShips) {
        boolean allShipsSank = false;
        ArrayList<Ship> sankShips = new ArrayList<>();
        shot();
        if (hitTheShip(victim.shipField)) {
            if (sankAShip(victim.shipField, allShips, sankShips)) {
                if (!victim.shipField.scanAllFiled()) {
                    System.out.print("\nYou sank the last ship. You won. Congratulations!");
                    allShipsSank = true;
                } else {
                    System.out.print("\nYou sank a ship! Specify a new target.");
                    allShips.remove(sankShips.get(0));
                    sankShips.clear();
                }
            } else {
                System.out.print("\nYou hit a ship!");
            }
        } else {
            System.out.print("\nYou missed!");
        }
        return allShipsSank;
    }

    public static void playerScreen(Player player, Matrix fogField) {
        System.out.print("\n");
        for (String[] strings : fogField.getField()) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.print("\n");
        }
        System.out.print("---------------------\n");
        for (String[] strings : player.shipField.getField()) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.print("\n");
        }
        String turnMessage = String.format("\n%s, it's your turn:\n", player.playerName);
        System.out.println(turnMessage);

    }

    public static void placeShip(Matrix shipField, Ship ship) {
        String promptMessage = String.format("\nEnter the coordinates of the %s (%d cells):\n", ship.name, ship.shipLength);
        String errorMessage = "Error!,Unknown error!";
        int[][] tempCoordsOfShip;
        int[][] coordsOfWholeShip;
        boolean corrected = true;

        System.out.println(promptMessage);

        while (corrected) {
            try {
                tempCoordsOfShip = InputUnit.getCoordsOfCreateShip();
                coordsOfWholeShip = convertCoords(tempCoordsOfShip);
                shipField.checkTouch(tempCoordsOfShip, ship.shipLength);
                ship.setCoordsOfWholeShip(coordsOfWholeShip);
                shipField.placeShip(ship.getCoordsOfWholeShip(), ship.shipLength);
                shipField.viewField();
                corrected = false;
            } catch (RuntimeException e) {
                if ("Wrong length!".equals(e.getMessage())) {
                    errorMessage = String.format("\nError! Wrong length of the %s! Try again:\n", ship.name);
                } else if ("Wrong ship location!".equals(e.getMessage())) {
                    errorMessage = "\nError! Wrong ship location! Try again:\n";
                } else if ("You placed it too close to another one.".equals(e.getMessage())) {
                    errorMessage = "\nError! You placed it too close to another one. Try again:\n";
                } else if ("Out of the range!".equals(e.getMessage())) {
                    errorMessage = "\nError! Out of the range! Try again:\n";
                } else if ("Empty input.".equals(e.getMessage())) {
                    errorMessage = "\nError! Empty input. Try again:\n";
                }
                System.out.println(errorMessage);
            }
        }

    }

    public static void shot() {
        String errorMessage = "\nUnknown error!\n";
        int[] target;
        int y = 0;
        int x = 0;
        boolean corrected = true;

        while (corrected) {
            try {
                target = InputUnit.getCoordsOfShot();
                y = target[0];
                x = target[1];
                corrected = false;
            } catch (RuntimeException e) {
                if ("You entered the wrong coordinates!".equals(e.getMessage())) {
                    errorMessage = "\nError! You entered the wrong coordinates!\n";
                }
                System.out.println(errorMessage);
            }
        }
        InputUnit.yOfShot = y;
        InputUnit.xOfShot = x;
    }

    public static boolean hitTheShip(Matrix victimField) {
        if (victimField.scanTarget("O")) {
            victimField.addBullet("X");
            return true;
        } else {
            victimField.addBullet("M");
            return false;
        }
    }

    public static boolean sankAShip(Matrix shipField, ArrayList<Ship> allShips, ArrayList<Ship> sankShip) {
        for (Ship ship : allShips) {
            if (!ship.statusOfShip(shipField)) {
                sankShip.add(ship);
                return true;
            }
        }
        return false;
    }

    public static int[][] convertCoords(int[][] tempCoordsOfShip) {
        int direction = tempCoordsOfShip[0][0];
        int depth = tempCoordsOfShip[0][1];
        int start = tempCoordsOfShip[1][0];
        int end = tempCoordsOfShip[1][1];
        int[][] coordsOfWholeShip = new int[2][end - start + 1];

        if (direction == 0) {
            int x = start;
            for (int i = 0; i < end - start + 1; i++) {
                coordsOfWholeShip[0][i] = depth;
                coordsOfWholeShip[1][i] = x++;
            }
        } else {
            int y = start;
            for (int i = 0; i < end - start + 1; i++) {
                coordsOfWholeShip[0][i] = y++;
                coordsOfWholeShip[1][i] = depth;
            }
        }

        return coordsOfWholeShip;
    }
}
