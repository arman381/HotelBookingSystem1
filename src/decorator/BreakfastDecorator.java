package decorator;
import model.Room;

public class BreakfastDecorator implements Room {
    private final Room room;

    public BreakfastDecorator(Room room) {
        this.room = room;
    }

    @Override
    public double getPrice() {
        return room.getPrice() + 15.0;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " + breakfast";
    }
}