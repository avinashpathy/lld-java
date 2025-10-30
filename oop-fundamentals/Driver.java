class Driver {
    private String name;

    public Driver(String name){
        this.name = name;
    }

    public void drive(Car car){
        System.out.println(name+" is driving the car "+ car.getBrand()+ " "+ car.getModel() );
    }
}