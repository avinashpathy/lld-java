/*
Definition:
High-level modules should not depend on low-level modules.
Both should depend on abstractions (interfaces).

Abstractions should not depend on details.
Details should depend on abstractions.

In simple words:

Don’t hardcode dependencies between classes.

Instead, depend on interfaces or abstractions so that the code is flexible and testable.

Without DIP (Bad Design)

Let’s say Motorcycle directly depends on a concrete class PetrolEngine:

// Low-level module (detail)
class PetrolEngine {
    public void start() {
        System.out.println("Petrol engine started!");
    }
}

// High-level module
class Motorcycle {
    private PetrolEngine engine; // ❌ depends on concrete class

    public Motorcycle() {
        this.engine = new PetrolEngine(); // ❌ tightly coupled
    }

    public void start() {
        engine.start();
        System.out.println("Motorcycle started running!");
    }
}

public class Main {
    public static void main(String[] args) {
        Motorcycle bike = new Motorcycle();
        bike.start();
    }
}

Problem:

Motorcycle is tightly coupled to PetrolEngine.

If we introduce an ElectricEngine, we must modify the Motorcycle class.

This violates Open/Closed and Dependency Inversion principles.
*/

// With DIP

// 1️⃣ Abstraction
interface Engine {
    void start();
}

// 2️⃣ Concrete Implementations
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine started!");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started silently!");
    }
}

// 3️⃣ High-level module depends on abstraction, not concrete class
class Motorcycle {
    private Engine engine;  // ✅ depends on interface, not implementation

    public Motorcycle(Engine engine) {  // ✅ dependency injected
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Motorcycle started running!");
    }
}

// 4️⃣ Main
public class Main {
    public static void main(String[] args) {
        // We can swap the engine anytime — no Motorcycle code change
        Engine petrol = new PetrolEngine();
        Engine electric = new ElectricEngine();

        Motorcycle bike1 = new Motorcycle(petrol);
        bike1.start();

        Motorcycle bike2 = new Motorcycle(electric);
        bike2.start();
    }
}

/*
The high-level module (Motorcycle) doesn’t depend on concrete engine types.

It depends on an abstraction (Engine interface).

Concrete implementations (PetrolEngine, ElectricEngine) depend on that abstraction too.

You can extend functionality (e.g., add HybridEngine) without modifying existing code.

*/

