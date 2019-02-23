package command;

import command.content.ContentCommand;
import command.exception.CommandException;
import command.result.ResultCommand;

public interface Command {
    ResultCommand execute(ContentCommand contentCommand) throws CommandException;
}
