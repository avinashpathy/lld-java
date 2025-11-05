/*
Definition:
No client should be forced to depend on methods it does not use.

✅ In simple terms:
Instead of one large interface, create smaller, more specific interfaces so classes only implement what they actually need.

Without ISP

// ❌ One big interface for all types of bikes
interface Bike {
    void accelerate();
    void startEngine();   // Not all bikes have engines
    void stopEngine();    // Not all bikes have engines
}

class Bicycle implements Bike {
    @Override
    public void accelerate() {
        System.out.println("Bicycle accelerating with pedals!");
    }

    // ❌ Bicycles don’t have engines — but are forced to implement these
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Bicycle doesn’t have an engine!");
    }

    @Override
    public void stopEngine() {
        throw new UnsupportedOperationException("Bicycle doesn’t have an engine!");
    }
}

class Motorcycle implements Bike {
    @Override
    public void accelerate() {
        System.out.println("Motorcycle accelerating with engine power!");
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle engine stopped!");
    }
}


Problem:

Bicycle is forced to implement startEngine() and stopEngine() — methods that make no sense for it.

Violates ISP, because classes are depending on methods they don’t use.

*/

// With ISP

// 1️⃣ Common base interface
interface Bike {
    void accelerate();
}

// 2️⃣ Specific interface for engine-powered bikes
interface EnginePowered {
    void startEngine();
    void stopEngine();
}

// 3️⃣ Bicycle implements only what it needs
class Bicycle implements Bike {
    @Override
    public void accelerate() {
        System.out.println("Bicycle accelerating with pedals!");
    }
}

// 4️⃣ Motorcycle implements both Bike and EnginePowered
class Motorcycle implements Bike, EnginePowered {
    @Override
    public void accelerate() {
        System.out.println("Motorcycle accelerating with engine power!");
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle engine stopped!");
    }
}

// 5️⃣ Main
public class Main {
    public static void main(String[] args) {
        Bike cycle = new Bicycle();
        Bike moto = new Motorcycle();

        cycle.accelerate();
        moto.accelerate();

        // ✅ Only engine-powered bikes can start/stop engine
        EnginePowered poweredBike = new Motorcycle();
        poweredBike.startEngine();
        poweredBike.stopEngine();
    }
}


/*
How this follows ISP:

Each class implements only the methods it needs.

Bicycle is not forced to deal with startEngine() or stopEngine().

Motorcycle cleanly extends its behavior by adding EnginePowered.

No unnecessary dependencies — no UnsupportedOperationException.

*/