package dao.impl;

import dao.EmployeeDao;
import dao.TaskDao;
import dao.connection.ConnectionFactory;
import dao.constant.DaoConstant;
import dao.exception.DaoException;
import entity.Employee;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection;

    public EmployeeDaoImpl() {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public List<Employee> findAll() throws DaoException {
        List<Employee> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_ALL_EMPLOYEE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee row = new Employee(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getString(DaoConstant.LAST_NAME),
                        resultSet.getString(DaoConstant.NAME),
                        resultSet.getString(DaoConstant.MIDDLE_NAME),
                        resultSet.getString(DaoConstant.LOGIN),
                        resultSet.getString(DaoConstant.PASSWORD),
                        resultSet.getDate(DaoConstant.BIRTH_DATE),
                        resultSet.getString(DaoConstant.CITY),
                        resultSet.getString(DaoConstant.COUNTRY)
                );
                result.add(row);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Employee find(Integer id) throws DaoException {
        Employee result = null;
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_BY_ID_EMPLOYEE + id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Employee(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getString(DaoConstant.LAST_NAME),
                        resultSet.getString(DaoConstant.NAME),
                        resultSet.getString(DaoConstant.MIDDLE_NAME),
                        resultSet.getString(DaoConstant.LOGIN),
                        resultSet.getString(DaoConstant.PASSWORD),
                        resultSet.getDate(DaoConstant.BIRTH_DATE),
                        resultSet.getString(DaoConstant.CITY),
                        resultSet.getString(DaoConstant.COUNTRY)
                );
            } else {
                result = new Employee();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Employee find(String login) throws DaoException {
        Employee result = null;
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.FIND_BY_LOGIN_EMPLOYEE + login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Employee(
                        resultSet.getInt(DaoConstant.ID),
                        resultSet.getString(DaoConstant.LAST_NAME),
                        resultSet.getString(DaoConstant.NAME),
                        resultSet.getString(DaoConstant.MIDDLE_NAME),
                        resultSet.getString(DaoConstant.LOGIN),
                        resultSet.getString(DaoConstant.PASSWORD),
                        resultSet.getDate(DaoConstant.BIRTH_DATE),
                        resultSet.getString(DaoConstant.CITY),
                        resultSet.getString(DaoConstant.COUNTRY)
                );
            } else {
                result = new Employee();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public void create(Employee employee) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.CREATE_EMLOYEE);
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getMiddleName());
            statement.setString(4, employee.getLogin());
            statement.setString(5, employee.getPassword());
            statement.setObject(6, employee.getBirthDate());
            statement.setString(7, employee.getCity());
            statement.setString(8, employee.getCountry());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Employee employee) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DaoConstant.UPDATE_EMPLOYEE);
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getMiddleName());
            statement.setString(4, employee.getLogin());
            statement.setString(5, employee.getPassword());
            statement.setObject(6, employee.getBirthDate());
            statement.setString(7, employee.getCity());
            statement.setString(8, employee.getCountry());
            statement.setInt(9, employee.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Employee employee) throws DaoException {
        try {
            TaskDao dao = new TaskDaoImpl();
            dao.deleteByBelong(employee.getId());
            PreparedStatement statement = connection.prepareStatement(DaoConstant.DELETE_EMPLOYEE);
            statement.setInt(1, employee.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            TaskDao dao = new TaskDaoImpl();
            dao.deleteByBelong(id);
            PreparedStatement statement = connection.prepareStatement(DaoConstant.DELETE_EMPLOYEE);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
