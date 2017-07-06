package interfaces;

import java.util.Collection;

import interfaces.Seat;

/**
* PerformanceVenue is the interface for the location where the actual Seats
* are stored and interacted with.
* @author Ying Wang
*/
public interface PerformanceVenue {

    /**
    * Reserve exactly one seat in the PerformanceVenue.
    * Returns true if the seat has been successfully marked as reserved.
    * Returns false if the seat could not be successfully marked as reserved.
    */
    boolean markSeatAsReserved(int seatId);

    /**
    * Hold exactly one seat in the PerformanceVenue.
    * Returns true if the seat has been successfully marked as held.
    * Returns false if the seat could not be successfully marked as held.
    */
    boolean markSeatAsHeld(int seatId);

}
