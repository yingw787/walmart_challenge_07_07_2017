package interfaces;

/**
* Seat is the interface for a seat within a PerformanceVenue.
* @author Ying Wang
*/
public interface Seat {

    /**
    * Hold Seat.
    * @param holderId: the ID of the holder that will hold the Seat.
    */
    void hold(String holderId);

    /**
    * Reserves Seat after Seat is held. Can only be done if
    * claimerId matches the Seat's holderId.
    * @param claimerId: the ID of the claimer that will reserve the Seat.
    */
    void reserve(String claimerId);

    /**
    * Free Seat.
    */
    void free();

    /**
    * Checks whether Seat instance is free.
    * @return whether Seat instance is free.
    */
    boolean isFree();

}
