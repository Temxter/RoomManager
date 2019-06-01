package data;

public class DocumentExtension {
    int idDocument;
    int idRoom;
    int idToDepartment;
    int idFromDepartment;
    String date;

    public DocumentExtension(int idDocument, int idRoom, int idToDepartment, int idFromDepartment, String date) {
        this.idDocument = idDocument;
        this.idRoom = idRoom;
        this.idToDepartment = idToDepartment;
        this.idFromDepartment = idFromDepartment;
        this.date = date;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdToDepartment() {
        return idToDepartment;
    }

    public void setIdToDepartment(int idToDepartment) {
        this.idToDepartment = idToDepartment;
    }

    public int getIdFromDepartment() {
        return idFromDepartment;
    }

    public void setIdFromDepartment(int idFromDepartment) {
        this.idFromDepartment = idFromDepartment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
