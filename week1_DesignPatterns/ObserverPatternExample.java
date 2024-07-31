// ObserverPatternExample.java

import java.util.ArrayList;
import java.util.List;

// Step 2: Define Subject Interface

// Create an interface Stock with methods to register, deregister, and notify observers
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Step 3: Implement Concrete Subject

// Create a class StockMarket that implements Stock and maintains a list of observers
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 4: Define Observer Interface

// Create an interface Observer with a method update()
interface Observer {
    void update(String stockName, double stockPrice);
}

// Step 5: Implement Concrete Observers

// Create a class MobileApp that implements Observer
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp: Stock " + stockName + " updated to $" + stockPrice);
    }
}

// Create a class WebApp that implements Observer
class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp: Stock " + stockName + " updated to $" + stockPrice);
    }
}

// Step 6: Test the Observer Implementation

// Test class to demonstrate the registration and notification of observers
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a StockMarket instance
        StockMarket stockMarket = new StockMarket("AAPL");

        // Create observer instances
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        System.out.println("Updating stock price to $150.00:");
        stockMarket.setStockPrice(150.00);

        // Deregister an observer
        stockMarket.deregisterObserver(mobileApp);

        // Change stock price again and notify remaining observers
        System.out.println("\nUpdating stock price to $155.00:");
        stockMarket.setStockPrice(155.00);
    }
}
