// Driver drives Car. Both driver and car can exist independently.
// Association represents a relationship between two or more classes where one object “uses” another object.
// It shows how objects are connected logically but each object can exist independently.

// Example:
// A Driver drives a Car, but both Driver and Car can exist separately.

class Association {
    public static void main(String[] args){
        Car car = new Car("Hyundai", "Venue", 100, Car.CarType.SUV);
        Driver driver = new Driver("Avinash");
        driver.drive(car);
    }
}