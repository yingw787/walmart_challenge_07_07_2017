import org.junit.Test;
import static org.junit.Assert.*;

import classes.BasicPerformanceVenue;
import classes.BasicTicketService;

public class BasicTicketServiceTest {

    // Test that the BasicTicketService implements the TicketService interface.
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

    @Test public void testHasReserveSeatsMethod() {
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

    // @Test public void testReturnsDiffSeatsIfSomeAllocated() {
    //     BasicPerformanceVenue venue = new BasicPerformanceVenue();
    // }
}
