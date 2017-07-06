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
* @author Ying Wang
*/
public class BasicPerformanceVenue implements PerformanceVenue {

    private BasicSeat[][] Seats;
    private int numRows;
    private int numCols;

    public void markSeatAsReserved() {

    }
}
