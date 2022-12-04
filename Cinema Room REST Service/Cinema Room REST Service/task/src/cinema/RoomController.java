package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class RoomController {

    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    Room room = new Room(TOTAL_ROWS, TOTAL_COLUMNS);
    List<Ticket> soldTicketList = new ArrayList<>();
    ReturnedTicket returned;
    Statistic statistics = new Statistic();

    @GetMapping("/seats")
    public Room getRoom() {
        return room;
    }

    @PostMapping("/purchase")
    public Ticket buyTicket(@RequestBody Seat seat) {
        if (seat.getRow() < 1 || seat.getRow() > TOTAL_ROWS || seat.getColumn() < 1 || seat.getColumn() > TOTAL_COLUMNS) {
            throw new SeatException("The number of a row or a column is out of bounds!", HttpStatus.BAD_REQUEST);
        }

        for (int i = 0; i < room.getAvailable_seats().size(); i++) {
            Seat item = room.getAvailable_seats().get(i);
            if (item.getRow() == seat.getRow() && item.getColumn() == seat.getColumn()) {

                int row = item.getRow();
                int column = item.getColumn();
                int price = item.getPrice();

                Ticket ticket = new Ticket(row, column, price);
                soldTicketList.add(ticket);
                room.getAvailable_seats().remove(i);

                statistics.bookKeeping(price, "add");
                statistics.setNumber_of_purchased_tickets(soldTicketList.size());
                statistics.setNumber_of_available_seats(room.getAvailable_seats().size());

                return ticket;
            }
        }

        throw new SeatException("The ticket has been already purchased!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody Ticket onlyToken) {
        for (int i = 0; i < soldTicketList.size(); i++) {
            Ticket ticket = soldTicketList.get(i);
            if (Objects.equals(ticket.getToken(), onlyToken.getToken())) {

                int row = ticket.getTicket().getRow();
                int column = ticket.getTicket().getColumn();
                int price = ticket.getTicket().getPrice();

                soldTicketList.remove(i);
                room.getAvailable_seats().add(new Seat(row, column, price));

                statistics.bookKeeping(price, "subtract");
                statistics.setNumber_of_purchased_tickets(soldTicketList.size());
                statistics.setNumber_of_available_seats(room.getAvailable_seats().size());

                return new ReturnedTicket(row, column, price);
            }
        }

        throw new SeatException("Wrong token!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public Statistic checkStatistic(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return statistics;
        }

        throw new SeatException("The password is wrong!", HttpStatus.UNAUTHORIZED);
    }

}
