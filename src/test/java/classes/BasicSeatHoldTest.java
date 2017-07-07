import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import classes.BasicSeat;
import classes.BasicSeatHold;

public class BasicSeatHoldTest {

    // Test constructor.
    @Test public void testInitializesWithIdOfOneIfArrayIsEmpty() {
        ArrayList<Integer> basicSeatIds = new ArrayList<Integer>();
        BasicSeatHold classUnderTest = new BasicSeatHold(basicSeatIds);
        int expectedOutput = 1;
        int gotOutput = classUnderTest.getId();
        assertEquals(expectedOutput, gotOutput);
    }

    @Test public void testInitializesWithIdOfArrayIfArrayNotEmpty() {
        ArrayList<Integer> basicSeatIds = new ArrayList<Integer>();

        Integer basicSeatId = (int) Math.ceil(Math.random() * 100);
        basicSeatIds.add(basicSeatId);

        BasicSeatHold classUnderTest = new BasicSeatHold(basicSeatIds);
        int expectedOutput = basicSeatId;
        int gotOutput = classUnderTest.getId();
        assertEquals(expectedOutput, gotOutput);
    }


    // Test addHeldSeat() method.
    @Test public void testIdChangesWithEachSeatAdded() {
        ArrayList<Integer> basicSeatIds = new ArrayList<Integer>();
        BasicSeatHold classUnderTest = new BasicSeatHold(basicSeatIds);
        int expectedOutput = 1;
        int gotOutput = classUnderTest.getId();
        assertEquals(expectedOutput, gotOutput);

        int expectedSeatHoldId = 1;

        for (int i = 0; i < 37; i++) {
            int seatId = (int) Math.ceil(Math.random() * 100);
            int seatValue = (int) Math.ceil(Math.random() * 100);
            BasicSeat seat = new BasicSeat(seatId, seatValue);
            classUnderTest.addHeldSeat(seat);

            expectedSeatHoldId *= seatId;
            assertEquals(expectedSeatHoldId, classUnderTest.getId());
        }
    }

    // Test getBasicSeatIds() method.
    @Test public void testBasicSeatIdsMatch() {
        ArrayList<Integer> expectedBasicSeatIds = new ArrayList<Integer>();
        BasicSeatHold classUnderTest = new BasicSeatHold(expectedBasicSeatIds);

        for (int i = 0; i < 37; i++) {
            int seatId = (int) Math.ceil(Math.random() * 100);
            int seatValue = (int) Math.ceil(Math.random() * 100);
            BasicSeat seat = new BasicSeat(seatId, seatValue);
            classUnderTest.addHeldSeat(seat);
            expectedBasicSeatIds.add(seatId);
        }

        ArrayList<Integer> gotBasicSeatIds = classUnderTest.getBasicSeatIds();
        for (Integer basicSeatId: expectedBasicSeatIds) {
            assertTrue(gotBasicSeatIds.contains(basicSeatId));
        }
    }

    // Test getReservationCode method.
    @Test public void testReservationCodeIsIdAsStr() {
        ArrayList<Integer> basicSeatIds = new ArrayList<Integer>();
        BasicSeatHold classUnderTest = new BasicSeatHold(basicSeatIds);
        String expectedOutput = "1";
        String gotOutput = classUnderTest.getReservationCode();
        assertTrue(expectedOutput.equals(gotOutput));

        Integer expectedSeatHoldId = 1;

        for (int i = 0; i < 37; i++) {
            Integer seatId = (int) Math.ceil(Math.random() * 100);
            Integer seatValue = (int) Math.ceil(Math.random() * 100);
            BasicSeat seat = new BasicSeat(seatId, seatValue);
            classUnderTest.addHeldSeat(seat);

            expectedSeatHoldId *= seatId;
            assertEquals((int) expectedSeatHoldId, (int) classUnderTest.getId());
            assertTrue(Integer.toString(expectedSeatHoldId).equals(classUnderTest.getReservationCode()));
        }
    }

}
