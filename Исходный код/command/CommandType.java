package command;

import command.receiver.ChiefReceiver;

import java.util.Arrays;

public enum CommandType {
    CREATION_EMPLOYEE(ChiefReceiver.getInstance()::creationEmployee),
    REVIEW_EMPLOYEE(ChiefReceiver.getInstance()::reviewEmployee),
    SORT_EMPLOYEE(ChiefReceiver.getInstance()::sortEmployee),
    EDITING_EMPLOYEE(ChiefReceiver.getInstance()::editingEmployee),
    DELETE_EMPLOYEE(ChiefReceiver.getInstance()::deleteEmployee),

    CREATION_TASK(ChiefReceiver.getInstance()::creationTask),
    REVIEW_TASK(ChiefReceiver.getInstance()::reviewTask),
    SORT_TASK(ChiefReceiver.getInstance()::sortTask),
    EDITING_TASK(ChiefReceiver.getInstance()::editingTask),
    DELETE_TASK(ChiefReceiver.getInstance()::deleteTask);

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static boolean isExistCommand(String command) {
        if (!command.isEmpty()) {
            return Arrays.stream(CommandType.values()).anyMatch(type -> command.equalsIgnoreCase(type.name()));
        }
        return false;
    }
}
