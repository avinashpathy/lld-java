// This code covers inheritance topic.

public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int speed, CarType type, int batteryCapacity) {
        super(brand, model, speed, type);
        this.batteryCapacity = batteryCapacity;
    }

    public void getBatteryCapacity(){
        System.out.println("Car "+ getBrand() + " "+ getModel() + " "+ "has " + batteryCapacity + " battery capacity.");
    }

   @Override
    public void getDetails(){
        System.out.println("Electric Car is of brand "+ getBrand() + " and of model "+ getModel());
    }

    public static void main(String[] args){
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 100, CarType.SUV, 80);
        tesla.getBatteryCapacity();
        tesla.getDetails();
    }
}