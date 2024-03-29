package interfaces;

import java.util.ArrayList;

import interfaces.Seat;

/**
* PerformanceVenue is the interface for the location where the actual Seats
* are stored and interacted with.
* @author Ying Wang
*/
public interface PerformanceVenue {

    /**
    * Reserve exactly one seat in the PerformanceVenue.
    * @param seatId: the ID of the Seat to be marked as reserved.
    * @return: true if marking is successful, false if not successful.
    */
    void markSeatAsReserved(int seatId, String claimerId);

    /**
    * Hold exactly one seat in the PerformanceVenue.
    * @param seatId: the ID of the Seat to be marked as reserved.
    * @return: true if marking is successful, false if not successful.
    */
    void markSeatAsHeld(int seatId, String holderId);

    /**
    * Gets number of available seats.
    * @return: number of available seats.
    */
    int getNumAvailableSeats();

    ArrayList<Integer> getMostValuableAvailableSeats(int numSeats) throws IndexOutOfBoundsException;

}
