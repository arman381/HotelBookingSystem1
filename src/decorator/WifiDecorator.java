package decorator;

import model.Room;


public class WifiDecorator implements Room {
    private final Room room;

    public WifiDecorator(Room room) {
        this.room = room;
    }

    @Override
    public double getPrice() {
        return room.getPrice() + 10.0;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " + WiFi";
    }
}