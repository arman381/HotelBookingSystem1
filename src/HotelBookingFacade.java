
import model.*;
import factory.*;
import strategy.*;
import observer.*;
import decorator.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HotelBookingFacade {
    private RoomFactory roomFactory;
    private PaymentStrategy paymentStrategy;
    private final BookingManager bookingManager;

    public HotelBookingFacade() {
        this.roomFactory = new StandardRoomFactory();
        this.paymentStrategy = new RegularPayment();
        this.bookingManager = new BookingManager();
        bookingManager.addObserver(new EmailNotification());
        bookingManager.addObserver(new SMSNotification());
    }

    public void setRoomFactory(RoomFactory factory) {
        this.roomFactory = factory;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public Booking book(String customer, LocalDate checkIn, LocalDate checkOut, String... extras) {
        Room room = roomFactory.createRoom();

        for (String extra : extras) {
            if (extra.equalsIgnoreCase("breakfast")) room = new BreakfastDecorator(room);
            if (extra.equalsIgnoreCase("wifi")) room = new WifiDecorator(room);
            if (extra.equalsIgnoreCase("parking")) room = new ParkingDecorator(room);
        }

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double total = paymentStrategy.calculateCost(room.getPrice(), nights);

        Booking booking = new Booking.Builder()
                .setHotel(new Hotel("H1", "Grand Hotel", "Almaty", null))
                .setRoom(room)
                .setCustomer(customer)
                .setDates(checkIn, checkOut)
                .setTotalPrice(total)
                .build();

        bookingManager.notifyObservers("A reservation for the " + customer + " has been created");
        return booking;
    }
}