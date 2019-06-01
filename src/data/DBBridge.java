package data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBBridge {

    Connection conn;
    Statement stmt;
    String url = "jdbc:sqlite:";
    String sql;


    public DBBridge(String dbName) {
        if (dbName == null || dbName.isEmpty()) {
            dbName = "sqlite.db";
        }
        try {
            url += dbName;
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Department> DeparmentSELECT(){
        ArrayList<Department> resultArray = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Departments;");
            while (rs.next()){
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String full_name  = rs.getString("full_name");
                String  genetive_name = rs.getString("genetive_name");
                String instrumental_name = rs.getString("instrumental_name");

                resultArray.add(new Department(id, name, full_name, genetive_name, instrumental_name));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public ArrayList<Document> DocumentsSELECT(){
        ArrayList<Document> resultArray = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Documents;");
            while (rs.next()){
                int id = rs.getInt("id");
                String  text = rs.getString("text");
                String date  = rs.getString("date");
                resultArray.add(new Document(id, text, date));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public ArrayList<DocumentExtension> DocumentsExtensionSELECT(){
        ArrayList<DocumentExtension> resultArray = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Document_extension;");
            while (rs.next()){
                int id_document = rs.getInt("id_document");
                int id_room = rs.getInt("id_room");
                int id_from_department = rs.getInt("id_from_department");
                int id_to_department = rs.getInt("id_to_department");
                String change_date  = rs.getString("change_date");
                resultArray.add(new DocumentExtension(id_document, id_room, id_to_department, id_from_department, change_date));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public ArrayList<Room> RoomsSELECT(){
        ArrayList<Room> resultArray = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Rooms;");
            while (rs.next()){
                int id = rs.getInt("id");
                String  type_of_room = rs.getString("type_of_room");
                Double square  = rs.getDouble("square");
                int Departments_id = rs.getInt("Departments_id");
                resultArray.add(new Room(id, type_of_room, square, Departments_id));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public ArrayList<User> UsersSELECT(){
        ArrayList<User> resultArray = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Users;");
            while (rs.next()){
                int id = rs.getInt("id");
                String  user_name = rs.getString("user_name");
                String password  = rs.getString("password");
                int level_access = rs.getInt("level_access");
                User user = new User(id, level_access, user_name, password);
                //System.out.println(user);
                resultArray.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public void Update(Tables table, int id, String colName, String value){
        String sql = String.format("UPDATE %s set %s = '%s' where ID=%d;", table.name(), colName, value, id);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnrty(int id, Tables table){
        String sqlExec = String.format("DELETE from %s where ID=%d;", table.name(), id);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DepartmentInsert(Department dep){
        String sql = String.format("INSERT INTO Departments(name, full_name, genetive_name, instrumental_name) VALUES ('%s','%s','%s','%s');",
                dep.getName(), dep.getFullName(), dep.getGenetiveName(), dep.getInstrumentalName());
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RoomInsert(Room room){
        String sql = String.format("INSERT INTO Rooms(type_of_room, square, Departments_id) VALUES ('%s', '%f', %d);",
                room.getTypeOfRoom(), room.getSquare(), room.getDepartmentID());
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DocumentInsert(Document doc){
        String sql = String.format("INSERT INTO Documents(text, date) VALUES ('%s','%s');",
                doc.getText(), doc.getDate());
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DocumentExtensionInsert(DocumentExtension docExt){
        String sql = String.format("INSERT INTO Document_extension(id_document, id_room, id_to_department, id_from_department, change_date) " +
                        "VALUES ('%d','%d','%d','%d' ,'%s');",
                 docExt.getIdDocument(), docExt.getIdRoom(), docExt.getIdToDepartment(), docExt.getIdFromDepartment(), docExt.getDate());
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UserInsert(User user){
        String sql = String.format("INSERT INTO Users(user_name, password, level_access) VALUES ('%s','%s', %d);",
                user.getName(), user.getPassword(), user.getLevelAccess());
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
