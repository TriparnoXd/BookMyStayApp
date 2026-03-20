public class BookMyStayApp {
    public static void main(String []args){
        System.out.println("==========================================");
        System.out.println("   Welcome to Book My Stay App           ");
        System.out.println("   Hotel Booking System  v2.0            ");
        System.out.println("==========================================");
        System.out.println();

        // --- Create room objects using polymorphism ---
        Room singleRoom = new SingleRoom("R101");
        Room doubleRoom = new DoubleRoom("R201");
        Room suiteRoom  = new SuiteRoom("R301");

        // --- Static availability stored using individual variables ---
        boolean isSingleRoomAvailable = true;
        boolean isDoubleRoomAvailable = true;
        boolean isSuiteRoomAvailable  = false;

        // --- Display room details and availability ---
        System.out.println("Available Room Types & Inventory Status:");
        System.out.println();

        singleRoom.displayRoomDetails();
        System.out.println("  Availability  : " + (isSingleRoomAvailable ? "Available" : "Not Available"));
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("  Availability  : " + (isDoubleRoomAvailable ? "Available" : "Not Available"));
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("  Availability  : " + (isSuiteRoomAvailable ? "Available" : "Not Available"));
        System.out.println();

        System.out.println("==========================================");
        System.out.println("  Room initialization complete.          ");
        System.out.println("==========================================");
    }
}
