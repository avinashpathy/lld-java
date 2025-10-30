class Room {
    private String name;
    
    public Room(String name){
        this.name = name;
    }

    public void getRoom(){
        System.out.println("This is the "+ name);
    }
}