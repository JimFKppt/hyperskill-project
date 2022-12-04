package battleship;

public class Ship {

    public String name;
    int shipLength;

    private int[][] coordsOfWholeShip;  // coordsOfWholeShip[0][...]代表横坐标 [1][...]代表纵坐标

    public Ship() {
    }

    public Ship(String name, int shipLength) {
        this.name = name;
        this.shipLength = shipLength;
    }

    public int[][] getCoordsOfWholeShip() {
        return coordsOfWholeShip;
    }

    public void setCoordsOfWholeShip(int[][] coordsOfWholeShip) {
        this.coordsOfWholeShip = coordsOfWholeShip;
    }

    public boolean statusOfShip(Matrix shipField) {
        return shipField.isTargetBeing(this.coordsOfWholeShip, this.shipLength);
    }
}

