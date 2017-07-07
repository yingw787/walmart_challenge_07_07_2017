import org.junit.Test;
import static org.junit.Assert.*;

import classes.BasicSeat;

public class BasicSeatTest {

    // Test the hold() method.
    @Test public void testHoldSeatChangesIsFree() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String holderId = "thing@thing.com";
        classUnderTest.hold(holderId);
        assertFalse("BasicSeat is currently not free", classUnderTest.isFree());
    }

    @Test(expected = IllegalStateException.class)
    public void testCannotHoldSeatIfNotFree() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String holderId = "thing@thing.com";
        classUnderTest.hold(holderId);
        assertFalse("BasicSeat is currently not free", classUnderTest.isFree());

        String otherHolderId = "thing2@thing.com";
        classUnderTest.hold(holderId);
    }


    // Test the reserve() method.
    @Test public void testReserveSeatPossibleIfHeld() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String holderId = "thing@thing.com";
        classUnderTest.hold(holderId);
        assertFalse("BasicSeat is not free", classUnderTest.isFree());

        String claimerId = "thing@thing.com";
        classUnderTest.reserve(claimerId);
        assertFalse("BasicSeat is still not free", classUnderTest.isFree());
    }

    @Test(expected = IllegalStateException.class)
    public void testCannotReserveSeatIfFree() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String claimerId = "thing@thing.com";
        classUnderTest.reserve(claimerId);
    }

    @Test(expected = IllegalStateException.class)
    public void testCannotReserveSeatIfAlreadyReserved() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String claimerId = "thing@thing.com";
        classUnderTest.reserve(claimerId);
    }

    @Test(expected = IllegalStateException.class)
    public void testCannotReserveSeatIfIdsDoNotMatch() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        String holderId = "thing@thing.com";
        classUnderTest.hold(holderId);
        assertFalse("BasicSeat is not free", classUnderTest.isFree());

        String claimerId = "thing2@thing.com";
        classUnderTest.reserve(claimerId);
    }


    // Test the free() method.
    @Test public void testCanFreeSeatsWhateverCurrentState() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        assertTrue("BasicSeat is currently free", classUnderTest.isFree());

        classUnderTest.free();
        assertTrue("BasicSeat is still free", classUnderTest.isFree());

        String holderId = "thing@thing.com";
        classUnderTest.hold(holderId);
        assertFalse("BasicSeat is not free", classUnderTest.isFree());
        classUnderTest.free();
        assertTrue("BasicSeat has been freed from held state", classUnderTest.isFree());

        String claimerId = "thing@thing.com";
        classUnderTest.hold(holderId);
        classUnderTest.reserve(claimerId);
        assertFalse("BasicSeat is not free", classUnderTest.isFree());
        classUnderTest.free();
        assertTrue("BasicSeat has been freed from reserved state", classUnderTest.isFree());
    }

    // Test the getId() method.
    @Test public void testCanGetId() {
        int seatId = 1;
        int seatValue = 5;
        BasicSeat classUnderTest = new BasicSeat(seatId, seatValue);
        int expectedOutput = 1;
        int gotOutput = classUnderTest.getId();
        assertEquals(expectedOutput, gotOutput);
    }

}
