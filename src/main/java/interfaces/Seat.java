package interfaces;

/**
* Seat is the interface for a seat within a PerformanceVenue.
* @author Ying Wang
*/
public interface Seat {

    /**
    * Hold Seat.
    */
    void hold(Integer holderId);

    /**
    * Reserve Seat.
    */
    void reserve();

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
