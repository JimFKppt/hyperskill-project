package cinema;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;

    public Room() {
    }

    public Room(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        available_seats = new ArrayList<>();

        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                if (i <= 4) {
                    available_seats.add(new Seat(i, j, 10));
                } else {
                    available_seats.add(new Seat(i, j, 8));
                }
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}
