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

// With LSP

// 1️⃣ Base class for all bikes
abstract class Bike {
    public abstract void accelerate();
}

// 2️⃣ Separate interface for engine-powered bikes
interface EnginePowered {
    void startEngine();
}

// 3️⃣ Motorcycle - engine powered
class Motorcycle extends Bike implements EnginePowered {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started!");
    }

    @Override
    public void accelerate() {
        System.out.println("Motorcycle accelerating using engine power!");
    }
}

// 4️⃣ Bicycle - non-engine powered
class Bicycle extends Bike {
    @Override
    public void accelerate() {
        System.out.println("Bicycle accelerating using pedals!");
    }
}

// 5️⃣ Main class
public class Main {
    public static void main(String[] args) {
        Bike cycle = new Bicycle();
        Bike moto = new Motorcycle();

        cycle.accelerate();
        moto.accelerate();

        // ✅ Only engine-powered bikes can start engine
        EnginePowered poweredBike = new Motorcycle();
        poweredBike.startEngine();
    }
}
