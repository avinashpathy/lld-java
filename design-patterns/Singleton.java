/* 
What Singleton is: a creational pattern that ensures a class has only one instance and exposes a global access point to it. 

Core idea:

Prevent others from creating objects (private constructor).

Hold a single static instance.

Expose a getInstance() method. 

    It walks through 7 common Java implementations:

    Lazy initialization (not thread-safe)

    Thread-safe with synchronized

    Double-checked locking with volatile

    Eager initialization

    Bill Pugh (static inner helper class)

    Static block initialization

    Enum singleton 

Then it lists real-world uses like loggers, DB connection pools, caches, thread pools, file system, print spooler, etc., and discusses pros/cons: global access & controlled lifecycle vs global state, testability and tight coupling concerns. 


🧱 1. Lazy Initialization (❌ not thread-safe)

Creates the instance only when it’s first requested.

*/

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        if (instance == null) {              // not thread-safe
            instance = new LazySingleton();
        }
        return instance;
    }
}

/*

Simple, lazy-loaded.

But in multithreaded code, two threads could create two instances.

🔒 2. Thread-Safe Singleton (synchronized)

Adds synchronized to make getInstance() safe in multithreaded environments. 
*/

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() { }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

/*

Thread-safe, but every call pays the cost of synchronization.

⚡ 3. Double-Checked Locking (volatile)

Reduces synchronization overhead by synchronizing only on first initialization and using volatile. 

If the first check (instance == null) passes, we synchronize on the class object.
We check the same condition one more time because multiple threads may have passed the first check.
The instance is created only if both checks pass.

*/

public class DCLSingleton {
    private static volatile DCLSingleton instance;

    private DCLSingleton() { }

    public static DCLSingleton getInstance() {
        if (instance == null) {                      // first check
            synchronized (DCLSingleton.class) {
                if (instance == null) {              // second check
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}

/*

Lazy + thread-safe + better performance than fully synchronized.

More complex and easy to get wrong if you forget volatile.

🚀 4. Eager Initialization

Instance created when class is loaded; inherently thread-safe. 

*/

public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() { }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

/*
Simple & thread-safe.

But not lazy – instance is created even if never used.

🧩 5. Bill Pugh Singleton (Inner Static Helper)

Uses a static inner class that holds the instance; loaded only when needed. 

*/

public class BillPughSingleton {

    private BillPughSingleton() { }

    // Inner static helper class
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/*

Lazy and thread-safe without explicit synchronization.

Very clean and efficient; the article calls this a great balance of simplicity + performance. 


🧱 6. Static Block Initialization

Like eager initialization, but with a static block so you can handle exceptions. 

*/

public class StaticBlockSingleton {
    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Error creating singleton", e);
        }
    }

    private StaticBlockSingleton() { }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}

/*

Thread-safe, allows handling initialization errors.

Still not lazy.

🏆 7. Enum Singleton

Uses Java enum, which the JVM guarantees is single-instance per constant, even with serialization and reflection. 
*/


public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something with EnumSingleton");
    }
}

/*

Usage:

EnumSingleton.INSTANCE.doSomething();


Very concise and robust.

Recommended by Joshua Bloch as the best Singleton implementation in Java. 


Downside: less flexible if you need inheritance or strict lazy behavior.

🌍 Real-world usage (from the article)

Good places to use Singletons: 


Logger (one central logging facility)

DB connection pool (single pool shared across app)

Cache manager

Thread pool

File system abstraction

Print spooler / job manager

⚖️ Pros & Cons (in short)

Pros 


Single, controlled instance.

Global access point.

Good for shared resources (pools, caches, loggers).

Cons

Introduces global state – can make code harder to reason about.

Can hurt testability (harder to mock/replace).

Can encourage tight coupling if overused.

https://www.youtube.com/watch?v=EZDeEHXUf8w
https://medium.com/@thecodebean/singleton-design-pattern-implementation-in-java-1fba4ecc959f

*/


// ===================TypeScript Code ===========================

/*

1. Eager Initialization Singleton — TypeScript
✔ Instance is created immediately when the class is loaded
✔ Thread-safety is not a concern in TypeScript/Node.js because it’s single-threaded
class EagerSingleton {
  // Eager: instance created immediately
  private static readonly instance: EagerSingleton = new EagerSingleton();

  private constructor() {}

  public static getInstance(): EagerSingleton {
    return EagerSingleton.instance;
  }

  sayHello() {
    console.log("Hello from Eager Singleton!");
  }
}

// Usage
const s1 = EagerSingleton.getInstance();
const s2 = EagerSingleton.getInstance();

console.log(s1 === s2); // true

🧠 Explanation

As soon as the class is evaluated by JavaScript/TypeScript runtime, the static field is initialized.

Since Node.js / JS runtime is single-threaded, this pattern is automatically safe.

Similar to Java eager singleton.

🐢 2. Lazy Initialization Singleton — TypeScript
✔ Instance created only when needed
❗ JS/TS is single-threaded, so no race condition
class LazySingleton {
  private static instance: LazySingleton | null = null;

  private constructor() {}

  public static getInstance(): LazySingleton {
    if (LazySingleton.instance === null) {
      LazySingleton.instance = new LazySingleton();
    }
    return LazySingleton.instance;
  }

  sayHello() {
    console.log("Hello from Lazy Singleton!");
  }
}

// Usage
const a = LazySingleton.getInstance();
const b = LazySingleton.getInstance();

console.log(a === b); // true

🧠 Explanation

Instance is created only when getInstance() is called for the first time.

No need for synchronization in JS/TS because event loop is single-threaded.

*/