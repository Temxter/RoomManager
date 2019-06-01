package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DynamicChangesArgs extends JFrame{
    private JButton buttonBack;
    private JButton buttonOK;
    private JComboBox comboBoxNameDepartment;
    private JTextField textFieldDate;
    private JPanel jPanelDynamicChangesArgs;
    private JTextArea textArea;

    public DynamicChangesArgs() {
        setSize(800, 800);
        setLocationRelativeTo(null);
        setTitle("Документ");
        add(jPanelDynamicChangesArgs);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font font = new Font(null, 0, 14);
        textArea.setFont(font);
    }

    public void buttonBackAction(ActionListener listener){
        buttonBack.addActionListener(listener);
    }
    public void buttonOKAction(ActionListener listener){
        buttonOK.addActionListener(listener);
    }
    public void setComboBoxNameDepartment(String item){
        comboBoxNameDepartment.addItem(item);
    }
    public String getTextFieldDate(){
        return textFieldDate.getText();
    }
    public String getSelectedItemDepartment(){
        return (String)comboBoxNameDepartment.getSelectedItem();
    }
    public void setAreaText(String text){
        textArea.setText(text);
    }
}
