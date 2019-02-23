package GUI.buttomListener.creation;

import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import entity.Employee;
import entity.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CreateTaskTableListener implements ActionListener {
    private JTable table;
    private JTextField fieldBelongs;
    private JTextField fieldTitle;
    private JTextField fieldContent;
    private JTextField fieldReceptionDate;
    private JTextField fieldEndingDate;
    private CommandFactory factory;
    private Invoker invoker;

    public CreateTaskTableListener(JTable table, JTextField fieldBelongs, JTextField fieldTitle,
                                   JTextField fieldContent, JTextField fieldReceptionDate, JTextField fieldEndingDate) throws GuiException {
        this.table = table;
        this.fieldBelongs = fieldBelongs;
        this.fieldTitle = fieldTitle;
        this.fieldContent = fieldContent;
        this.fieldReceptionDate = fieldReceptionDate;
        this.fieldEndingDate = fieldEndingDate;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.CREATION_TASK));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String date_str = fieldReceptionDate.getText();
            String[] year_month_day = date_str.split("-");
            Date receptionDate = new Date(Integer.valueOf(year_month_day[0]) - 1900,
                    Integer.valueOf(year_month_day[1]) - 1, Integer.valueOf(year_month_day[2]));
            date_str = fieldEndingDate.getText();
            year_month_day = date_str.split("-");
            Date endingDate = new Date(Integer.valueOf(year_month_day[0]) - 1900,
                    Integer.valueOf(year_month_day[1]) - 1, Integer.valueOf(year_month_day[2]));
            Task task = new Task(
                    Integer.valueOf(fieldBelongs.getText()),
                    fieldTitle.getText(),
                    fieldContent.getText(),
                    receptionDate,
                    endingDate,
                    false,
                    false
            );
            invoker.invokeCommand((ContentCommand) ContentCommand.getInstance().getContent().put(CommandConstant.TASK, task));
            new RefreshTaskTableListener(table).action();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
