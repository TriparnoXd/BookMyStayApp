import java.util.ArrayList;
import java.util.List;

/**
 * UseCase4RoomSearch - Demonstrates read-only room search and availability checking.
 * Guests can view available rooms and details without modifying system state.
 *
 * Builds on Use Case 3 by introducing a dedicated search service that separates
 * read access from write/booking operations.
 *
 * @author Student
 * @version 4.0
 */
public class BookMyStayApp{

    /**
     * Application entry point. Sets up inventory and room catalog, then
     * uses RoomSearchService to perform safe, read-only availability searches.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Welcome to Book My Stay App           ");
        System.out.println("   Hotel Booking System  v4.0            ");
        System.out.println("==========================================");
        System.out.println();

        // --- Step 1: Initialize centralized inventory ---
        System.out.println("Initializing Room Inventory...");
        RoomInventory inventory = new RoomInventory();
        System.out.println("  [OK] Inventory initialized.");
        System.out.println();

        // --- Step 2: Build room catalog (domain objects) ---
        System.out.println("Loading Room Catalog...");
        List<Room> roomCatalog = new ArrayList<>();
        roomCatalog.add(new SingleRoom("R101"));
        roomCatalog.add(new DoubleRoom("R201"));
        roomCatalog.add(new SuiteRoom("R301"));
        System.out.println("  [OK] Room catalog loaded with " + roomCatalog.size() + " room type(s).");
        System.out.println();

        // --- Step 3: Simulate one room type being unavailable ---
        System.out.println("Simulating Suite Room sold out...");
        inventory.updateAvailability("Suite Room", 0);
        System.out.println();

        // --- Step 4: Initialize search service (read-only) ---
        RoomSearchService searchService = new RoomSearchService(inventory, roomCatalog);

        // --- Step 5: Guest initiates a room search ---
        System.out.println("Guest initiating room search...");
        System.out.println();
        searchService.displayAvailableRooms();
        System.out.println();

        // --- Step 6: Check individual room type availability ---
        System.out.println("Availability Check by Room Type:");
        String[] typesToCheck = {"Single Room", "Double Room", "Suite Room"};
        for (String type : typesToCheck) {
            boolean available = searchService.isRoomTypeAvailable(type);
            System.out.println("  " + type + " : " + (available ? "Available" : "Not Available"));
        }
        System.out.println();

        // --- Step 7: Confirm inventory was NOT modified by search ---
        System.out.println("Verifying inventory state was not modified by search:");
        inventory.displayInventory();
        System.out.println();

        System.out.println("==========================================");
        System.out.println("  Room search completed successfully.    ");
        System.out.println("==========================================");
    }
}