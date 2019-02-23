package GUI.buttomListener.save;

import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.constant.GuiConstant;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import dao.EmployeeDao;
import dao.exception.DaoException;
import dao.impl.EmployeeDaoImpl;
import entity.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SaveEmployeeTableListener implements ActionListener {
    private JTable table;
    private CommandFactory factory;
    private Invoker invoker;

    public SaveEmployeeTableListener(JTable table) throws GuiException {
        this.table = table;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.EDITING_EMPLOYEE));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }

    public void action() {
        int indexRowSelect = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = (int) model.getValueAt(indexRowSelect, 0);
        EmployeeDao dao = new EmployeeDaoImpl();
        try {
            Employee employee = dao.find(id);
            employee.setLastName((String) model.getValueAt(indexRowSelect, 1));
            employee.setName((String) model.getValueAt(indexRowSelect, 2));
            employee.setMiddleName((String) model.getValueAt(indexRowSelect, 3));
            String date = model.getValueAt(indexRowSelect, 4).toString();
            String[] year_month_day = date.split("-");
            employee.setBirthDate(new Date(Integer.valueOf(year_month_day[0]) - 1900,
                    Integer.valueOf(year_month_day[1]) - 1, Integer.valueOf(year_month_day[2])));
            employee.setCity((String) model.getValueAt(indexRowSelect, 5));
            employee.setCountry((String) model.getValueAt(indexRowSelect, 6));
            ContentCommand.getInstance().getContent().put(CommandConstant.EMPLOYEE, employee);
            invoker.invokeCommand(ContentCommand.getInstance());
            new RefreshEmployeeTableListener(table).action();
        } catch (DaoException e1) {
            e1.printStackTrace();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
