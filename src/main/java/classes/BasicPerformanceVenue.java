package classes;

import java.util.ArrayList;

import classes.BasicSeat;
import interfaces.PerformanceVenue;

/**
* BasicPerformanceVenue is a basic implementation of the PerformanceVenue
*   interface.
* BasicPerformanceVenue is composed by BasicTicketService, which provides the
*   user-facing interactions to mutate BasicPerformanceVenue.
* BasicPerformanceVenue arranges a collection of BasicSeats as an NxM matrix.
* BasicSeats within BasicPerformanceVenue are marked with IDs that help
*   indicate their position within the larger matrix.
* Instance variables:
*   - Seats: A matrix of BasicSeats.
*   - numRows: The number of rows in Seats.
*   - numCols: The number of columns in Seats.
*   - numAvailableSeats: The number of available seats in BasicPerformanceVenue.
* @author Ying Wang
*/
public class BasicPerformanceVenue implements PerformanceVenue {

    private BasicSeat[][] seats;
    private int numRows;
    private int numCols;
    private int availableSeats;

    /**
    * Constructs a BasicPerformanceVenue.
    * e.g. given a 5x5 matrix, the BasicSeat IDs would be arranged as such:
    * [ 0,  1,  2,  3,  4]
    * [ 5,  6,  7,  8,  9]
    * [10, 11, 12, 13, 14]
    * [15, 16, 17, 18, 19]
    * [20, 21, 22, 23, 24]
    */
    public BasicPerformanceVenue(int numRows, int numCols) {
        if (numRows <= 0 || numCols <= 0) {
            throw new IndexOutOfBoundsException("numRows and numCols must both be greater than 0.");
        }

        this.numRows = numRows;
        this.numCols = numCols;
        this.availableSeats = numRows * numCols;
        this.seats = new BasicSeat[numRows][numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                // set the ID to increment as loops traverse over matrix.
                // note that numCols is also the width of each row.
                int basicSeatId = (numCols * rowIdx) + colIdx;

                // value of each seat is based on which row it is in. More
                //  complex logic can be added in at some later time.
                int basicSeatValue = numRows - rowIdx;
                this.seats[rowIdx][colIdx] = new BasicSeat(basicSeatId, basicSeatValue);
            }
        }

    }

    /**
    * Checks whether basicSeatId is a valid BasicSeat ID within given BasicPerformanceVenue instance.
    * @param basicSeatId: possible ID of a BasicSeat within BasicPerformanceVenue.
    * @return is basicSeatId a valid BasicSeat ID.
    */
    private boolean isValidSeatId(int basicSeatId) {
        return basicSeatId >= 0 && basicSeatId < numRows * numCols;
    }

    /**
    * Gets a BasicSeat by a basicSeatId.
    * @param basicSeatId: ID of a BasicSeat within BasicPerformanceVenue.
    * @return BasicSeat with given ID.
    */
    private BasicSeat getSeatById(int basicSeatId) throws IndexOutOfBoundsException {
        if (!this.isValidSeatId(basicSeatId)) {
            String exceptionMessage = String.format("basicSeatId must be greater than or equal to %d and less than %d", 0, numRows * numCols);
            throw new IndexOutOfBoundsException(exceptionMessage);
        }

        int rowIdx = basicSeatId / numCols;
        int colIdx = basicSeatId % numCols;
        return this.seats[rowIdx][colIdx];
    }

    private void setSeatById(int basicSeatId, BasicSeat seat) throws IndexOutOfBoundsException {
        if (!this.isValidSeatId(basicSeatId)) {
            String exceptionMessage = String.format("basicSeatId must be greater than or equal to %d and less than %d", 0, numRows * numCols);
            throw new IndexOutOfBoundsException(exceptionMessage);
        }

        int rowIdx = basicSeatId / numCols;
        int colIdx = basicSeatId % numCols;
        this.seats[rowIdx][colIdx] = seat;
    }

    /**
    * Mark BasicSeat as reserved.
    * @return the ID of the BasicSeat.
    */
    public void markSeatAsReserved(int basicSeatId, String claimerId) {
        BasicSeat seat = this.getSeatById(basicSeatId);
        seat.reserve(claimerId);
        this.setSeatById(basicSeatId, seat);
    }

    /**
    * Mark BasicSeat as held.
    * @return the ID of the BasicSeat.
    */
    public void markSeatAsHeld(int basicSeatId, String holderId) {

        // Copy the seat and make changes to the copy before saving, so that if an exception is thrown, no need to roll back state.
        BasicSeat seat = this.getSeatById(basicSeatId);
        seat.hold(holderId);
        this.setSeatById(basicSeatId, seat);

        // as reserving a BasicSeat is only possible when it is held,
        // only decrement the number of available seats when it is marked as held to avoid duplication.
        this.availableSeats -= 1;
    }

    /**
    * Marks a BasicSet as freed.
    */
    public void markSeatAsFreed(int basicSeatId) {
        // TODO: Free the BasicSeat.
        BasicSeat seat = this.getSeatById(basicSeatId);
        seat.free();
        this.availableSeats += 1;
    }

    /**
    * Gets number of available seats (not held or reserved).
    * @return the number of available seats.
    */
    public int getNumAvailableSeats() {
        return this.availableSeats;
    }

    /**
    * Gets most valuable number of BasicSeats from BasicPerformanceVenue.
    * Increment through this.seats as to find the most valuable seats.
    * @param numSeats: number of seats desired
    * @return ArrayList<Integer> of basicSeatIds
    * @throw IndexOutOfBoundsException if not enough available seats.
    */
    public ArrayList<Integer> getMostValuableAvailableSeats(int numSeats) throws IndexOutOfBoundsException {
        int numberOfSeats = numSeats;
        ArrayList<Integer> basicSeatIds = new ArrayList<Integer>();

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                BasicSeat seat = this.seats[rowIdx][colIdx];
                if (seat.isFree()) {
                    basicSeatIds.add(seat.getId());
                    numberOfSeats -= 1;
                    if (numberOfSeats == 0) {
                        return basicSeatIds;
                    }
                }
            }
        }

        // If haven't returned yet, that means all seats have been
        //  traversed through and there are still seats demanded.
        String exceptionMessage = "Not enough seats available.";
        throw new IndexOutOfBoundsException(exceptionMessage);
    }

}
