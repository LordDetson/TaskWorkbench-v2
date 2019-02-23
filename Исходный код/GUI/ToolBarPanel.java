package GUI;

import GUI.buttomListener.creation.ShowCreateEmployeeDialog;
import GUI.buttomListener.creation.ShowCreateTaskDialog;
import GUI.buttomListener.delete.DeleteEmployeeTableListener;
import GUI.buttomListener.delete.DeleteTaskTableListener;
import GUI.buttomListener.refresh.RefreshEmployeeTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.buttomListener.save.SaveEmployeeTableListener;
import GUI.buttomListener.save.SaveTaskTableListener;
import GUI.buttomListener.sort.SortEmployeeTableListener;
import GUI.buttomListener.sort.SortTaskTableListener;
import GUI.exception.GuiException;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JToolBar {
    public ToolBarPanel(Frame owner, JTable tableTop, JTable tableBottom) throws GuiException {
        setFloatable(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton createEmployeeTable = new JButton("Добавить сотрудника");
        createEmployeeTable.addActionListener(new ShowCreateEmployeeDialog(owner, tableTop));
        add(createEmployeeTable);

        JButton refreshEmployeeTable = new JButton("Обновить сотрудников");
        refreshEmployeeTable.addActionListener(new RefreshEmployeeTableListener(tableTop));
        add(refreshEmployeeTable);

        JButton deleteEmployeeTable = new JButton("Удалить сотрудника");
        deleteEmployeeTable.addActionListener(new DeleteEmployeeTableListener(tableTop,tableBottom));
        add(deleteEmployeeTable);

        JButton saveEmployeeTable = new JButton("Сохранить сотрудника");
        saveEmployeeTable.addActionListener(new SaveEmployeeTableListener(tableTop));
        add(saveEmployeeTable);

        JButton sortEmployeeTable = new JButton("Сортировать сотрудников");
        sortEmployeeTable.addActionListener(new SortEmployeeTableListener(tableTop));
        add(sortEmployeeTable);

        JButton createTaskTable = new JButton("Добавить задание");
        createTaskTable.addActionListener(new ShowCreateTaskDialog(owner, tableBottom));
        add(createTaskTable);

        JButton refreshTaskTable = new JButton("Обновить заданий");
        refreshTaskTable.addActionListener(new RefreshTaskTableListener(tableBottom));
        add(refreshTaskTable);

        JButton deleteTaskTable = new JButton("Удалить задание");
        deleteTaskTable.addActionListener(new DeleteTaskTableListener(tableBottom));
        add(deleteTaskTable);

        JButton saveTaskTable = new JButton("Сохранить задание");
        saveTaskTable.addActionListener(new SaveTaskTableListener(tableBottom));
        add(saveTaskTable);

        JButton sortTaskTable = new JButton("Сортировать задания");
        sortTaskTable.addActionListener(new SortTaskTableListener(tableBottom));
        add(sortTaskTable);
    }
}
