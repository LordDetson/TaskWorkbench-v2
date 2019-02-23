package GUI.buttomListener.refresh;

import GUI.constant.GuiConstant;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import entity.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RefreshEmployeeTableListener implements ActionListener {

    private JTable table;
    private CommandFactory factory;
    private Invoker invoker;

    public RefreshEmployeeTableListener(JTable table) throws GuiException {
        this.table = table;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.REVIEW_EMPLOYEE));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }

    public void action() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            List<Employee> employeeList = (List<Employee>) invoker.invokeCommand(ContentCommand.getInstance()).getResult().get(CommandConstant.EMPLOYEE_LIST);
            Object[] data = new Object[GuiConstant.COLUMNS_HEADER_EMPLOYEE.length];
            for (int i = 0; i < employeeList.size(); i++) {
                Employee employee = employeeList.get(i);
                data[0] = employee.getId();
                data[1] = employee.getLastName();
                data[2] = employee.getName();
                data[3] = employee.getMiddleName();
                data[4] = employee.getBirthDate();
                data[5] = employee.getCity();
                data[6] = employee.getCountry();
                model.insertRow(i, data);
            }
        } catch (CommandException e1) {
            try {
                throw new GuiException(e1);
            } catch (GuiException e2) {
                e2.printStackTrace();
            }
        }
    }
}
