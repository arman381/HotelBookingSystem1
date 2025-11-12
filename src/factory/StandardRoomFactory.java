package factory;

import model.Room;
import model.StandardRoom;

public class StandardRoomFactory implements RoomFactory {
    @Override
    public Room createRoom() {
        return new StandardRoom();
    }
}