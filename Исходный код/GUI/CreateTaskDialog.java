package GUI;

import GUI.buttomListener.creation.CreateTaskTableListener;
import GUI.buttomListener.creation.ShowCreateTaskDialog;
import GUI.exception.GuiException;

import javax.swing.*;
import java.awt.*;

public class CreateTaskDialog extends JDialog {
    public CreateTaskDialog(Frame owner, String title, boolean modal, JTable table) throws GuiException {
        super(owner, title, modal);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel labelBelongs = new JLabel("ID сотрудника");
        JLabel labelTitle = new JLabel("Заголовок");
        JLabel labelContent = new JLabel("Задание");
        JLabel labelReceptionDate = new JLabel("Дата получения");
        JLabel labelEndingDate = new JLabel("Дата завершения");

        JTextField fieldBelongs = new JTextField(45);
        JTextField fieldTitle = new JTextField(45);
        JTextField fieldContent = new JTextField(45);
        JTextField fieldReceptionDate = new JTextField(45);
        JTextField fieldEndingDate = new JTextField(45);

        JButton createTask = new JButton("Создать");
        createTask.addActionListener(new CreateTaskTableListener(table, fieldBelongs, fieldTitle, fieldContent,
                fieldReceptionDate, fieldEndingDate));

        add(labelBelongs);
        add(fieldBelongs);
        add(labelTitle);
        add(fieldTitle);
        add(labelContent);
        add(fieldContent);
        add(labelReceptionDate);
        add(fieldReceptionDate);
        add(labelEndingDate);
        add(fieldEndingDate);
        add(createTask);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(530, 500);
    }
}
