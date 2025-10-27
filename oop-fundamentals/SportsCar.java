// This code covers polymorphism method overriding concept (getDetails function overrriden)

public class SportsCar extends Car {
    private int batteryCapacity;

    public SportsCar(String brand, String model, int speed, CarType type, int batteryCapacity) {
        super(brand, model, speed, type);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void getDetails(){ // method overriding
        System.out.println("Sports Car is of brand "+ getBrand() + " and of model "+ getModel());
    }

    public void getBatteryCapacity(){
        System.out.println("Car "+ getBrand() + " "+ getModel() + " "+ "has " + batteryCapacity + " battery capacity.");
    }

    public static void main(String[] args){
        SportsCar tesla = new SportsCar("Ferrari", "Model 1", 100, CarType.SUV, 80);
        tesla.getDetails();
    }
}