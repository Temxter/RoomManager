package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRoomDepartment extends JFrame{
    private JButton buttonExit;
    private JButton buttonCreateDoc;
    private JButton buttonHierarchy;
    private JButton InfoDepartmentButton;
    private JButton dynamicButton;
    private JButton buttonEditUsers;
    private JButton buttonEditDepartments;
    private JButton buttonEditRooms;
    private JPanel MenuRoomDepartmentJPanel;

    public MenuRoomDepartment() {
        setSize(800, 500);
        setLocationRelativeTo(null);
        setTitle("Меню");
        add(MenuRoomDepartmentJPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonExit.addActionListener(e -> {
            dispose();
        });
    }

    public void buttonHierarchyAction(ActionListener listener)
    {
        buttonHierarchy.addActionListener(listener);
    }
    public void buttonInfoDepartmentAction(ActionListener listener)
    {
        InfoDepartmentButton.addActionListener(listener);
    }

    public void buttonDynamicAction(ActionListener listener)
    {
        dynamicButton.addActionListener(listener);
    }
    public void buttonEditUsersAction(ActionListener listener)
    {
        buttonEditUsers.addActionListener(listener);
    }
    public void buttonEditRoomsAction(ActionListener listener)
    {
        buttonEditRooms.addActionListener(listener);
    }
    public void buttonEditDepartmentsAction(ActionListener listener) {
        buttonEditDepartments.addActionListener(listener);
    }
    public void buttonCreateDocAction(ActionListener listener)
    {
        buttonCreateDoc.addActionListener(listener);
    }
 }
