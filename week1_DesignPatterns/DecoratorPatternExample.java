// DecoratorPatternExample.java

// Step 2: Define Component Interface

// Create an interface Notifier with a method send()
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component

// Create a class EmailNotifier that implements Notifier
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Step 4: Implement Decorator Classes

// Create an abstract decorator class NotifierDecorator that implements Notifier and holds a reference to a Notifier object
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Create a concrete decorator class SMSNotifierDecorator that extends NotifierDecorator
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Create a concrete decorator class SlackNotifierDecorator that extends NotifierDecorator
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackNotification(message);
    }

    private void sendSlackNotification(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}

// Step 5: Test the Decorator Implementation

// Test class to demonstrate sending notifications via multiple channels using decorators
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate email notifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate email notifier with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        // Decorate email notifier with both SMS and Slack functionalities
        Notifier combinedNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a message using the different notifiers
        System.out.println("Using Email Notifier:");
        emailNotifier.send("Hello, World!");

        System.out.println("\nUsing SMS Notifier:");
        smsNotifier.send("Hello, World!");

        System.out.println("\nUsing Slack Notifier:");
        slackNotifier.send("Hello, World!");

        System.out.println("\nUsing Combined Notifier (SMS + Slack):");
        combinedNotifier.send("Hello, World!");
    }
}
