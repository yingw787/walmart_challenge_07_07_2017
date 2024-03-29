package classes;

import java.util.ArrayList;

import classes.BasicSeat;
import interfaces.SeatHold;

/**
* BasicSeatHold is a basic implementation of the SeatHold interface.
* Instance variables:
*   - id: the ID of BasicSeatHold instance.
*   - basicSeatIds: an ArrayList of IDs of BasicSeats tracked by BasicSeatHold instance.
* @author Ying Wang
*/
public class BasicSeatHold implements SeatHold {

    private int id = 1;
    private ArrayList<Integer> basicSeatIds;

    public BasicSeatHold(ArrayList<Integer> basicSeatIds) {
        // Generate ID from IDs of BasicSeats within reservedSeats.
        // That way, IDs will likely never collide.
        // To generate unique ID, multiply all the IDs of the BasicSeats together.
        for (Integer seatId: basicSeatIds) {
            this.id *= seatId;
        }
        this.basicSeatIds = basicSeatIds;
    }

    public void addHeldSeat(BasicSeat basicSeat) {
        int seatId = basicSeat.getId();
        this.id *= seatId;
        this.basicSeatIds.add(seatId);
    }

    public ArrayList<Integer> getBasicSeatIds() {
        return this.basicSeatIds;
    }

    public int getId() {
        return this.id;
    }

    /**
    * Return the ID of the BasicSeat in string form.
    * Know that the ID is already unique, no need to create
    *   another type of unique string.
    */
    public String getReservationCode() {
        return Integer.toString(this.id);
    }

}
