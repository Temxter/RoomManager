package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuDepartment extends JFrame {
    private JButton infoDepartmentButton;
    private JButton buttonExit;
    private JPanel MenuDepartmentJFrame;

    public MenuDepartment() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setTitle("Меню");
        add(MenuDepartmentJFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonExit.addActionListener(e -> {
            dispose();
        });
    }

    public void buttonInfoDepartmentAction(ActionListener listener)
    {
        infoDepartmentButton.addActionListener(listener);
    }
}
