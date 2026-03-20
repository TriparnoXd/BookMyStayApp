/**
 * SingleRoom - Concrete class representing a single occupancy hotel room.
 * Extends the abstract Room class with single-room specific characteristics.
 *
 * @author Student
 * @version 2.0
 */
public class SingleRoom extends Room {

    /**
     * Constructs a SingleRoom with the specified room number.
     * Default values are applied for beds, size, and price.
     *
     * @param roomNumber the unique identifier for this room
     */
    public SingleRoom(String roomNumber) {
        super(roomNumber, 1, 200.0, 99.99);
    }

    /**
     * Returns the room type identifier for a single room.
     *
     * @return "Single Room"
     */
    @Override
    public String getRoomType() {
        return "Single Room";
    }
}