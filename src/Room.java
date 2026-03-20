/**
 * Room - Abstract base class representing a generic hotel room.
 * Defines common attributes and behavior shared by all room types.
 * Cannot be instantiated directly; must be extended by concrete room classes.
 *
 * @author Student
 * @version 2.0
 */
public abstract class Room {

    /** The unique room number assigned to this room. */
    protected String roomNumber;

    /** The number of beds available in this room. */
    protected int numberOfBeds;

    /** The size of the room in square feet. */
    protected double roomSize;

    /** The price per night for this room in USD. */
    protected double pricePerNight;

    /**
     * Constructs a Room with the specified attributes.
     *
     * @param roomNumber    the unique identifier for the room
     * @param numberOfBeds  the number of beds in the room
     * @param roomSize      the size of the room in square feet
     * @param pricePerNight the nightly rate for the room
     */
    public Room(String roomNumber, int numberOfBeds, double roomSize, double pricePerNight) {
        this.roomNumber    = roomNumber;
        this.numberOfBeds  = numberOfBeds;
        this.roomSize      = roomSize;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Returns the room number.
     *
     * @return the room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the number of beds.
     *
     * @return number of beds
     */
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * Returns the room size in square feet.
     *
     * @return room size
     */
    public double getRoomSize() {
        return roomSize;
    }

    /**
     * Returns the price per night.
     *
     * @return price per night
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Returns the type/category of the room.
     * Each concrete subclass must implement this method.
     *
     * @return the room type as a String
     */
    public abstract String getRoomType();

    /**
     * Displays full details of the room to the console.
     */
    public void displayRoomDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("  Room Number   : " + roomNumber);
        System.out.println("  Room Type     : " + getRoomType());
        System.out.println("  Number of Beds: " + numberOfBeds);
        System.out.println("  Room Size     : " + roomSize + " sq ft");
        System.out.println("  Price/Night   : $" + pricePerNight);
        System.out.println("--------------------------------------------------");
    }
}