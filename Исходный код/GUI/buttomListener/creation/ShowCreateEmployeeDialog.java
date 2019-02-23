package GUI.buttomListener.creation;

import GUI.CreateEmployeeDialog;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCreateEmployeeDialog implements ActionListener {

    private JTable table;
        private Frame owner;

    public ShowCreateEmployeeDialog(Frame owner, JTable table) throws GuiException {
            this.table = table;
            this.owner = owner;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateEmployeeDialog dialog = null;
            try {
                dialog = new CreateEmployeeDialog(owner, "Форма ввода данных о сотруднике", true, table);
            } catch (GuiException e1) {
                e1.printStackTrace();
            }
            dialog.setVisible(true);
}
}
