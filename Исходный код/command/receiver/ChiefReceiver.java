package command.receiver;

import command.constant.CommandConstant;
import command.content.ContentCommand;
import command.exception.CommandException;
import command.result.ResultCommand;
import dao.EmployeeDao;
import dao.TaskDao;
import dao.exception.DaoException;
import dao.impl.EmployeeDaoImpl;
import dao.impl.TaskDaoImpl;
import entity.Employee;
import entity.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ChiefReceiver {
    private EmployeeDao employeeDao;
    private TaskDao taskDao;

    private static class SingltonHolder {
        private static final ChiefReceiver INSTANCE = new ChiefReceiver();
    }

    public ChiefReceiver() {
        this.employeeDao = new EmployeeDaoImpl();
        this.taskDao = new TaskDaoImpl();
    }

    public static ChiefReceiver getInstance() {
        return SingltonHolder.INSTANCE;
    }

    public ResultCommand creationEmployee(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = ContentCommand.getInstance().getContent();
        if (content.get(CommandConstant.EMPLOYEE) == null)
            throw new CommandException("Kay = " + CommandConstant.EMPLOYEE + " value = null!");
        try {
            employeeDao.create((Employee) content.get(CommandConstant.EMPLOYEE));
            ResultCommand.getInstance().getResult().put(CommandConstant.EMPLOYEE_LIST, employeeDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand reviewEmployee(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        try {
            ResultCommand.getInstance().getResult().put(CommandConstant.EMPLOYEE_LIST, employeeDao.findAll());
            content.put(CommandConstant.EMPLOYEE_LIST, employeeDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand sortEmployee(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if (content.get(CommandConstant.EMPLOYEE_LIST) == null)
            throw new CommandException("Key = " + CommandConstant.EMPLOYEE_LIST + " Value = null!");
        List<Employee> employeeList = (List<Employee>) content.get(CommandConstant.EMPLOYEE_LIST);
        employeeList.sort(Comparator.comparing(Employee::getLastName));
        ResultCommand.getInstance().getResult().put(CommandConstant.EMPLOYEE_LIST, employeeList);
        return ResultCommand.getInstance();
    }

    public ResultCommand editingEmployee(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if(content.get(CommandConstant.EMPLOYEE) == null)
            throw new CommandException("Key = " + CommandConstant.EMPLOYEE + " Value = null!");
        try {
            employeeDao.update((Employee) content.get(CommandConstant.EMPLOYEE));
            ResultCommand.getInstance().getResult().put(CommandConstant.EMPLOYEE_LIST, employeeDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        }  finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand deleteEmployee(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if(content.get(CommandConstant.EMPLOYEE) == null)
            throw new CommandException("Key = " + CommandConstant.EMPLOYEE + " Value = null!");
        try {
            employeeDao.delete((Employee) content.get(CommandConstant.EMPLOYEE));
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand creationTask(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = ContentCommand.getInstance().getContent();
        if (content.get(CommandConstant.TASK) == null)
            throw new CommandException("Kay = " + CommandConstant.TASK + " value = null!");
        try {
            taskDao.create((Task) content.get(CommandConstant.TASK));
            ResultCommand.getInstance().getResult().put(CommandConstant.TASK_LIST, taskDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand reviewTask(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        try {
            ResultCommand.getInstance().getResult().put(CommandConstant.TASK_LIST, taskDao.findAll());
            content.put(CommandConstant.TASK_LIST, taskDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand sortTask(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if (content.get(CommandConstant.TASK_LIST) == null)
            throw new CommandException("Key = " + CommandConstant.TASK_LIST + " Value = null!");
        List<Task> taskList = (List<Task>) content.get(CommandConstant.TASK_LIST);
        taskList.sort(Comparator.comparing(Task::getBelongs));
        ResultCommand.getInstance().getResult().put(CommandConstant.TASK_LIST, taskList);
        return ResultCommand.getInstance();
    }

    public ResultCommand editingTask(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if(content.get(CommandConstant.TASK) == null)
            throw new CommandException("Key = " + CommandConstant.TASK + " Value = null!");
        try {
            taskDao.update((Task) content.get(CommandConstant.TASK));
            ResultCommand.getInstance().getResult().put(CommandConstant.TASK_LIST, taskDao.findAll());
        } catch (DaoException e) {
            throw new CommandException(e);
        }  finally {
            return ResultCommand.getInstance();
        }
    }

    public ResultCommand deleteTask(ContentCommand contentCommand) throws CommandException {
        Map<String, Object> content = contentCommand.getInstance().getContent();
        if(content.get(CommandConstant.TASK) == null)
            throw new CommandException("Key = " + CommandConstant.TASK + " Value = null!");
        try {
            taskDao.delete((Task) content.get(CommandConstant.TASK));
            reviewTask(contentCommand);
        } catch (DaoException e) {
            throw new CommandException(e);
        } finally {
            return ResultCommand.getInstance();
        }
    }

}
