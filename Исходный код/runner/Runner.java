package runner;

import GUI.MainFrame;
import GUI.exception.GuiException;

public class Runner {
    public static void main(String[] args) {
        try {
            new MainFrame("Task Workbench");
        } catch (GuiException e) {
            e.printStackTrace();
        }
    }
}
