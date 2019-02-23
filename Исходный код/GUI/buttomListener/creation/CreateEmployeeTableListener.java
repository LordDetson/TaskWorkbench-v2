package GUI.buttomListener.creation;

import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.constant.GuiConstant;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import entity.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CreateEmployeeTableListener implements ActionListener {
    private JTable table;
    private JTextField fieldLastName;
    private JTextField fieldName;
    private JTextField fieldMiddelName;
    private JTextField fieldLogin;
    private JTextField fieldPassword;
    private JTextField fieldBirthDate;
    private JTextField fieldCity;
    private JTextField fieldCountry;
    private CommandFactory factory;
    private Invoker invoker;

    public CreateEmployeeTableListener(JTable table, JTextField fieldLastName, JTextField fieldName,
                                       JTextField fieldMiddelName, JTextField fieldLogin, JTextField fieldPassword,
                                       JTextField fieldBirthDate, JTextField fieldCity, JTextField fieldCountry) throws GuiException {
        this.table = table;
        this.fieldLastName = fieldLastName;
        this.fieldName = fieldName;
        this.fieldMiddelName = fieldMiddelName;
        this.fieldLogin = fieldLogin;
        this.fieldPassword = fieldPassword;
        this.fieldBirthDate = fieldBirthDate;
        this.fieldCity = fieldCity;
        this.fieldCountry = fieldCountry;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.CREATION_EMPLOYEE));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String date_str = fieldBirthDate.getText();
            String[] year_month_day = date_str.split("-");
            Date date = new Date(Integer.valueOf(year_month_day[0]) - 1900,
                    Integer.valueOf(year_month_day[1]) - 1, Integer.valueOf(year_month_day[2]));
            Employee employee = new Employee(
                    fieldLastName.getText(),
                    fieldName.getText(),
                    fieldMiddelName.getText(),
                    fieldLogin.getText(),
                    fieldPassword.getText(),
                    date,
                    fieldCity.getText(),
                    fieldCountry.getText()
            );
            ContentCommand.getInstance().getContent().put(CommandConstant.EMPLOYEE, employee);
            invoker.invokeCommand(ContentCommand.getInstance());
            new RefreshEmployeeTableListener(table).action();
        } catch (CommandException e1) {
            e1.printStackTrace();
        } catch (GuiException e1) {
            e1.printStackTrace();
        }
    }
}
