interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment made using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment made using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment() {
        strategy.pay();
    }
}

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment();

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment();
    }
}
