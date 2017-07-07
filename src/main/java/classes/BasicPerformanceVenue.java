package classes;

import classes.BasicSeat;
import interfaces.PerformanceVenue;

/**
* BasicPerformanceVenue is a basic implementation of the PerformanceVenue
*   interface.
* BasicPerformanceVenue is composed by BasicTicketService, which provides the
*   user-facing interactions to mutate BasicPerformanceVenue.
* BasicPerformanceVenue arranges a collection of BasicSeats as an NxM matrix.
* BasicSeats within BasicPerformanceVenue are marked with IDs that help
*   indicate their position within the larger matrix.
* Instance variables:
*   - Seats: A matrix of BasicSeats.
*   - numRows: The number of rows in Seats.
*   - numCols: The number of columns in Seats.
*   - numAvailableSeats: The number of available seats in BasicPerformanceVenue.
* @author Ying Wang
*/
public class BasicPerformanceVenue implements PerformanceVenue {

    private BasicSeat[][] seats;
    private int numRows;
    private int numCols;
    private int availableSeats;

    public BasicPerformanceVenue(int numRows, int numCols) {
        if (numRows <= 0 || numCols <= 0) {
            throw new IndexOutOfBoundsException("numRows and numCols must both be greater than 0.");
        }

        this.numRows = numRows;
        this.numCols = numCols;
        this.availableSeats = numRows * numCols;
        this.seats = new BasicSeat[numRows][numCols];

    }

    private boolean isValidSeatId(int basicSeatId) {
        return true;
    }

    /**
    * Mark BasicSeat as reserved.
    * @return the ID of the BasicSeat.
    */
    public int markSeatAsReserved(int basicSeatId) {
        try {
            return 0;
        } catch (IllegalStateException e) {
            // Roll back state of BasicSeat before change was made.
            // (rollback. huehuehue)
            return -1;
        }
    }

    /**
    * Mark BasicSeat as held.
    * @return the ID of the BasicSeat.
    */
    public int markSeatAsHeld(int basicSeatId) {
        try {
            // as reserving a BasicSeat is only possible when it is held,
            // only decrement the number of available seats when it is marked as held to avoid duplication.
            this.availableSeats -= 1;
            return 0;
        } catch (IllegalStateException e) {
            // Roll back state of BasicSeat before change was made.
            return -1;
        }
    }

    /**
    */
    public int markSeatAsFreed(int basicSeatId) {
        // TODO: Free the BasicSeat.
        this.availableSeats += 1;
        return -1;
    }

    /**
    * Gets number of available seats (not held or reserved).
    * @return the number of available seats.
    */
    public int getNumAvailableSeats() {
        return this.availableSeats;
    }

}
