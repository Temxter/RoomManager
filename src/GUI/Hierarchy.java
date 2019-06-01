package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hierarchy extends JFrame{
    private JComboBox comboBoxDepartment;
    private JTextArea textArea;
    private JPanel panelHierarchy;

    public Hierarchy() {
        setSize(800, 500);
        setLocationRelativeTo(null);
        setTitle("Выберете отдел");
        add(panelHierarchy);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font font = new Font(null, 0, 14);
        textArea.setFont(font);
    }

    public void comboBoxAction(ActionListener listener){
        comboBoxDepartment.addActionListener(listener);
    }

    public String getSelectedDepartment() {
        return (String) comboBoxDepartment.getSelectedItem();
    }

    public void setComboBoxNameDepartment(String item){
        comboBoxDepartment.addItem(item);
    }

    public void setTextToArea(String text){
        textArea.setText(text);
    }
}
