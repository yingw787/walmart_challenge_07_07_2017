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
*   - holderId: the ID of the claimer to the Seat, which for now is the
*     customerEmail.
* @author Ying Wang
*/
public class BasicSeat implements Seat {

    private int id;
    private int value;
    private boolean isHeld = false;
    private boolean isReserved = false;
    private String holderId;

    public BasicSeat(int id, int value) {
        this.id = id;
        this.value = value;
    }

    /**
    * Hold BasicSeat.
    */
    public void hold(String holderId) throws IllegalStateException {
        if (!this.isFree()) {
            // TODO: Raise Exception because you cannot hold a reserved or held seat.
            throw new IllegalStateException("Cannot hold seat if it is not free.");
        } else {
            this.isHeld = true;
            this.isReserved = false;
            this.holderId = holderId;
        }
    }

    /**
    * Reserve BasicSeat.
    * Assume that BasicSeat can only be reserved after it has been held.
    */
    public void reserve(String claimerId) throws IllegalStateException {
        // Can reserve a seat that is being held, as long as the person
        // reserving the seat is the same one who held it, or if the seat is
        // not reserved already.
        if (!this.isHeld || (this.isHeld && claimerId != this.holderId)) {
            // TODO: Raise Exception because you cannot hold a reserved or held seat.
            throw new IllegalStateException("Cannot reserve seat if it is not held or if the claimer's id does not match the holder's id.");
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

    /**
    * Gets ID of BasicSeat.
    * @return ID of BasicSeat instance.
    */
    public int getId() {
        return this.id;
    }

}
