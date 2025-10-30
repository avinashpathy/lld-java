/*

A Dependency exists when one class relies on another to fulfill a responsibility, but does so without retaining a permanent reference to it.

This typically happens when:

A class accepts another class as a method parameter.
A class instantiates or uses another class inside a method.
A class returns an object of another class from a method.
If class A uses class B just to perform a task, not to store or own, that’s a dependency.

Key Characteristics of Dependency
Short-lived: The relationship exists only during method execution.
No ownership: The dependent class does not store the other as a field.
"Uses-a" relationship: The class uses another to accomplish a task, but does not retain it.

Real-World Analogy
Imagine a Chef preparing a meal.

The chef picks up a Knife to chop vegetables.
Once the chopping is done, the knife is put away or reused elsewhere.
The chef doesn’t necessarily own the knife or keep it stored long-term.
This represents a dependency. The chef depends on the knife only during the cooking process.

Example - 

Car depends on FuelPump for refueling.

The relationship is temporary — the FuelPump object is passed only when needed.

If the FuelPump changes, Car might also need changes — hence the dependency.
*/

public static void main(String[] args) {
        Car car = new Car("Toyota", "Model 1", 100, Car.CarType.SUV);
        FuelPump pump = new FuelPump();

        // Dependency: Car uses FuelPump for refueling
        car.refuel(pump);
}