// StrategyPatternExample.java

// Step 2: Define Strategy Interface

// Create an interface PaymentStrategy with a method pay()
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies

// Create a class CreditCardPayment that implements PaymentStrategy
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolderName);
    }
}

// Create a class PayPalPayment that implements PaymentStrategy
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
        System.out.println("Email: " + email);
    }
}

// Step 4: Implement Context Class

// Create a class PaymentContext that holds a reference to PaymentStrategy and a method to execute the strategy
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 5: Test the Strategy Implementation

// Test class to demonstrate selecting and using different payment strategies
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create a payment strategy for Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        
        // Create a payment strategy for PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");

        // Create context and set the strategy to Credit Card
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        System.out.println("Using Credit Card Payment:");
        paymentContext.executePayment(100.0);

        // Change strategy to PayPal
        paymentContext = new PaymentContext(payPalPayment);
        System.out.println("\nUsing PayPal Payment:");
        paymentContext.executePayment(200.0);
    }
}
