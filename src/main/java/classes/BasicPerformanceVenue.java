package classes;

import classes.BasicSeat;
import interfaces.PerformanceVenue;

/**
* BasicPerformanceVenue is a basic implementation of the PerformanceVenue
* interface.
* BasicPerformanceVenue is composed by BasicTicketService, which provides the
* user-facing interactions to mutate BasicPerformanceVenue.
* BasicPerformanceVenue arranges a collection of BasicSeats as an NxM matrix.
* @author Ying Wang
*/
public class BasicPerformanceVenue implements PerformanceVenue {

    /**
    * The seats are arranged in a basic NxM matrix.
    */
    BasicSeat[][] Seats;

    public void reserveSeat(BasicSeat seat) {
        
    }
}
