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

    private BasicSeat[][] Seats;
    private int numRows;
    private int numCols;
    private int availableSeats;

    public BasicPerformanceVenue(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.availableSeats = numRows * numCols;

    }

    private boolean isValidSeatId(int basicSeatId) {
        return true;
    }

    public boolean markSeatAsReserved(int basicSeatId) {
        try {
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public boolean markSeatAsHeld(int basicSeatId) {
        try {
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

}
