
public class SuiteRoom extends Room {
    public SuiteRoom(String roomNumber) {
        super(roomNumber, 3, 600.0, 299.99);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}