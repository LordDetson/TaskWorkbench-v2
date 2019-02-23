package GUI.buttomListener.creation;

import GUI.CreateEmployeeDialog;
import GUI.CreateTaskDialog;
import GUI.exception.GuiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCreateTaskDialog implements ActionListener {
    private JTable table;
    private Frame owner;

    public ShowCreateTaskDialog(Frame owner, JTable table) throws GuiException {
        this.table = table;
        this.owner = owner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateTaskDialog dialog = null;
        try {
            dialog = new CreateTaskDialog(owner, "Форма ввода данных о задании", true, table);
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
        dialog.setVisible(true);
    }
}
