package interfaces;

/**
* SeatHold is the interface for a reservation of a Seat or Seats within a
* PerformanceVenue.
*
* @author Ying Wang
*/
public interface SeatHold {
    // TODO: Add in methods and variables.

    /**
    * gets ID of SeatHold.
    * @return the ID of SeatHold instance.
    */
    int getId();

    /**
    * Gets reservation code of SeatHold.
    * @return reservation code of SeatHold instance.
    */
    String getReservationCode();
}
