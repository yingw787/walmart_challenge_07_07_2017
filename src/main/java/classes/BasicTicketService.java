package classes;

import interfaces.TicketService;
import classes.BasicSeatHold;

public class BasicTicketService implements TicketService {

    public int numSeatsAvailable() {
        return 0;
    }

    public BasicSeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        return new BasicSeatHold();
    }

    public String reserveSeats(int seatHoldId, String customerEmail) {
        return "thing";
    }

}
