package GUI;

import data.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Enter extends JFrame{
    private JButton buttonEnter;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JPanel frameEnter;

    public Enter() {
        setSize(500, 200);
        setLocationRelativeTo(null);
        setTitle("Авторизация");
        add(frameEnter);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void ButtonClicked(ActionListener listener){
        buttonEnter.addActionListener(listener);
    }

    public String getPassword(){
        return new String(passwordField.getPassword());
    }

    public String getLogin(){
        return loginField.getText();
    }

    public void clearPasswordField(){
        passwordField.setText("");
    }
}
