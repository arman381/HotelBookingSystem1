package factory;
import model.*;
import decorator.*;

public class SuiteRoomFactory implements RoomFactory {
    @Override
    public Room createRoom() {
        Room room = new SuiteRoom();
        room = new WifiDecorator(room);
        room = new BreakfastDecorator(room);
        room = new ParkingDecorator(room);  // парковка в базе
        return room;
    }
}