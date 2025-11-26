// Eager Initialization - Instance is created immediately when the class is loaded
public class LoggerEagerInitializationSingleton {
    private static LoggerEagerInitializationSingleton instance = new LoggerEagerInitializationSingleton();

    private LoggerEagerInitializationSingleton(){
    }

    public static LoggerEagerInitializationSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        LoggerEagerInitializationSingleton obj1 = LoggerEagerInitializationSingleton.getInstance();
        System.out.println(obj1);

        LoggerEagerInitializationSingleton obj2 = LoggerEagerInitializationSingleton.getInstance();
        System.out.println(obj2);
    }
}