package strategy;

public class PremiumPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double basePrice, long nights) {
        return basePrice * nights * 0.85; //15% скидка
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid with premium discount: " + amount + " USD");
    }
}