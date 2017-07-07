import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import classes.BasicPerformanceVenue;
import classes.BasicSeatHold;
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
    @Test public void testCanFindAndHoldOneSeat() {
        BasicTicketService ticketService = new BasicTicketService();

        BasicSeatHold reservationOne = ticketService.findAndHoldSeats(1, "thing@thing.com");
        // As it is the very first reservation, it will contain BasicSeat with ID of 0, and its id will be the product of all BasicSeat IDs, which means it will be 0.
        int expectedOutput = 0;
        assertEquals(reservationOne.getId(), expectedOutput);

        BasicSeatHold reservationTwo = ticketService.findAndHoldSeats(1, "thing@thing.com");
        // As the prior BasicSeatHold has not been freed, and the second BasicSeatHold is allotted one BasicSeat, it will contain the BasicSeat of ID 1, which means its ID will also be 1.
        expectedOutput = 1;
        assertEquals(reservationTwo.getId(), expectedOutput);
    }

    @Test public void testCanFindAndHoldMultipleSeats() {
        BasicTicketService ticketService = new BasicTicketService();

        BasicSeatHold reservationOne = ticketService.findAndHoldSeats(2, "thing@thing.com");
        // As it is the very first reservation, it will contain BasicSeat with ID of 0, and its id will be the product of all BasicSeat IDs, which means it will be 0.
        int expectedOutput = 0;
        assertEquals(reservationOne.getId(), expectedOutput);

        BasicSeatHold reservationTwo = ticketService.findAndHoldSeats(2, "thing@thing.com");
        // As the prior BasicSeatHold has not been freed, and the second BasicSeatHold is allotted one BasicSeat, it will contain the BasicSeats of IDs 2 and 3, which means its ID will be 6.
        expectedOutput = 6;
        assertEquals(reservationTwo.getId(), expectedOutput);

        BasicSeatHold reservationThree = ticketService.findAndHoldSeats(5, "thing@thing.com");
        // As the prior BasicSeatHold has not been freed, and the second BasicSeatHold is allotted one BasicSeat, it will contain the BasicSeats of IDs 4, 5, 6, 7, 8, which means its ID will be 8!/3!.
        // Not going to include factorial library for one test. Use basic multiplication instead.
        expectedOutput = 4 * 5 * 6 * 7 * 8;
        assertEquals(reservationThree.getId(), expectedOutput);
    }


    // Test reserveSeats() method:
    // As BasicSeats are private and inaccessible to the TicketService, cannot test directly to see the state of BasicSeat instances.
    // Could use reflection in order to test private methods and variables, but could be an anti-pattern.
    // Just make sure that BasicSeats can be reserved without throwing Exceptions except where expected.
    @Test public void testCanMakeOneReservation() {
        BasicTicketService ticketService = new BasicTicketService();
        BasicSeatHold reservationOne = ticketService.findAndHoldSeats(2, "thing@thing.com");
        ticketService.reserveSeats(reservationOne.getId(), "thing@thing.com");
    }

    // @Test public void testCanPlaceMultipleReservations() {
    //     BasicTicketService ticketService = new BasicTicketService();
    //     BasicSeatHold reservationOne = ticketService.findAndHoldSeats(2, "thing@thing.com");
    //     ticketService.reserveSeats(reservationOne.getId(), "thing@thing.com");
    //
    //     BasicSeatHold reservationTwo = ticketService.findAndHoldSeats(5, "thing2@thing.com");
    //     ticketService.reserveSeats(reservationTwo.getId(), "thing2@thing.com");
    // }

    // @Test(expected = IllegalStateException.class)
    // public void testThrowsExceptionWithIncorrectCustomerEmail() {
    //     BasicTicketService ticketService = new BasicTicketService();
    //     BasicSeatHold reservationOne = ticketService.findAndHoldSeats(2, "thing@thing.com");
    //     ticketService.reserveSeats(reservationOne.getId(), "thing2@thing.com");
    // }

}
