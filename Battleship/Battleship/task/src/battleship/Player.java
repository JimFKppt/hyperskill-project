package battleship;

import java.util.ArrayList;
import java.util.List;

public class Player {

    String playerName;

    Matrix shipField = new Matrix(true);

    Ship aircraftCarrier = new Ship("Aircraft Carrier", LengthOfShip.AircraftCarrier.getLength());
    Ship battleship = new Ship("Battleship", LengthOfShip.Battleship.getLength());
    Ship submarine = new Ship("Submarine", LengthOfShip.Submarine.getLength());
    Ship cruiser = new Ship("Cruiser", LengthOfShip.Cruiser.getLength());
    Ship destroyer = new Ship("Destroyer", LengthOfShip.Destroyer.getLength());

    ArrayList<Ship> allShips = new ArrayList<>(List.of(
            aircraftCarrier,
            battleship,
            submarine,
            cruiser,
            destroyer
    ));

    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }
}
