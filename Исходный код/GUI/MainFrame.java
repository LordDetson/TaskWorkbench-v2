package GUI;

import GUI.exception.GuiException;
import GUI.mainFrameAction.MainFrameAction;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Dimension frameSize = new Dimension(1080, 720);
    public static final Rectangle rectSizeAndPosition = new Rectangle(
            (int) (screenSize.getWidth() / 2 - frameSize.getWidth() / 2),
            (int) (screenSize.getHeight() / 2 - frameSize.getHeight() / 2),
            (int) frameSize.getWidth(),
            (int) frameSize.getHeight());

    public MainFrame(String title) throws HeadlessException, GuiException {
        super(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainFrameAction());

        new AuthorizationForm(this, "Окно авторизации", true, screenSize);
    }
}
