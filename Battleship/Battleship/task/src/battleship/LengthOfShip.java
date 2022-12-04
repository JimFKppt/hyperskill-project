package battleship;

public enum LengthOfShip {
    AircraftCarrier(5),
    Battleship(4),
    Submarine(3),
    Cruiser(3),
    Destroyer(2);

    private final int length;

    LengthOfShip(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
