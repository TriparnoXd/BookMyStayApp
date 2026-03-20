import java.util.ArrayList;
import java.util.List;

/**
 * RoomSearchService - Provides read-only access to room availability and details.
 * Retrieves data from RoomInventory and Room domain objects without modifying state.
 * Maintains a clear boundary between search logic and booking/mutation logic.
 *
 * @author Student
 * @version 4.0
 */
public class RoomSearchService {

    /** Centralized inventory used for availability lookups. */
    private RoomInventory inventory;

    /** List of all room domain objects containing pricing and details. */
    private List<Room> roomCatalog;

    /**
     * Constructs a RoomSearchService with the given inventory and room catalog.
     *
     * @param inventory   the centralized room inventory
     * @param roomCatalog the list of all room domain objects
     */
    public RoomSearchService(RoomInventory inventory, List<Room> roomCatalog) {
        this.inventory   = inventory;
        this.roomCatalog = roomCatalog;
    }

    /**
     * Searches for available rooms by checking inventory counts.
     * Filters out any room types with zero availability.
     * Does not modify inventory or any room state.
     *
     * @return a list of Room objects whose type has availability greater than zero
     */
    public List<Room> searchAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : roomCatalog) {
            String roomType = room.getRoomType();
            int count = inventory.getAvailability(roomType);

            // Defensive check: only include rooms with valid positive availability
            if (count > 0) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    /**
     * Displays available rooms with their details and pricing to the console.
     * Reads from domain objects and inventory only; no state is modified.
     */
    public void displayAvailableRooms() {
        List<Room> availableRooms = searchAvailableRooms();

        System.out.println("--------------------------------------------------");
        System.out.println("           Available Rooms for Booking            ");
        System.out.println("--------------------------------------------------");

        if (availableRooms.isEmpty()) {
            System.out.println("  No rooms are currently available.");
        } else {
            for (Room room : availableRooms) {
                String roomType = room.getRoomType();
                int count = inventory.getAvailability(roomType);

                System.out.println("  Room Number   : " + room.getRoomNumber());
                System.out.println("  Room Type     : " + roomType);
                System.out.println("  Number of Beds: " + room.getNumberOfBeds());
                System.out.println("  Room Size     : " + room.getRoomSize() + " sq ft");
                System.out.println("  Price/Night   : $" + room.getPricePerNight());
                System.out.println("  Rooms Left    : " + count);
                System.out.println("  ------------------------------------------");
            }
        }

        System.out.println("  Total Available Types: " + availableRooms.size());
        System.out.println("--------------------------------------------------");
    }

    /**
     * Checks whether a specific room type is available.
     * Read-only operation; does not alter inventory state.
     *
     * @param roomType the type of room to check
     * @return true if at least one room of that type is available, false otherwise
     */
    public boolean isRoomTypeAvailable(String roomType) {
        return inventory.getAvailability(roomType) > 0;
    }
}