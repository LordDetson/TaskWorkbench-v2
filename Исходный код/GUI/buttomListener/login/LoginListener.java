package GUI.buttomListener.login;

import GUI.MainFrame;
import GUI.ToolBarPanel;
import GUI.ToolBarPanelEmployee;
import GUI.TwoTablePanel;
import GUI.buttomListener.refresh.RefreshTaskByBelongsTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginListener implements ActionListener {
    public static final String LOGIN_CHIEF = "Chief";
    public static final String PASSWORD_CHIEF = "admin";
    private JFrame frame;
    private JTextField loginField;
    private JTextField passwordField;
    private CommandFactory factory;
    private Invoker invoker;

    public LoginListener(JFrame frame, JTextField loginField, JTextField passwordField) throws GuiException {
        this.frame = frame;
        this.loginField = loginField;
        this.passwordField = passwordField;
        factory = CommandFactory.getInstance();
        try {
            invoker = new Invoker(factory.initCommand(CommandConstant.REVIEW_EMPLOYEE));
        } catch (CommandException e) {
            throw new GuiException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (loginField.getText().equals(LOGIN_CHIEF) && passwordField.getText().equals(PASSWORD_CHIEF)) {
                TwoTablePanel tablePanel = new TwoTablePanel((int) MainFrame.rectSizeAndPosition.getHeight());
                frame.add(tablePanel);
                ToolBarPanel barPanel = new ToolBarPanel(frame, tablePanel.getTableTop(), tablePanel.getTableBottom());
                frame.add(barPanel, BorderLayout.WEST);
                frame.setBounds(MainFrame.rectSizeAndPosition);
                frame.setVisible(true);
            } else {
                List<Employee> employeeList = (List<Employee>) invoker.invokeCommand(ContentCommand.getInstance())
                        .getResult().get(CommandConstant.EMPLOYEE_LIST);
                for (Employee employee : employeeList) {
                    if (employee.getLogin().equals(loginField.getText()) && employee.getPassword().equals(passwordField.getText())) {
                        DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(GuiConstant.COLUMNS_HEADER_TASK);
                        JTable table = new JTable(model);
                        new RefreshTaskByBelongsTableListener(table, employee).action();
                        JScrollPane scrollPane = new JScrollPane(table);
                        frame.add(scrollPane, BorderLayout.CENTER);

                        ToolBarPanelEmployee barPanelEmployee = new ToolBarPanelEmployee(frame, table, employee);
                        frame.add(barPanelEmployee, BorderLayout.WEST);

                        frame.setBounds(MainFrame.rectSizeAndPosition);
                        frame.setVisible(true);
                        break;
                    }
                }
            }
        } catch (GuiException e1) {
            e1.printStackTrace();
        } catch (CommandException e1) {
            e1.printStackTrace();
        }
    }
}
