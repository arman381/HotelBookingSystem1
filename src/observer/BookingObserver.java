package observer;
import model.Booking;

public interface BookingObserver {
    void onBookingCreated(Booking b, String msg);
}