public class LoggerThreadSafeSingleton {

    // We have made this particular instance as volatile. 
    // volatile is a keyword in java which makes the changes or threads which are accessing this particular variable visible.
    private static volatile LoggerThreadSafeSingleton instance;

    private LoggerThreadSafeSingleton(){
        if(instance != null){
            throw new RuntimeException("Instance already created");
        }
    }

    public static LoggerThreadSafeSingleton getInstance() {
      if (instance == null) { // Double checked singleton
            // Synchronize on the class object
            synchronized (LoggerThreadSafeSingleton.class) {
                // Second check (synchronized)
                if (instance == null) {
                    instance = new LoggerThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        LoggerThreadSafeSingleton obj1 = LoggerThreadSafeSingleton.getInstance();
        System.out.println(obj1);
        LoggerThreadSafeSingleton obj2 = LoggerThreadSafeSingleton.getInstance();
        System.out.println(obj2);
    }
}