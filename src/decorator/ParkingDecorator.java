package decorator;

import model.Room;

public class ParkingDecorator implements Room {
    private final Room room;

    public ParkingDecorator(Room room) {
        this.room = room;
    }

    @Override
    public double getPrice() {
        return room.getPrice() + 20.0;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " + parking";
    }
}