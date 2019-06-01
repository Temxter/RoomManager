package GUI;

import javax.swing.*;
import java.awt.*;

public class Messages {
    static String InputDepartment(Component frame){
        String depName = (String) JOptionPane.showInputDialog(
                frame,
                "Имя подразделения: ",
                "Информация о подразделении",
                JOptionPane.PLAIN_MESSAGE,
                null, null, ""
        );
        return depName;
    }
}
