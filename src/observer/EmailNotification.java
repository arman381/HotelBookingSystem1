package observer;
import model.Booking;

public class EmailNotification implements BookingObserver {
        public void onBookingCreated(Booking b, String text) {
            System.out.println("Email: " + text);
            // System.out.println("  Customer: " + b.getCustomer());
            // System.out.println("  Room: " + b.getRoom().getDescription());
            // System.out.println("  From: " + b.getCheckIn() + " to " + b.getCheckOut());
    }
}