package GUI.buttomListener.delete;

import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import dao.EmployeeDao;
import dao.exception.DaoException;
import dao.impl.EmployeeDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployeeTableListener implements ActionListener {

    private JTable tableEmployee;
    private JTable tableTask;
    private CommandFactory factory;
    private Invoker invoker;

    public DeleteEmployeeTableListener(JTable tableEmployee, JTable tableTask) throws GuiException {
        this.tableEmployee = tableEmployee;
        this.tableTask = tableTask;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.DELETE_EMPLOYEE));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }

    public void action() {
        int indexRowSelect = tableEmployee.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
        int id = (int) model.getValueAt(indexRowSelect, 0);
        EmployeeDao dao = new EmployeeDaoImpl();
        try {
            ContentCommand.getInstance().getContent().put(CommandConstant.EMPLOYEE, dao.find(id));
            invoker.invokeCommand(ContentCommand.getInstance());
            new RefreshEmployeeTableListener(tableEmployee).action();
            new RefreshTaskTableListener(tableTask).action();
        } catch (DaoException e1) {
            e1.printStackTrace();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
