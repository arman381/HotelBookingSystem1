import model.*;
import factory.*;
import strategy.*;
import java.time.LocalDate;

public class HotelBookingSystem {
    public static void main(String[] args) {
        HotelBookingFacade facade = new HotelBookingFacade();

        LocalDate in = LocalDate.of(2025, 12, 1);
        LocalDate out = LocalDate.of(2025, 12, 3);

        facade.setRoomFactory(new SuiteRoomFactory());
        facade.setPaymentStrategy(new DiscountPayment());

        Booking booking = facade.book("Alice", in, out, "wifi", "breakfast");

        System.out.println(booking);
    }
}