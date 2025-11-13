package strategy;

public class RegularPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double price, long nights) {
        return price * nights;
    }

    @Override
    public void pay(double sum) {
        System.out.println("Paid: " + sum + " KZT");
    }
}