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
        if (!this.isFree()) {
            // TODO: Raise Exception because you cannot hold a reserved or held seat.
            throw new IllegalStateException("Cannot hold seat if it is not free.");
        } else {
            this.isHeld = true;
            this.isReserved = false;
        }
    }

    /**
    * Reserve BasicSeat.
    */
    public void reserve() {
        if (!this.isFree()) {
            // TODO: Raise Exception because you cannot hold a reserved or held seat.
            throw new IllegalStateException("Cannot reserve seat if it is not free.");
        } else {
            this.isHeld = false;
            this.isReserved = true;
        }
    }

    /**
    * Free BasicSeat.
    */
    public void free() {
        this.isHeld = false;
        this.isReserved = false;
    }

    /**
    * Checks whether BasicSeat instance is free.
    * @return whether BasicSeat instance is free.
    */
    public boolean isFree() {
        return !isHeld && !isReserved;
    }

}
