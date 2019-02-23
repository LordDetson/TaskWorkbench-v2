package GUI.buttomListener.save;

import GUI.buttomListener.refresh.RefreshTaskByBelongsTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import dao.TaskDao;
import dao.exception.DaoException;
import dao.impl.TaskDaoImpl;
import entity.Employee;
import entity.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SaveTaskByBelongsTableListener implements ActionListener {
    private JTable table;
    private Employee employee;
    private CommandFactory factory;
    private Invoker invoker;

    public SaveTaskByBelongsTableListener(JTable table, Employee employee) throws GuiException {
        this.table = table;
        this.employee = employee;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.EDITING_TASK));
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
            Task task = dao.find(id);
            task.setDone(Boolean.valueOf(model.getValueAt(indexRowSelect,7).toString()));
            ContentCommand.getInstance().getContent().put(CommandConstant.TASK, task);
            invoker.invokeCommand(ContentCommand.getInstance());
            new RefreshTaskByBelongsTableListener(table, employee).action();
        } catch (DaoException e1) {
            e1.printStackTrace();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
