package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateDoc extends JFrame{
    private JComboBox comboBoxActionWithRoom;
    private JComboBox comboBoxDepartment;
    private JComboBox comboBoxRoom;
    private JButton buttonAddPoint;
    private JButton buttonAddRoom;
    private JButton buttonFinish;
    private JButton buttonReturn;
    private JTextField textFieldDocName;
    private JTextField textFieldDate;
    private JTextArea textArea;
    private JPanel jPanelCreateDoc;

    public CreateDoc() {
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Документ");
        add(jPanelCreateDoc);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] itemsActionsWithRooms = {
                "закрепить за",
                "передать с",
        };
        Font font = new Font(null, 0, 20);
        textArea.setFont(font);
        for (String item: itemsActionsWithRooms)
            comboBoxActionWithRoom.addItem(item);
    }

    public void setComboBoxDepartment(String item){
            comboBoxDepartment.addItem(item);
    }
    public void setComboBoxRoom(String item){
            comboBoxRoom.addItem(item);
    }

    public String getSelectedItemActionWithRoom(){
        return (String)comboBoxActionWithRoom.getSelectedItem();
    }
    public String getSelectedItemDepartment(){
        return (String)comboBoxDepartment.getSelectedItem();
    }
    public String getSelectedItemRoom(){
        return (String)comboBoxRoom.getSelectedItem();
    }

    public void buttonAddPointAction(ActionListener listener)
    {
        buttonAddPoint.addActionListener(listener);
    }
    public void buttonAddRoomAction(ActionListener listener)
    {
        buttonAddRoom.addActionListener(listener);
    }
    public void buttonFinishAction(ActionListener listener)
    {
        buttonFinish.addActionListener(listener);
    }

    public void buttonReturnAction(ActionListener listener)
    {
        buttonReturn.addActionListener(listener);
    }

    public void addTextToArea(String addText){
        textArea.append(addText);
    }

    public String getTextArea(){
        return textArea.getText();
    }
    public String getTextDocName(){
        return textFieldDocName.getText();
    }
    public String getTextFieldDate(){
        return textFieldDate.getText();
    }

}
