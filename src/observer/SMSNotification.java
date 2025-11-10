package observer;

public class SMSNotification implements BookingObserver {
    @Override
    public void update(String message) {
        System.out.println("[SMS] " + message);
    }
}