package strategy;

public class DiscountPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double price, long nights) {
        return price * nights * 0.9; //10% скидка
    }

    @Override
    public void pay(double sum) {
        System.out.println("Paid with discount: " + sum + " USD");
    }
}