package factory;
import model.*;
import decorator.*;

public class StandardRoomFactory implements RoomFactory {
    public Room createRoom() {
        Room room = new StandardRoom();
        room = new WifiDecorator(room); //вайфай в базе
        return room;
    }
}