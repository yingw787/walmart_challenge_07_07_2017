import org.junit.Test;
import static org.junit.Assert.*;

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
    //
}
