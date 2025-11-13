package factory;

import model.*;
import decorator.*;

public class DeluxeRoomFactory implements RoomFactory {
    public Room createRoom() {
        Room room = new DeluxeRoom();
        room = new WifiDecorator(room);
        room = new BreakfastDecorator(room); // завтрак  в базе
        return room;
    }
}