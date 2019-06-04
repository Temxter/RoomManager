package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChooseChangeOrDeleteDepartmentOrRoom extends JFrame {
    private JButton buttonCreate;
    private JButton buttonBack;
    private JComboBox comboBoxRoomsOrDepartments;
    private JButton buttonDelete;
    private JButton buttonChange;
    private JPanel panel;

    public ChooseChangeOrDeleteDepartmentOrRoom() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Редактирование");
        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonBack.addActionListener(e -> {
            dispose();
        });
    }

    public void buttonCreateAction(ActionListener listener) {
        buttonCreate.addActionListener(listener);
    }
    public void buttonChangeAction(ActionListener listener){
        buttonChange.addActionListener(listener);
    }
    public void buttonDeleteAction(ActionListener listener){
        buttonDelete.addActionListener(listener);
    }
    public void setComboBoxItem(String item){
        comboBoxRoomsOrDepartments.addItem(item);
    }
    public String getSelectedItemComboBox(){
        return (String)comboBoxRoomsOrDepartments.getSelectedItem();
    }
}