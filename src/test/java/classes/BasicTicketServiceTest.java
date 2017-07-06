import org.junit.Test;
import static org.junit.Assert.*;

import classes.BasicTicketService;

public class BasicTicketServiceTest {
    @Test public void testHasNumSeatsAvailableMethod() {
        BasicTicketService classUnderTest = new BasicTicketService();
        assertNotNull("BasicTicketService has a numSeatsAvailable method", classUnderTest.numSeatsAvailable());
    }
}
