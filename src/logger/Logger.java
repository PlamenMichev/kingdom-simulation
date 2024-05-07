package logger;

// Singleton class
public class Logger {
    private static Logger instance;

    private Logger() {}

    // Synchronized method to control simultaneous access
    public synchronized static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
