package observer;
import model.Booking;

public class SMSNotification implements BookingObserver {
    public void onBookingCreated(Booking b, String text ) {
        System.out.println("SMS: " + text + " to " + b.getCustomer());
    }
}