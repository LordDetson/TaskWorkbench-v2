package GUI;

import GUI.buttomListener.login.LoginListener;
import GUI.exception.GuiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AuthorizationForm extends JDialog {
    public AuthorizationForm(Frame owner, String title, boolean modal, Dimension screenSize) throws GuiException {
        super(owner, title, modal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel loginLabel = new JLabel("Логин:");
        JTextField loginField = new JTextField("Chief", 15);
        loginField.setToolTipText("Введите логин");
        JLabel passwordLabel = new JLabel("Пароль:");
        JPasswordField passwordField = new JPasswordField("admin", 15);
        passwordField.setToolTipText("Введите пароль");

        JButton loginButton = new JButton("Войти");
        loginButton.addActionListener(new LoginListener((JFrame) owner, loginField, passwordField));
        loginButton.setText("Войти");
        JButton cancelButton = new JButton("Отмена");
        cancelButton.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        cancelButton.setText("Отмена");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(cancelButton);
        setContentPane(panel);

        setBounds(screenSize.width/2 - 125,screenSize.height/2 - 75,250,150);
        setVisible(true);
    }
}
