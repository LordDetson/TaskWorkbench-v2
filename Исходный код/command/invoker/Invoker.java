package command.invoker;

import command.Command;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.result.ResultCommand;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public ResultCommand invokeCommand(ContentCommand contentCommand) throws CommandException {
        return command.execute(contentCommand);
    }
}
