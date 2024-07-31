// AdapterPatternExample.java

// Step 2: Define Target Interface

// Create an interface PaymentProcessor with methods like processPayment()
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Implement Adaptee Classes

// Create classes for different payment gateways with their own methods

// PayPal payment gateway with its own method
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// Stripe payment gateway with its own method
class Stripe {
    public void executePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Step 4: Implement the Adapter Class

// Create an adapter class for PayPal that implements PaymentProcessor
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

// Create an adapter class for Stripe that implements PaymentProcessor
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.executePayment(amount);
    }
}

// Step 5: Test the Adapter Implementation

// Test class to demonstrate the use of different payment gateways through the adapter
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();

        // Create adapters for the payment gateways
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Process payments using the adapters
        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }
}

