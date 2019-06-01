package GUI;

import javax.swing.*;

public class CreateRoom extends JFrame {
    private JButton buttonOK;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton buttonReturn;
    private JPanel jFrameCreateRoom;

    public CreateRoom() {
        setSize(400, 500);
        setLocationRelativeTo(null);
        setTitle("Документ");
        add(jFrameCreateRoom);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
