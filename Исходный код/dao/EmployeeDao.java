package dao;

import dao.exception.DaoException;
import entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll() throws DaoException;

    Employee find(Integer id) throws DaoException;

    Employee find(String login) throws DaoException;

    void create(Employee employee) throws DaoException;

    void update(Employee employee) throws DaoException;

    void delete(Employee employee) throws DaoException;

    void delete(Integer id) throws DaoException;
}
