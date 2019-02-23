package GUI.buttomListener.refresh;

import GUI.constant.GuiConstant;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import entity.Employee;
import entity.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RefreshTaskTableListener implements ActionListener {

    private JTable table;
    private CommandFactory factory;
    private Invoker invoker;

    public RefreshTaskTableListener(JTable table) throws GuiException {
        this.table = table;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.REVIEW_TASK));
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
            List<Task> taskList = (List<Task>) invoker.invokeCommand(ContentCommand.getInstance()).getResult().get(CommandConstant.TASK_LIST);
            Object[] data = new Object[GuiConstant.COLUMNS_HEADER_TASK.length];
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                data[0] = task.getId();
                data[1] = task.getBelongs();
                data[2] = task.getTitel();
                data[3] = task.getContent();
                data[4] = task.getReceptionDate();
                data[5] = task.getEndingDate();
                data[6] = task.getDoneDate();
                data[7] = task.getDone();
                data[8] = task.getVerified();
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
