package data;

public class Room {
    private int id;
    private String typeOfRoom;
    private double square;
    private int departmentID;

    public Room(int id, String typeOfRoom, double square, int departmentID) {
        this.id = id;
        this.typeOfRoom = typeOfRoom;
        this.square = square;
        this.departmentID = departmentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
