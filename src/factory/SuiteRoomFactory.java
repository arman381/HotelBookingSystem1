package factory;

import model.Room;
import model.SuiteRoom;

public class SuiteRoomFactory implements RoomFactory {
    @Override
    public Room createRoom() {
        return new SuiteRoom();
    }
}