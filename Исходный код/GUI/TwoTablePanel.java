package GUI;

import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.constant.GuiConstant;
import GUI.exception.GuiException;
import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.factory.CommandFactory;
import command.invoker.Invoker;
import command.result.ResultCommand;
import entity.Employee;
import entity.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TwoTablePanel extends JSplitPane {
    JTable tableTop;
    JTable tableBottom;

    public TwoTablePanel(int height) throws GuiException {
        super(JSplitPane.VERTICAL_SPLIT, true);
        setOneTouchExpandable(true);
        setDividerSize(8);
        setDividerLocation(height / 2);

        DefaultTableModel modelTop = new DefaultTableModel();
        modelTop.setColumnIdentifiers(GuiConstant.COLUMNS_HEADER_EMPLOYEE);
        tableTop = new JTable(modelTop);
        new RefreshEmployeeTableListener(tableTop).action();
        JScrollPane scrollTop = new JScrollPane(tableTop);

        DefaultTableModel modelBottom = new DefaultTableModel();
        modelBottom.setColumnIdentifiers(GuiConstant.COLUMNS_HEADER_TASK);
        tableBottom = new JTable(modelBottom);
        new RefreshTaskTableListener(tableBottom).action();
        JScrollPane scrollBottom = new JScrollPane(tableBottom);

        setTopComponent(scrollTop);
        setBottomComponent(scrollBottom);
    }

    public JTable getTableTop() {
        return tableTop;
    }

    public JTable getTableBottom() {
        return tableBottom;
    }
}
