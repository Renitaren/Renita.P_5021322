interface PaymentProcessor {
    void processPayment();
}

class PayPal {
    public void sendPayment() {
        System.out.println("Processing payment through PayPal.");
    }
}

class Stripe {
    public void makePayment() {
        System.out.println("Processing payment through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment() {
        payPal.sendPayment();
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment() {
        stripe.makePayment();
    }
}

public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPal());
        paypal.processPayment();

        PaymentProcessor stripe = new StripeAdapter(new Stripe());
        stripe.processPayment();
    }
}
