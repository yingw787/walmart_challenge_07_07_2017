package classes;

import interfaces.Seat;

/**
* BasicSeat is a basic implementation of the Seat interface.
* Instance variables:
*   - id: ID for the BasicSeat
*   - value: Value of the BasicSeat, could be desirability, value, or any other
*     factor or combination of factors
*   - isHeld: boolean to see if the BasicSeat is being held.
*   - isReserved: boolean to see if the BasicSeat is being reserved.
* @author Ying Wang
*/
public class BasicSeat implements Seat {

    private int id;
    private int value;
    private boolean isHeld = false;
    private boolean isReserved = false;

    public BasicSeat(int id, int value) {
        this.id = id;
        this.value = value;
    }

    /**
    * Hold BasicSeat.
    */
    public void hold() {
        if (this.isReserved) {
            // TODO: Raise Exception because you cannot hold a reserved seat.
        } else {
            this.isHeld = true;
        }
    }

    /**
    * Reserve BasicSeat.
    */
    public void reserve() {
        this.isHeld = false;
        this.isReserved = true;
    }

    /**
    * Checks whether BasicSeat instance is free.
    * @return whether BasicSeat instance is free.
    */
    public boolean isFree() {
        return !isHeld && !isReserved;
    }

}
