package factory;

import model.Room;
import model.StandardRoom;

/**
 * Фабрика для стандартного номера.
 * Student A: реализация фабрики.
 */
public class StandardRoomFactory implements RoomFactory {
    @Override
    public Room createRoom() {
        return new StandardRoom();
    }
}