package cinema;

public class ReturnedTicket {

    private Seat returned_ticket;

    public ReturnedTicket(){
    }

    public ReturnedTicket(int row, int column, int price) {
        this.returned_ticket = new Seat(row, column, price);
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
