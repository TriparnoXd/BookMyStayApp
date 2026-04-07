import java.util.HashMap;

/**
 * RoomInventory - Manages centralized room availability for the Hotel Booking System.
 * Replaces scattered availability variables with a single HashMap, providing
 * a consistent and scalable single source of truth for room inventory.
 *
 * @author Student
 * @version 3.0
 */
public class RoomInventory {

    /**
     * Central inventory map storing room type as key and available count as value.
     * Provides O(1) average-time complexity for lookups and updates.
     */
    private HashMap<String, Integer> inventory;

    /**
     * Constructs a RoomInventory and initializes room availability
     * for all supported room types.
     */
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room",  2);
    }

    /**
     * Returns the number of available rooms for the given room type.
     *
     * @param roomType the type of room to check (e.g., "Single Room")
     * @return the number of available rooms, or 0 if the type is not found
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Updates the availability count for the specified room type.
     * Controlled updates ensure inventory state remains consistent.
     *
     * @param roomType the type of room to update
     * @param count    the new availability count to set
     */
    public void updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, count);
            System.out.println("  [Updated] " + roomType + " availability set to: " + count);
        } else {
            System.out.println("  [Error] Room type not found: " + roomType);
        }
    }

    /**
     * Adds a new room type with an initial availability count.
     * Demonstrates scalability — no changes to application logic required.
     *
     * @param roomType      the new room type to register
     * @param initialCount  the initial number of available rooms
     */
    public void addRoomType(String roomType, int initialCount) {
        inventory.put(roomType, initialCount);
        System.out.println("  [Registered] New room type added: " + roomType
                + " | Count: " + initialCount);
    }

    /**
     * Displays the current state of the entire room inventory to the console.
     */
    public void displayInventory() {
        System.out.println("--------------------------------------------------");
        System.out.println("         Current Room Inventory Status            ");
        System.out.println("--------------------------------------------------");
        for (String roomType : inventory.keySet()) {
            int count = inventory.get(roomType);
            String status = (count > 0) ? "Available (" + count + " rooms)" : "Not Available";
            System.out.printf("  %-15s : %s%n", roomType, status);
        }
        System.out.println("--------------------------------------------------");
    }
}