import java.util.*;

class House {
    private List<Room>rooms;

    public House(List<Room>rooms){
        this.rooms = rooms;
    }

    public void showHouse(){
        for(Room room: rooms){
            room.getRoom();
        }
    }
}