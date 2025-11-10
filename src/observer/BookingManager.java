package observer;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (BookingObserver observer : observers) {
            observer.update(message);
        }
    }
}
