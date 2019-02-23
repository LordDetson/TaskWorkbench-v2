package GUI.mainFrameAction;

import GUI.exception.GuiException;
import dao.connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DialogClosing {
    public static void dialogClosing() throws GuiException {

        int res = JOptionPane.showConfirmDialog(null, "Выйти из программы?");
        if (res == JOptionPane.YES_OPTION) {
            Connection connection = ConnectionFactory.getInstance();
            System.exit(WindowConstants.EXIT_ON_CLOSE);
            try {
                connection.close();
            } catch (SQLException e) {
                throw new GuiException(e);
            }
        }
    }
}
