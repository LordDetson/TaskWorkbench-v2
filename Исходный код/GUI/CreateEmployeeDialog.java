package GUI;

import GUI.buttomListener.creation.CreateEmployeeTableListener;
import GUI.exception.GuiException;

import javax.swing.*;
import java.awt.*;

public class CreateEmployeeDialog extends JDialog {
    public CreateEmployeeDialog(Frame owner, String title, boolean modal, JTable table) throws GuiException {
        super(owner, title, modal);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel labelLastName = new JLabel("Фамилия");
        JLabel labelName = new JLabel("Имя");
        JLabel labelMiddelName = new JLabel("Отчество");
        JLabel labelLogin = new JLabel("Логин");
        JLabel labelPassword = new JLabel("Пароль");
        JLabel labelBirthDate = new JLabel("День рождения");
        JLabel labelCity = new JLabel("Город");
        JLabel labelCountry = new JLabel("Страна");
        JTextField fieldLastName = new JTextField(45);
        JTextField fieldName = new JTextField(45);
        JTextField fieldMiddelName = new JTextField(45);
        JTextField fieldLogin = new JTextField(45);
        JTextField fieldPassword = new JTextField(45);
        JTextField fieldBirthDate = new JTextField(45);
        JTextField fieldCity = new JTextField(45);
        JTextField fieldCountry = new JTextField(45);

        JButton createEmployee = new JButton("Создать");
        createEmployee.addActionListener(new CreateEmployeeTableListener(table, fieldLastName, fieldName,
                fieldMiddelName, fieldLogin, fieldPassword, fieldBirthDate, fieldCity, fieldCountry));

        add(labelLastName);
        add(fieldLastName);
        add(labelName);
        add(fieldName);
        add(labelMiddelName);
        add(fieldMiddelName);
        add(labelLogin);
        add(fieldLogin);
        add(labelPassword);
        add(fieldPassword);
        add(labelBirthDate);
        add(fieldBirthDate);
        add(labelCity);
        add(fieldCity);
        add(labelCountry);
        add(fieldCountry);
        add(createEmployee);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(530, 500);
    }
}
