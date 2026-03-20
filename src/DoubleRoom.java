
public class DoubleRoom extends Room {

    public DoubleRoom(String roomNumber) {
        super(roomNumber, 2, 350.0, 149.99);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}