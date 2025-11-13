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
    private final BookingManager manager;

    public HotelBookingFacade() {   // комната, дефолт цена
        this.roomFactory = new StandardRoomFactory();
        this.paymentStrategy = new RegularPayment();
        this.manager = new BookingManager();
        manager.add(new EmailNotification());
        manager.add(new SMSNotification());
    }

    public void setRoomFactory(RoomFactory f) {
        this.roomFactory = f;
    }

    public void setPaymentStrategy(PaymentStrategy p) {
        this.paymentStrategy = p;
    }

    public Booking book(String customer, LocalDate in, LocalDate out, String... extras) {
        Room room = roomFactory.createRoom();

        for (String e : extras) {
            if (e.equalsIgnoreCase("breakfast")) room = new BreakfastDecorator(room);
            if (e.equalsIgnoreCase("wifi")) room = new WifiDecorator(room);
            if (e.equalsIgnoreCase("parking")) room = new ParkingDecorator(room);
        }

        long nights = ChronoUnit.DAYS.between(in, out);  //цена
        double total = paymentStrategy.calculateCost(room.getPrice(), nights);

        Booking.Builder builder = new Booking.Builder()
                .setHotel(new Hotel("H1", "Grand Hotel", "Almaty", null))
                .setRoom(room)
                .setCustomer(customer)
                .setDates(in, out)
                .setTotalPrice(total);

        for (String e : extras) {
            builder.addExtra(e);
        }

        Booking booking = builder.build();

        manager.send(booking, "Booking confirmed for " + customer); // уведы

        return booking;
    }
}