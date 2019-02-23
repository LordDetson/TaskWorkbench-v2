package GUI.mainFrameAction;

import GUI.exception.GuiException;
import dao.connection.ConnectionFactory;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class MainFrameAction implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            DialogClosing.dialogClosing();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
