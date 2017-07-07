package classes;

import java.util.ArrayList;

import classes.BasicPerformanceVenue;
import classes.BasicSeat;
import classes.BasicSeatHold;
import interfaces.PerformanceVenue;
import interfaces.TicketService;

/**
* BasicTicketService is a basic implementation of the TicketService interface.
* Instance variables:
*   - performanceVenue: an instance of a class that implements
*     PerformanceVenue.
*   - reservations: an ArrayList of BasicSeatHold objects.
* @author Ying Wang
*/
public class BasicTicketService implements TicketService {

    /**
    * The Performance Venue attached to the BasicTicketService.
    * Separated out because don't want to tightly couple the BasicTicketService
    *   to a particular Performance Venue.
    */
    private PerformanceVenue performanceVenue;
    private ArrayList<BasicSeatHold> reservations = new ArrayList<BasicSeatHold>();

    public BasicTicketService() {
        /*
            Initialize performanceVenue with some default numRows and numCols.

            This is because BasicTicketService should not care about the
            specifics of the performance venue layout.
        */
        this.performanceVenue = new BasicPerformanceVenue(5, 5);
    }

    public BasicTicketService(PerformanceVenue performanceVenue) {
        /*
            If user would like to specify a performanceVenue for the
            BasicTicketService to wrap, they should be able to do so.
        */
        this.performanceVenue = performanceVenue;
    }

    /**
    * The number of seats in the venue that are neither held nor reserved
    *
    * @return the number of tickets available in the performanceVenue
    */
    public int numSeatsAvailable() {
        return this.performanceVenue.getNumAvailableSeats();
    }

    /**
    * Find and hold the best available seats for a customer
    *
    * @param numSeats the number of seats to find and hold
    * @param customerEmail unique identifier for the customer
    * @return a SeatHold object identifying the specific seats and related information
    */
    public BasicSeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        return new BasicSeatHold(new BasicSeat[0]);
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
