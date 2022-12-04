package cinema;

import java.util.UUID;

public class Ticket{

    private UUID token;
    private Seat ticket;

    public Ticket(){
    }

    public Ticket(int row, int column, int price) {
        this.token = UUID.randomUUID();
        this.ticket = new Seat(row, column, price);
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
