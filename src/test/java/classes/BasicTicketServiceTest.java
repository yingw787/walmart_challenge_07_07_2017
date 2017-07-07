import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import classes.BasicPerformanceVenue;
import classes.BasicTicketService;

public class BasicTicketServiceTest {

    // Test that the BasicTicketService implements the TicketService interface, and methods exist.
    @Test public void testHasNumSeatsAvailableMethod() {
        BasicTicketService classUnderTest = new BasicTicketService();
        assertNotNull("BasicTicketService has a numSeatsAvailable method", classUnderTest.numSeatsAvailable());
    }

    @Test public void testHasFindAndHoldSeatsMethod() {
        BasicTicketService classUnderTest = new BasicTicketService();
        int numSeats = 5; // stubbed numSeats input
        String customerEmail = "thing@thing.com"; // stubbed customerEmail input
        assertNotNull("BasicTicketService has a findAndHoldSeats method", classUnderTest.findAndHoldSeats(numSeats, customerEmail));
    }

    // Stubs don't work, just need to verify that there is a function.
    @Test(expected = NoSuchElementException.class)
    public void testHasReserveSeatsMethod() {
        BasicTicketService classUnderTest = new BasicTicketService();
        int seatHoldId = 5; // stubbed seatHoldId input
        String customerEmail = "thing@thing.com"; // stubbed customerEmail input
        assertNotNull("BasicTicketService has a reserveSeats method", classUnderTest.reserveSeats(seatHoldId, customerEmail));
    }


    // Test numSeatsAvailable() method:
    @Test public void testReturnsTotalSeatsIfNoneAllocated() {
        // Works with constructor BasicTicketService(int numRows, int numCols)
        BasicPerformanceVenue venue = new BasicPerformanceVenue(6, 6);
        BasicTicketService ticketServiceOne = new BasicTicketService(venue);
        int expectedOutputOne = 6 * 6;
        int gotOutputOne = ticketServiceOne.numSeatsAvailable();
        assertEquals(expectedOutputOne, gotOutputOne);

        // Works with constructor BasicTicketService();
        BasicTicketService ticketServiceTwo = new BasicTicketService();
        int expectedOutputTwo = 5 * 5;
        int gotOutputTwo = ticketServiceTwo.numSeatsAvailable();
        assertEquals(expectedOutputTwo, gotOutputTwo);
    }

    @Test public void testReturnsRemainingNumSeatsIfSomeSeatsAllocated() {
        // Works with constructor BasicTicketService(int numRows, int numCols)
        BasicPerformanceVenue venue = new BasicPerformanceVenue(6, 6);
        BasicTicketService ticketServiceOne = new BasicTicketService(venue);
        ticketServiceOne.findAndHoldSeats(6, "thing@thing.com");
        int expectedOutputOne = 6 * 5;
        int gotOutputOne = ticketServiceOne.numSeatsAvailable();
        assertEquals(expectedOutputOne, gotOutputOne);

        // Works with constructor BasicTicketService();
        BasicTicketService ticketServiceTwo = new BasicTicketService();
        ticketServiceTwo.findAndHoldSeats(13, "thing@thing.com");
        int expectedOutputTwo = 5 * 5 - 13;
        int gotOutputTwo = ticketServiceTwo.numSeatsAvailable();
        assertEquals(expectedOutputTwo, gotOutputTwo);
    }

    @Test public void testReturnsNoSeatsIfAllSeatsAllocated() {
        // Works with constructor BasicTicketService(int numRows, int numCols)
        BasicPerformanceVenue venue = new BasicPerformanceVenue(6, 6);
        BasicTicketService ticketServiceOne = new BasicTicketService(venue);
        ticketServiceOne.findAndHoldSeats(36, "thing@thing.com");
        int expectedOutputOne = 0;
        int gotOutputOne = ticketServiceOne.numSeatsAvailable();
        assertEquals(expectedOutputOne, gotOutputOne);

        // Works with constructor BasicTicketService();
        BasicTicketService ticketServiceTwo = new BasicTicketService();
        ticketServiceTwo.findAndHoldSeats(25, "thing@thing.com");
        int expectedOutputTwo = 0;
        int gotOutputTwo = ticketServiceTwo.numSeatsAvailable();
        assertEquals(expectedOutputTwo, gotOutputTwo);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowsExceptionIfNotEnoughSeats() {
        // Works with constructor BasicTicketService(int numRows, int numCols)
        BasicPerformanceVenue venue = new BasicPerformanceVenue(6, 6);
        BasicTicketService ticketServiceOne = new BasicTicketService(venue);
        ticketServiceOne.findAndHoldSeats(100, "thing@thing.com");

        // Works with constructor BasicTicketService();
        BasicTicketService ticketServiceTwo = new BasicTicketService();
        ticketServiceTwo.findAndHoldSeats(100, "thing@thing.com");
    }


    // Test findAndHoldSeats() method:
    // @Test public void testCanFindOneSeat() {
    //
    // }


    // @Test public void


    // Test reserveSeats() method:

}
