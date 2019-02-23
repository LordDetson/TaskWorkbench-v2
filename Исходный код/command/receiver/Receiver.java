package command.receiver;

import command.CommandType;
import command.exception.CommandException;
import command.result.ResultCommand;

public interface Receiver {
    public ResultCommand action(CommandType type) throws CommandException;
}
