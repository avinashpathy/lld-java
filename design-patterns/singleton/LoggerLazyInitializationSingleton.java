// Lazy Initialization - Creates the instance only when it’s first requested.
public class LoggerLazyInitializationSingleton {
    private static LoggerLazyInitializationSingleton instance;

    private LoggerLazyInitializationSingleton(){
    }

    public static LoggerLazyInitializationSingleton getInstance(){
        if(instance == null) {
            instance = new LoggerLazyInitializationSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LoggerLazyInitializationSingleton obj1 = LoggerLazyInitializationSingleton.getInstance();
        System.out.println(obj1);

        LoggerLazyInitializationSingleton obj2 = LoggerLazyInitializationSingleton.getInstance();
        System.out.println(obj2);
    }
}