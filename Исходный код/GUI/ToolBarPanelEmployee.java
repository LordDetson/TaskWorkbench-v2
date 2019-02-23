package GUI;

import GUI.buttomListener.creation.ShowCreateTaskDialog;
import GUI.buttomListener.delete.DeleteTaskTableListener;
import GUI.buttomListener.refresh.RefreshTaskByBelongsTableListener;
import GUI.buttomListener.refresh.RefreshTaskTableListener;
import GUI.buttomListener.save.SaveTaskByBelongsTableListener;
import GUI.buttomListener.save.SaveTaskTableListener;
import GUI.buttomListener.sort.SortTaskTableListener;
import GUI.exception.GuiException;
import entity.Employee;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanelEmployee extends JToolBar {
    public ToolBarPanelEmployee(Frame owner, JTable table, Employee employee) throws GuiException {
        setFloatable(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton refreshTaskTable = new JButton("Обновить заданий");
        refreshTaskTable.addActionListener(new RefreshTaskByBelongsTableListener(table, employee));
        add(refreshTaskTable);

        JButton saveTaskTable = new JButton("Сохранить задание");
        saveTaskTable.addActionListener(new SaveTaskByBelongsTableListener(table, employee));
        add(saveTaskTable);

        JButton sortTaskTable = new JButton("Сортировать задания");
        sortTaskTable.addActionListener(new SortTaskTableListener(table));
        add(sortTaskTable);
    }
}
