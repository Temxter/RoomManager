package GUI;

import javax.swing.*;
import java.awt.*;

public class Messages {
    public static String InputDepartment(Component frame){
        String depName = (String) JOptionPane.showInputDialog(
                frame,
                "Имя подразделения: ",
                "Информация о подразделении",
                JOptionPane.PLAIN_MESSAGE,
                null, null, ""
        );
        return depName;
    }
    public static void infoMessage(Component frame, String message, String title){
        JOptionPane.showInputDialog(
                frame,
                "Имя подразделения: ",
                "Информация о подразделении",
                JOptionPane.INFORMATION_MESSAGE,
                null, null, "");
    }
}
