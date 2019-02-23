package dao.impl;

import dao.TaskDao;
import dao.connection.ConnectionFactory;
import dao.constant.DaoConstant;
import dao.exception.DaoException;
import entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    private Connection connection;

    public TaskDaoImpl() {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public List<Task> findAll() throws DaoException {
        List<Task> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_ALL_TASK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task row = new Task(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getInt(DaoConstant.BELONGS),
                        resultSet.getString(DaoConstant.TITEL),
                        resultSet.getString(DaoConstant.CONTENT),
                        resultSet.getDate(DaoConstant.RECEPTION_DATE),
                        resultSet.getDate(DaoConstant.ENDING_DATE),
                        resultSet.getDate(DaoConstant.DONE_DATE),
                        resultSet.getBoolean(DaoConstant.DONE),
                        resultSet.getBoolean(DaoConstant.VERIFIED)
                );
                result.add(row);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public List<Task> findAllByBelongs(Integer belongs) throws DaoException {
        List<Task> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_ALL_BY_PARAM_TASK);
            statement.setInt(1, belongs);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task row = new Task(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getInt(DaoConstant.BELONGS),
                        resultSet.getString(DaoConstant.TITEL),
                        resultSet.getString(DaoConstant.CONTENT),
                        resultSet.getDate(DaoConstant.RECEPTION_DATE),
                        resultSet.getDate(DaoConstant.ENDING_DATE),
                        resultSet.getDate(DaoConstant.DONE_DATE),
                        resultSet.getBoolean(DaoConstant.DONE),
                        resultSet.getBoolean(DaoConstant.VERIFIED)
                );
                result.add(row);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Task find(Integer id) throws DaoException {
        Task result = null;
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_ALL_BY_ID_TASK);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Task(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getInt(DaoConstant.BELONGS),
                        resultSet.getString(DaoConstant.TITEL),
                        resultSet.getString(DaoConstant.CONTENT),
                        resultSet.getDate(DaoConstant.RECEPTION_DATE),
                        resultSet.getDate(DaoConstant.ENDING_DATE),
                        resultSet.getDate(DaoConstant.DONE_DATE),
                        resultSet.getBoolean(DaoConstant.DONE),
                        resultSet.getBoolean(DaoConstant.VERIFIED)
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public void create(Task task) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.CREATE_TASK);
            statement.setInt(1, task.getBelongs());
            statement.setString(2, task.getTitel());
            statement.setString(3, task.getContent());
            statement.setObject(4, task.getReceptionDate());
            statement.setObject(5, task.getEndingDate());
            statement.setByte(6, task.getDone()?(byte)1:(byte)0);
            statement.setByte(7, task.getVerified()?(byte)1:(byte)0);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Task task) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.UPDATE_TASK);
            statement.setInt(1, task.getBelongs());
            statement.setString(2, task.getTitel());
            statement.setString(3, task.getContent());
            statement.setObject(4, task.getReceptionDate());
            statement.setObject(5, task.getEndingDate());
            statement.setObject(6, task.getDoneDate());
            statement.setByte(7, task.getDone()?(byte)1:(byte)0);
            statement.setByte(8, task.getVerified()?(byte)1:(byte)0);
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Task task) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.DELETE_TASK);
            statement.setInt(1, task.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.DELETE_TASK);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByBelong(Integer belong) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.DELETE_TASK_BY_BELONGS);
            statement.setInt(1, belong);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
