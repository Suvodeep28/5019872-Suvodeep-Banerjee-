// Logger.java
// Step 2: Define a Singleton Class

public class Logger {
    // Private static instance of Logger
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize any resources required for logging
    }

    // Public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
