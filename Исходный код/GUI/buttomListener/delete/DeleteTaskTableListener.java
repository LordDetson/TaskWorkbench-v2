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
import dao.TaskDao;
import dao.exception.DaoException;
import dao.impl.EmployeeDaoImpl;
import dao.impl.TaskDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTaskTableListener implements ActionListener {
    private JTable table;
    private CommandFactory factory;
    private Invoker invoker;

    public DeleteTaskTableListener(JTable table) throws GuiException {
        this.table = table;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.DELETE_TASK));
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
        TaskDao dao = new TaskDaoImpl();
        try {
            ContentCommand.getInstance().getContent().put(CommandConstant.TASK, dao.find(id));
            invoker.invokeCommand(ContentCommand.getInstance());
            new RefreshTaskTableListener(table).action();
        } catch (DaoException e1) {
            e1.printStackTrace();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
