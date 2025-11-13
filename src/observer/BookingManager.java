package observer;
import model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<BookingObserver> list = new ArrayList<>();

    public void add(BookingObserver o) {
        list.add(o);
    }

    public void send(Booking b, String text) {
        for (BookingObserver o : list) {
            o.onBookingCreated(b, text);
        }
    }
}