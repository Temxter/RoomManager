package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CreateDepartment extends JFrame{
    private JButton buttonBack;
    private JButton buttonCreate;
    private JPanel jPanelCreateDepartment;
    private JTextField textFieldName;
    private JTextField textFieldFullName;
    private JTextField textFieldInstrumentalName;
    private JTextField textFieldGenetiveName;

    public CreateDepartment() {
        setSize(400, 500);
        setLocationRelativeTo(null);
        setTitle("Отделение");
        add(jPanelCreateDepartment);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void buttonBackAction(ActionListener listener)
    {
        buttonBack.addActionListener(listener);
    }
    public void buttonCreateAction(ActionListener listener)
    {
        buttonCreate.addActionListener(listener);
    }
    public String textFieldGetName()
    {
        return textFieldName.getText();
    }
    public String textFieldGetFullName()
    {
        return textFieldFullName.getText();
    }
    public String textFieldGetInstrumentalName()
    {
        return textFieldInstrumentalName.getText();
    }
    public String textFieldGetGenetiveName()
    {
        return textFieldGenetiveName.getText();
    }
}
