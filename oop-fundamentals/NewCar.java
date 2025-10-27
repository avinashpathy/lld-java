// This code is written to cover the abstract class topic (since the Car class is used to cover the interface topic).
public class NewCar extends Engine {
    private String brand;
    private String model;
    private int speed;
    private NewCarType type;
    
    public enum NewCarType {
        SEDAN,
        SUV,
        HATCHBACK
    };
    
    public NewCar(String brand, String model, int speed, NewCarType type){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.type = type;
    }
    
    public void getDetails(){
        System.out.println("NewCar is of brand "+ brand + " and of model "+ model + " and of type "+ type);
    }

    public void startEngine(){
        System.out.println("NewCar engine started...");
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public static void main(String[] args){
        NewCar obj = new NewCar("Audi", "Q3", 120, NewCarType.SUV);
        obj.getDetails();
        System.out.println(obj.getSpeed());
        obj.startEngine();
        obj.stopEngine();
    }
}
