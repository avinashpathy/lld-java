// Class - blueprint or template for creating objects.
// Object -  instance of a class.
// Enum - special data type to define constant values.
// Interface - It defines a contract that specifies a set of abstract methods that a class must implement.
// Abstract classes - It is a partially implemented class - it can have both abstract methods (no body) and concrete methods (full body).
// Encapsulation - Wrapping data(fields) and methods in a single unit (class) and controlling access to them using access modifiers.
// Abstraction - Hiding implementation details and show only essential features. (interfaces and abstract classes)
// Inheritance - Inheritance allows one class to inherit fields and methods from another class using the extends keyword.
// Polymorphism - Many forms. Compile time(static binding)-> method overloading and run time (dynamic binding)-> method overriding

/* This code covers class, object, enum, interface, encapsulation, polymorphism topics. */

public class Car implements Vehicle {
    private String brand;
    private String model;
    private int speed;
    private CarType type;
    
    public enum CarType {
        SEDAN,
        SUV,
        HATCHBACK
    };
    
    public Car(String brand, String model, int speed, CarType type){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.type = type;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public void setBrand(){
        this.brand = brand;
    }
    
    public void getDetails(){
        System.out.println("Car is of brand "+ brand + " and of model "+ model + " and of type "+ type);
    }

    public void getDetails(boolean showSpeed) { // method overloading
        if (showSpeed) {
            System.out.println("Car: " + brand + " " + model + " | Speed: " + speed + " km/h");
        } else {
            System.out.println("Car: " + brand + " " + model);
        }
    }
    
    public int getSpeed() {
        return speed;
    }
    
    @Override
    public void accelerate(){
        System.out.println("Car is accelerating...");
    }
    
    @Override
    public void brake() {
        System.out.println("Car brake applied...");
    }
    
    public static void main(String[] args){
        Car obj = new Car("Audi", "Q3", 120, CarType.SUV);
        obj.getDetails();
        System.out.println(obj.getSpeed());
        obj.accelerate();
        obj.brake();
        System.out.println(obj.getBrand());
        obj.getDetails(true);
    }
}
