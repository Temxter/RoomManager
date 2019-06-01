package data;

import java.util.ArrayList;

public class Department {
    private int id;
    private String name, fullName, genetiveName, instrumentalName;
    private ArrayList<Room> rooms;

    public Department() {
        rooms = new ArrayList<>();
    }

    public Department(int id, String name, String fullName, String genetiveName, String instrumentalName) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.genetiveName = genetiveName;
        this.instrumentalName = instrumentalName;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenetiveName() {
        return genetiveName;
    }

    public void setGenetiveName(String genetiveName) {
        this.genetiveName = genetiveName;
    }

    public String getInstrumentalName() {
        return instrumentalName;
    }

    public void setInstrumentalName(String instrumentalName) {
        this.instrumentalName = instrumentalName;
    }
}
