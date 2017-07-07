package classes;

import classes.BasicSeat;
import interfaces.SeatHold;

/**
* BasicSeatHold is a basic implementation of the SeatHold interface.
* Instance variables:
*   - id: the ID of BasicSeatHold instance.
*   -
*   -
* @author Ying Wang
*/
public class BasicSeatHold implements SeatHold {

    private int id;

    public BasicSeatHold(BasicSeat[] reservedSeats) {
        // Generate ID from IDs of BasicSeats within reservedSeats.
        // That way, IDs will likely never collide.
    }

    public int getId() {
        return this.id;
    }

    public String getReservationCode() {
        return "thing";
    }

}
