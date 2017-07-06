package classes;

import classes.BasicPerformanceVenue;
import classes.BasicSeatHold;
import interfaces.TicketService;

/**
* BasicTicketService is a basic implementation of the TicketService interface.
* @author Ying Wang
*/
public class BasicTicketService implements TicketService {

    /**
    * The Performance Venue attached to the BasicTicketService.
    * Separated out because don't want to tightly couple the BasicTicketService to a particular Performance Venue.
    *
    */


    /**
    * The number of seats in the venue that are neither held nor reserved
    *
    * @return the number of tickets available in the venue
    */
    public int numSeatsAvailable() {
        return 0;
    }

    /**
    * Find and hold the best available seats for a customer
    *
    * @param numSeats the number of seats to find and hold
    * @param customerEmail unique identifier for the customer
    * @return a SeatHold object identifying the specific seats and related information
    */
    public BasicSeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        return new BasicSeatHold();
    }

    /**
    * Commit seats held for a specific customer
    *
    * @param seatHoldId the seat hold identifier
    * @param customerEmail the email address of the customer to which the seat hold is assigned
    * @return a reservation confirmation code
    */
    public String reserveSeats(int seatHoldId, String customerEmail) {
        return "thing";
    }

}
