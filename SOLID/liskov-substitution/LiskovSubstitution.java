/*Objects of a superclass should be replaceable with objects of its subclass without breaking the program.

In simpler words:
If class B is a subclass of A, then we should be able to use B anywhere we use A, without changing the correctness or behavior of the program.

Ex- If Motorcycle and Bicycle are both subclasses of Bike, they should behave consistently wherever a Bike object is expected — no surprises or exceptions.

Without LSP

class Bike {
    public void startEngine() {
        System.out.println("Engine started!");
    }
}

class Motorcycle extends Bike {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started!");
    }
}

class Bicycle extends Bike {
    // ❌ Bicycles don't have engines
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Bicycles don't have engines!");
    }
}

public class Main {
    public static void main(String[] args) {
        Bike bike1 = new Motorcycle();
        Bike bike2 = new Bicycle();  // substitution problem

        bike1.startEngine();  // ✅ Works
        bike2.startEngine();  // ❌ Throws exception — violates LSP
    }
}

👉 Problem:

Bicycle cannot logically perform startEngine(),
yet it’s forced to because it extends Bike.

Substituting Bicycle where a Bike is expected breaks the logic — LSP violated.

*/

// Vehicles with engines implement this
interface EngineVehicle {
    void startEngine();
}

// Bike is now just a general class
class Bike {
    public void pedal() {
        System.out.println("Pedaling the bike...");
    }
}

// Motorcycle HAS an engine → implements EngineVehicle
class Motorcycle extends Bike implements EngineVehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started!");
    }
}

// Bicycle DOES NOT have an engine → no startEngine()
class Bicycle extends Bike {
    @Override
    public void pedal() {
        System.out.println("Bicycle pedaling...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using EngineVehicle abstraction
        EngineVehicle v1 = new Motorcycle();
        v1.startEngine();   // ✅ Works safely for all EngineVehicle types
        
        // Using Bike abstraction
        Bike v2 = new Bicycle();
        v2.pedal();         // ✅ Works safely
        
        // No situation where Bicycle is forced to startEngine()
    }
}
