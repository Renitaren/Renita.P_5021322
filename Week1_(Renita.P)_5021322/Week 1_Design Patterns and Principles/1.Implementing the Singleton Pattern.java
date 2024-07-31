
class Logger {
    private static Logger instance;
    
    private Logger() {
        // private constructor
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

public class SingletonPatternTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.log("First log message.");
        logger2.log("Second log message.");
        
        System.out.println(logger1 == logger2);  // Should print true
    }
}