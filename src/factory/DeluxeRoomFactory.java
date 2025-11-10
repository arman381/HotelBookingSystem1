package factory;

import model.Room;
import model.DeluxeRoom;

public class DeluxeRoomFactory implements RoomFactory {
    @Override
    public Room createRoom() {
        return new DeluxeRoom();
    }
}