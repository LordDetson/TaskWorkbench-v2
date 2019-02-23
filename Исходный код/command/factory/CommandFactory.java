package command.factory;

import command.Command;
import command.CommandType;
import command.exception.CommandException;

public class CommandFactory {
    private static class SingletonHolder {
        private static final CommandFactory INSTANCE = new CommandFactory();
    }

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Command initCommand(String nameCommand) throws CommandException {
        if (CommandType.isExistCommand(nameCommand)) {
            CommandType type = CommandType.valueOf(nameCommand.toUpperCase());
            return type.getCommand();
        }
        throw new CommandException(nameCommand + "NOT_EXIST_COMMAND_MESSAGE");
    }
}
