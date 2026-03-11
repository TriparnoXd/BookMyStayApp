import java.util.*;

// --- Helper class to manage centralized room inventory ---
class RoomInventory {
    private Map<String, Integer> inventoryMap = new HashMap<>();

    public RoomInventory() {
        inventoryMap.put("Single", 5);
    }

    public void updateInventory(String roomType, int count) {
        inventoryMap.put(roomType, inventoryMap.getOrDefault(roomType, 0) + count);
    }

    public int getAvailability(String roomType) {
        return inventoryMap.getOrDefault(roomType, 0);
    }
}

// --- Service class to handle logic for cancellations ---
class CancellationService {
    private Stack<String> releasedRoomIds = new Stack<>();
    private Map<String, String> reservationRoomTypeMap = new HashMap<>();

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            String roomType = reservationRoomTypeMap.get(reservationId);
            inventory.updateInventory(roomType, 1);
            releasedRoomIds.push(reservationId);
            reservationRoomTypeMap.remove(reservationId);
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        }
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}


public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        // Simulate a booking
        service.registerBooking("Single-1", "Single");

        // Process Cancellation
        service.cancelBooking("Single-1", inventory);

        // Show Results
        service.showRollbackHistory();
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailability("Single"));
    }
}