package observer;

public class EmailNotification implements BookingObserver {
    @Override
    public void update(String message) {
        System.out.println("[EMAIL] " + message);
    }
}