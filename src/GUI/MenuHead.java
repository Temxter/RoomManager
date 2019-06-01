package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHead extends JFrame {
    private JButton exitButton;
    private JButton hierarchyButton;
    private JButton dynamicButton;
    private JButton InfoDepartmentButton;
    private JButton CreateDocButton;
    private JPanel MenuHead;

    public MenuHead() {
        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Меню");
        add(MenuHead);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exitButton.addActionListener(e -> {
            dispose();
        });
    }

    public void buttonHierarchyAction(ActionListener listener)
    {
        hierarchyButton.addActionListener(listener);
    }
    public void buttonDynamicAction(ActionListener listener)
    {
        dynamicButton.addActionListener(listener);
    }
    public void buttonInfoDepartmentAction(ActionListener listener)
    {
        InfoDepartmentButton.addActionListener(listener);
    }
    public void buttonCreateDocAction(ActionListener listener)
    {
        CreateDocButton.addActionListener(listener);
    }
}
