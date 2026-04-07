public class BookMyStayApp {
    public static void main(String []args){
        System.out.println("==========================================");
        System.out.println("   Welcome to Book My Stay App           ");
        System.out.println("   Hotel Booking System  v3.0            ");
        System.out.println("==========================================");
        System.out.println();

        // --- Step 1: Initialize centralized inventory ---
        System.out.println("Initializing Room Inventory...");
        RoomInventory inventory = new RoomInventory();
        System.out.println("  [OK] Inventory initialized successfully.");
        System.out.println();

        // --- Step 2: Display initial inventory state ---
        System.out.println("Initial Inventory State:");
        inventory.displayInventory();
        System.out.println();

        // --- Step 3: Retrieve availability for specific room types ---
        System.out.println("Availability Check:");
        System.out.println("  Single Room : " + inventory.getAvailability("Single Room") + " room(s) available");
        System.out.println("  Double Room : " + inventory.getAvailability("Double Room") + " room(s) available");
        System.out.println("  Suite Room  : " + inventory.getAvailability("Suite Room")  + " room(s) available");
        System.out.println();

        // --- Step 4: Perform controlled updates to inventory ---
        System.out.println("Performing Inventory Updates:");
        inventory.updateAvailability("Single Room", 3);
        inventory.updateAvailability("Suite Room",  0);
        System.out.println();

        // --- Step 5: Add a new room type (demonstrates scalability) ---
        System.out.println("Registering New Room Type:");
        inventory.addRoomType("Deluxe Room", 4);
        System.out.println();

        // --- Step 6: Display updated inventory state ---
        System.out.println("Updated Inventory State:");
        inventory.displayInventory();
        System.out.println();

        System.out.println("==========================================");
        System.out.println("  Inventory setup complete.              ");
        System.out.println("==========================================");
    }
}
