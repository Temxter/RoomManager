package Controller;

import GUI.*;
import data.*;
import javafx.collections.transformation.SortedList;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    static DBBridge dbBridge = new DBBridge(null);
    static ArrayList<User> users = dbBridge.UsersSELECT();
    static ArrayList<Department> departments = dbBridge.DeparmentSELECT();
    static ArrayList<Room> rooms = dbBridge.RoomsSELECT();
    static ArrayList<Document> documents = dbBridge.DocumentsSELECT();
    static ArrayList<DocumentExtension> documentExtensions = dbBridge.DocumentsExtensionSELECT();
    static User user = null;

    static Enter enterForm;
    static MenuHead menuHeadForm;
    static MenuDepartment menuDepartmentForm;
    static MenuRoomDepartment menuRoomDepartmentForm;
    static CreateDepartment createDepartmentForm;
    static CreateDoc createDocForm;
    static DynamicChangesArgs dynamicChangesArgsForm;
    static CreateRoom createRoomForm;
    static Hierarchy hierarchyForm;

    public void showUsersTest(){
        System.out.println(String.format("%4s|%2s|%15s|%15s", "ID", "Level access", "Name", "Password"));
        for (User val: users){
           System.out.println(String.format("%4d|%2d|%15s|%15s",
                  val.getId(), val.getLevelAccess(), val.getName(), val.getPassword()));
       }
    }

    public Controller(){}

    public void Start(){
        setLookAndFeel();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                enterForm = new Enter();
                enterForm.setVisible(true);
                enterForm.ButtonClicked(e ->{
                    enterButtonClick();
                });
            }
        });
    }

    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void enterButtonClick(){
        String login = enterForm.getLogin();
        String password = enterForm.getPassword();
        for (User val: users){
            if (login.compareTo(val.getName()) == 0){
                if((password.compareTo(val.getPassword()) == 0)){
                    user = val;
                    user.setUserAccess(UserAccess.getAccess(user.getLevelAccess()));
                    break;
                }
                break;
            }
        }
        if (user == null)
            JOptionPane.showMessageDialog(enterForm, "Неправильный логин или пароль!");
        else {
            openMenu();
            enterForm.dispose();
        }
        enterForm.clearPasswordField();
    }

    private static void openMenu(){
        switch (user.getUserAccess()){
            case Head: openMenuHead();
                break;
            case Managment:  openMenuRoomDepartment();
                //System.out.println("Access Managment!");
                break;
            case Other: openMenuDepartment();
                break;
            case NoAccess:
                System.out.println("NoAccess!");
                break;
        }
    }

    private static void openMenuDepartment(){
        if (menuDepartmentForm == null) {
            menuDepartmentForm = new MenuDepartment();
            menuDepartmentForm.setVisible(true);
        }
        else
            menuDepartmentForm.setVisible(true);
        ////TODO: fill all actions
    }
    private static void openMenuHead(){
        if (menuHeadForm == null) {
            menuHeadForm = new MenuHead();
            menuHeadForm.setVisible(true);
        }
        else
            menuHeadForm.setVisible(true);
    }
    private static void openMenuRoomDepartment(){
        if (menuRoomDepartmentForm == null) {
            menuRoomDepartmentForm = new MenuRoomDepartment();
            menuRoomDepartmentForm.setVisible(true);
        }
        else
            menuRoomDepartmentForm.setVisible(true);
        menuRoomDepartmentForm.buttonCreateDocAction(e -> {
            openCreateDocForm();
            menuRoomDepartmentForm.setVisible(false);
        });
        menuRoomDepartmentForm.buttonDynamicAction(e -> {
            openDynamicChangesArgs();
            //не надо сворачивать
        });
        menuRoomDepartmentForm.buttonHierarchyAction(e -> {
            openHierarchy();
        });

        //TODO: fill ALL actions
    }

    static int docPoints = 0;
    private static void openCreateDocForm(){
        if (createDocForm == null) {
            createDocForm = new CreateDoc();
            createDocForm.setVisible(true);
        }
        else
            createDocForm.setVisible(true);

        for (Department d: departments)
            createDocForm.setComboBoxDepartment(d.getName());
        for(Room r: rooms)
            createDocForm.setComboBoxRoom(r.getTypeOfRoom());

        //TEST


        String docName = createDocForm.getTextDocName();
        int docID = getMaxDocumentID() + 1;
        docPoints = 0;
        createDocForm.buttonAddPointAction(e -> {
            docPoints++;
            String date = createDocForm.getTextFieldDate(); //check data format!!!
            String room = createDocForm.getSelectedItemRoom();
            String actionWithRoom = createDocForm.getSelectedItemActionWithRoom();
            String department = createDocForm.getSelectedItemDepartment();
            Room newRoom = changeRoom(room, department, docID, date);


            System.out.println(docPoints + date + room + oldDepartmentName + department);
            String addToArea = null;
            if (actionWithRoom.compareTo("передать с") == 0) {
                addToArea = String.format("%d. Передать с %s помещение \"%s\", закрепленное за отделом \"%s\", отделу \"%s\"\n",
                        docPoints, date, room, oldDepartmentName, department);
                System.out.println(addToArea);
            }
            else
                addToArea = String.format("%d. С %s закрепить  помещение \"%s\" за отделом \"%s\"\n" , docPoints, room, date, department);
            createDocForm.addTextToArea(addToArea);
        });

        createDocForm.buttonFinishAction(e -> {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
            Document doc = new Document(docID, createDocForm.getTextArea(), formatForDateNow.format(date));
            documents.add(doc);
            dbBridge.DocumentInsert(doc);
            JOptionPane.showMessageDialog(null, "Документ успешно создан!");
            openMenu();
            createDocForm.dispose();
        });


        createDocForm.buttonReturnAction(e ->{
            openMenu();
            createDocForm.dispose();
        });
    }

    private static int getMaxDocumentID(){
        int maxID = 0;
        for (Document d: documents){
            if( maxID < d.getId())
                maxID = d.getId();
        }
        return maxID;
    }
    private static int getDepartmentID(String nameDepartment){
        for (Department d: departments){
            if (d.getName().compareTo(nameDepartment)==0){
                return d.getId();
            }
        }
        return -1;
    }
    private static String getDepartmentName(int IdDepartment){
        for (Department d: departments){
            if (d.getId() == IdDepartment){
                if (d.getId() == IdDepartment){
                    return d.getName();
                }
            }
        }
        return "";
    }

    static int oldDepartmentID;
    static String oldDepartmentName;
    private static Room changeRoom(String roomName, String newDepartment, int docID, String dateAccept){
        Room room = null;
        for (Room r: rooms){
            if (r.getTypeOfRoom().compareTo(roomName) == 0)
            {
                room = r;
            }
        }
        int newDepartmentID = getDepartmentID(newDepartment);
        oldDepartmentID = room.getDepartmentID(); //TODO: не очень правильно
        oldDepartmentName = getDepartmentName(oldDepartmentID); //TODO: не очень правильно ( сделано для openCreateDocForm() )
        room.setDepartmentID(newDepartmentID);
        dbBridge.Update(Tables.Rooms, room.getId(), "Departments_id", String.valueOf(room.getDepartmentID()));
        DocumentExtension documentExtension = new DocumentExtension(
                docID, room.getId(), room.getDepartmentID(), oldDepartmentID, dateAccept);
        dbBridge.DocumentExtensionInsert(documentExtension);
        return room;
    }

    private static void openDynamicChangesArgs(){
        if (dynamicChangesArgsForm == null) {
            dynamicChangesArgsForm = new DynamicChangesArgs();
            dynamicChangesArgsForm.setVisible(true);
            //формирование ComboBox
            for (Department d: departments) {
                dynamicChangesArgsForm.setComboBoxNameDepartment(d.getName());
            }
        }
        else
            dynamicChangesArgsForm.setVisible(true);

        dynamicChangesArgsForm.buttonOKAction(e -> {
            dynamicChangesArgsForm.setAreaText("");
            String date = dynamicChangesArgsForm.getTextFieldDate();
            String department = dynamicChangesArgsForm.getSelectedItemDepartment();
            ArrayList<Room> roomsOnDate = roomsOnDate(department, date);
            StringBuilder outText = new StringBuilder();
            for (Room r: roomsOnDate)
                outText.append(String.format("Помещение \"%s\" №%d, площадь %.2f м^2\n", r.getTypeOfRoom(), r.getId(), r.getSquare()));
            dynamicChangesArgsForm.setAreaText(outText.toString());
        });

        dynamicChangesArgsForm.buttonBackAction(e -> {
            openMenu();
            dynamicChangesArgsForm.dispose();
        });
    }

    //Плохой алгоритм вычисления помещений для заданного отдела от нынешнего времени до заданного
    private static ArrayList<Room> roomsOnDate(String department, String date){
        int departmentID = getDepartmentID(department);
        ArrayList<DocumentExtension> localDocExtArray = new ArrayList<>();

        //вычисление всех комнат, которые были добавлены и удалены относительного данного отдела
        for (DocumentExtension de: documentExtensions){
            if (de.getIdFromDepartment() == departmentID || de.getIdToDepartment() == departmentID)
                if (dateCompare(de.getDate(), date) < 0){
                    localDocExtArray.add(de);
                }
        }
        //сортировака по убыванию даты
        localDocExtArray.sort((a,b) -> dateCompare(b.getDate(),a.getDate()));
        ArrayList<Room> localRoomArray = new ArrayList<>();
        ArrayList<Integer> roomsIDs = new ArrayList<>();
        //добавление всех комнат принадлежащих отделу
        for (Room r: rooms){
            if (r.getDepartmentID() == departmentID)
                roomsIDs.add(r.getId());
        }
        for (DocumentExtension de: localDocExtArray){
            if (de.getIdToDepartment() == de.getIdFromDepartment())
                continue;
            if (de.getIdToDepartment() == departmentID) //если помещение было добавлено к отделению, то удаляем (пока не дойдем до заданной даты)
                //попытка удаления
                try {
                    roomsIDs.remove(de.getIdRoom());
                } catch (Exception e) {
                    e.getStackTrace();
                }
            else
                roomsIDs.add(de.getIdRoom());
        }
        for (Room r: rooms)
            for (int rID: roomsIDs)
                if (r.getId() == rID)
                    localRoomArray.add(r);
        return localRoomArray;
    }

    private static void openHierarchy(){
        if (hierarchyForm == null) {
            hierarchyForm = new Hierarchy();
            hierarchyForm.setVisible(true);
            //формирование comboBox
            for( Department d: departments)
                hierarchyForm.setComboBoxNameDepartment(d.getName());
        }
        else
            hierarchyForm.setVisible(true);


        hierarchyForm.comboBoxAction(e ->{
            String department = hierarchyForm.getSelectedDepartment();
            int departmentID = getDepartmentID(department);
            StringBuilder outText = new StringBuilder();
            for (Room r: rooms){
                if (r.getDepartmentID() == departmentID)
                    outText.append(String.format("Помещение \"%s\" №%d, площадь %.2f м^2\n", r.getTypeOfRoom(), r.getId(), r.getSquare()));
            }
            hierarchyForm.setTextToArea(outText.toString());
        });
    }

    private static void openCreateDepartmentForm(){
        if (createDepartmentForm == null) {
            createDepartmentForm = new CreateDepartment();
            createDepartmentForm.setVisible(true);
        }
        createDepartmentForm.buttonBackAction(e -> {
            createDepartmentForm.dispose();
        });
        createDepartmentForm.buttonCreateAction(e -> {
            String name = createDepartmentForm.textFieldGetName();
            String fullName = createDepartmentForm.textFieldGetFullName();
            String genetiveName = createDepartmentForm.textFieldGetGenetiveName();
            String instrumentalName = createDepartmentForm.textFieldGetInstrumentalName();
            Department newDepartment = new Department(-1, name, fullName, genetiveName, instrumentalName);
            addOrEditDepartment(newDepartment);
        });
    }

    private static void addOrEditDepartment(Department newDepart){
        boolean exist = false;
        int id = -1;
        for (Department depart: departments){
            if (depart.getName().compareTo(newDepart.getName()) == 0) {
                id = depart.getId();
                depart = newDepart;
                depart.setId(id);
                exist = true;
                break;
            }
        }
        if (exist == false){
            dbBridge.DepartmentInsert(newDepart);
        }
        else {
            dbBridge.Update(Tables.Departments, id, "name", newDepart.getName());
            dbBridge.Update(Tables.Departments, id, "full_name", newDepart.getFullName());
            dbBridge.Update(Tables.Departments, id, "genetive_name", newDepart.getGenetiveName());
            dbBridge.Update(Tables.Departments, id, "instrumental_name", newDepart.getInstrumentalName());
        }
    }

    private static void addNewDocument(Document newDoc, ArrayList<DocumentExtension> newDocExtList){
        dbBridge.DocumentInsert(newDoc);
        documentExtensions.addAll(newDocExtList);
        for (DocumentExtension newDocExt: newDocExtList) {
            dbBridge.DocumentExtensionInsert(newDocExt);
        }
    }

    private static boolean isDateCorrect(String date){
        //TODO check + out messageBox if false
        return true;
    }

    private static int dateCompare(String sDate1, String sDate2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null, date2 = null;
        if (sDate1.isEmpty())
            return -1;
        if(sDate2.isEmpty())
            return 1;
        try {
           // System.out.println(sDate1 + sDate2);
            date1 = sdf.parse(sDate1);
            date2 =  sdf.parse(sDate2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        return date1.compareTo(date2);
    }
}
