import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import classes.BasicPerformanceVenue;

public class BasicPerformanceVenueTest {

    // Test constructor.
    @Test public void testNumAvailableSeatsAreSameAsNumSeatsIfNoneAssigned() {
        int numRows = 6;
        int numCols = 8;

        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);
        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCannotConstructIfNumRowsInvalid() {
        int numRows = -2;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCannotConstructIfNumColsInvalid() {
        int numRows = 6;
        int numCols = -8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCannotConstructIfBothNumRowsNumColsInvalid() {
        int numRows = -4;
        int numCols = -9;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);
    }


    // Test markSeatAsHeld() method.
    @Test public void testHeldSeatsDecrementedFromAvailableSeats() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        int seatId = (int) Math.ceil(Math.random() * (numRows * numCols));
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);

        expectedNumAvailableSeats = (6 * 8) - 1;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testHoldingThrowsExceptionIfSeatIdGreaterThanNumSeats() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) + 1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testHoldingThrowsExceptionIfSeatIdLessThanZero() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) * -1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);
    }


    // Test markSeatAsReserved() method.
    @Test public void testReservingDoesNotChangeNumAvailableSeats() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        int seatId = (int) Math.ceil(Math.random() * (numRows * numCols));
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);

        expectedNumAvailableSeats = (6 * 8) - 1;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        classUnderTest.markSeatAsReserved(seatId, holderId);
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReservingThrowsExceptionIfSeatIdGreaterThanNumSeats() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) + 1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsReserved(seatId, holderId);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReservingThrowsExceptionIfSeatIdLessThanZero() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) * -1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsReserved(seatId, holderId);
    }


    // Test markSeatAsFreed() method.
    @Test public void testFreeingAHeldSeatIncreasesNumSeatsAvailable() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        int seatId = (int) Math.ceil(Math.random() * (numRows * numCols));
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);

        expectedNumAvailableSeats = (6 * 8) - 1;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        classUnderTest.markSeatAsFreed(seatId);
        expectedNumAvailableSeats = 6 * 8;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
    }

    @Test public void testFreeingReservedSeatDoesNotChangeNumSeatsAvailable() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        int seatId = (int) Math.ceil(Math.random() * (numRows * numCols));
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsHeld(seatId, holderId);

        expectedNumAvailableSeats = (6 * 8) - 1;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        classUnderTest.markSeatAsReserved(seatId, holderId);

        expectedNumAvailableSeats = (6 * 8) - 1;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        classUnderTest.markSeatAsFreed(seatId);
        expectedNumAvailableSeats = 6 * 8;
        gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFreeingThrowsExceptionIfSeatIdGreaterThanNumSeats() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) + 1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsFreed(seatId);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFreeingThrowsExceptionIfSeatIdLessThanZero() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int seatId = (numRows * numCols) * -1;
        String holderId = "thing@thing.com";
        classUnderTest.markSeatAsFreed(seatId);
    }

    // Test getNumAvailableSeats() method.
    @Test public void testNumAvailableSeatsDecreaseForEveryHeldSeat() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        String holderId = "thing@thing.com";

        for (int idx = 0; idx < numRows * numCols; idx++) {
            int seatId = idx;
            classUnderTest.markSeatAsHeld(seatId, holderId);
            expectedNumAvailableSeats -= 1;
            gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
            assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
        }
    }

    @Test public void testNumAvailableSeatsIncreaseForEveryFreedSeatPreviouslyHeld() {
        int numRows = 6;
        int numCols = 8;
        BasicPerformanceVenue classUnderTest = new BasicPerformanceVenue(numRows, numCols);

        int expectedNumAvailableSeats = 6 * 8;
        int gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
        assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);

        String holderId = "thing@thing.com";

        for (int idx = 0; idx < numRows * numCols; idx++) {
            int seatId = idx;
            classUnderTest.markSeatAsHeld(seatId, holderId);
            expectedNumAvailableSeats -= 1;
            gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
            assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
        }

        for (int idx = 0; idx < numRows * numCols; idx++) {
            int seatId = idx;
            classUnderTest.markSeatAsFreed(seatId);
            expectedNumAvailableSeats += 1;
            gotNumAvailableSeats = classUnderTest.getNumAvailableSeats();
            assertEquals(expectedNumAvailableSeats, gotNumAvailableSeats);
        }
    }


    // cannot getMostValuableAvailableSeats() method.
    // BasicPerformanceVenue.seats is a private variable and not exposed.
    // Could use reflection in order to test, however is an anti-pattern.

}
