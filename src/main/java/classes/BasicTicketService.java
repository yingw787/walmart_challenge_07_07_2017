package classes;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import classes.BasicPerformanceVenue;
import classes.BasicSeat;
import classes.BasicSeatHold;
import interfaces.PerformanceVenue;
import interfaces.TicketService;

/**
* BasicTicketService is a basic implementation of the TicketService
*   interface.
* Instance variables:
*   - performanceVenue: an instance of a class that implements
*     PerformanceVenue.
*   - reservations: an ArrayList of BasicSeatHold objects.
* @author Ying Wang
*/
public class BasicTicketService implements TicketService {

    /**
    * The Performance Venue attached to the BasicTicketService.
    * Separated out because don't want to tightly couple the
    * BasicTicketService to a particular Performance Venue.
    */
    private PerformanceVenue performanceVenue;
    private ArrayList<BasicSeatHold> reservations = new ArrayList<BasicSeatHold>();

    public BasicTicketService() {
        /*
            Initialize performanceVenue with some default numRows and
            numCols.

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
    *
    * O(1) time, O(1) space
    * (returns an instance variable on the BasicPerformanceVenue object)
    */
    public int numSeatsAvailable() {
        return this.performanceVenue.getNumAvailableSeats();
    }

    /**
    * Find and hold the best available seats for a customer
    *
    * @param numSeats the number of seats to find and hold
    * @param customerEmail unique identifier for the customer
    * @return a SeatHold object identifying the specific seats and
    *   related information
    *
    * O(N * M) time, O(N * M) space (N = BasicPerformanceVenue.numRows,
    *   M = BasicPerformanceVenue.numCols)
    * (need to potentially traverse through all seats in the performance
    *   venue in order to find available ones)
    */
    public BasicSeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        ArrayList<Integer> basicSeatIds = this.performanceVenue.getMostValuableAvailableSeats(numSeats);
        for (Integer seatId: basicSeatIds) {
            this.performanceVenue.markSeatAsHeld(seatId, customerEmail);
        }

        BasicSeatHold reservation = new BasicSeatHold(basicSeatIds);
        this.reservations.add(reservation);
        return reservation;
    }

    /**
    * Commit seats held for a specific customer
    *
    * @param seatHoldId the seat hold identifier
    * @param customerEmail the email address of the customer to which the
    *   seat hold is assigned
    * @return a reservation confirmation code
    *
    * O(A) time, O(A) space (A = number of BasicSeats within
    *   BasicSeatHold)
    * (need to traverse through all held seats in order to set their
    *   state to reserved)
    */
    public String reserveSeats(int seatHoldId, String customerEmail) {
        BasicSeatHold reservation = this.findReservation(seatHoldId);
        for (Integer seatId : reservation.getBasicSeatIds()) {
            this.performanceVenue.markSeatAsReserved(seatId, customerEmail);
        }

        this.removeReservation(seatHoldId);
        return reservation.getReservationCode();
    }

    private BasicSeatHold findReservation(int seatHoldId) throws NoSuchElementException {
        for (BasicSeatHold reservation : this.reservations) {
            if (reservation.getId() == seatHoldId) {
                return reservation;
            }
        }

        String exceptionMessage = "seatHoldId not found in current active SeatHolds.";
        throw new NoSuchElementException(exceptionMessage);
    }

    private void removeReservation(int seatHoldId) throws NoSuchElementException {
        // Iterating through with idx because need to remove from ArrayList by index.
        for (int idx = 0; idx < this.reservations.size(); idx++) {
            BasicSeatHold reservation = this.reservations.get(idx);
            if (reservation.getId() == seatHoldId) {
                this.reservations.remove(idx);
                return;
            }
        }

        String exceptionMessage = "seatHoldId not found in current active SeatHolds.";
        throw new NoSuchElementException(exceptionMessage);
    }

}
