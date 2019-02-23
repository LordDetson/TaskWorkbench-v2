package GUI.buttomListener.save;

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
import entity.Employee;
import entity.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SaveTaskTableListener implements ActionListener {
    private JTable table;
    private CommandFactory factory;
    private Invoker invoker;

    public SaveTaskTableListener(JTable table) throws GuiException {
        this.table = table;
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
            task.setBelongs(Integer.valueOf(model.getValueAt(indexRowSelect,1).toString()));
            task.setTitel(model.getValueAt(indexRowSelect,2).toString());
            task.setContent(model.getValueAt(indexRowSelect,3).toString());
            String date = null;
            String[] d = null;
            date = model.getValueAt(indexRowSelect, 4).toString();
            d = date.split("-");
            task.setReceptionDate(new Date(Integer.valueOf(d[0]) - 1900, Integer.valueOf(d[1]) - 1, Integer.valueOf(d[2])));
            date = model.getValueAt(indexRowSelect, 5).toString();
            d = date.split("-");
            task.setEndingDate(new Date(Integer.valueOf(d[0]) - 1900, Integer.valueOf(d[1]) - 1, Integer.valueOf(d[2])));
            if (model.getValueAt(indexRowSelect, 6) != null) {
                if (!model.getValueAt(indexRowSelect, 6).toString().equals("")) {
                    date = model.getValueAt(indexRowSelect, 6).toString();
                    d = date.split("-");
                    task.setDoneDate(new Date(Integer.valueOf(d[0]) - 1900, Integer.valueOf(d[1]) - 1, Integer.valueOf(d[2])));
                }
                else {
                    task.setDoneDate(null);
                }
            } else {
                task.setDoneDate(null);
            }
            task.setDone(Boolean.valueOf(model.getValueAt(indexRowSelect,7).toString()));
            task.setVerified(Boolean.valueOf(model.getValueAt(indexRowSelect,8).toString()));
            ContentCommand.getInstance().getContent().put(CommandConstant.TASK, task);
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
