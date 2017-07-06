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
    */
    void markSeatAsReserved(int seatId);

}
