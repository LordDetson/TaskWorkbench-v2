package dao;

import dao.exception.DaoException;
import entity.Task;

import java.util.List;

public interface TaskDao {
    List<Task> findAll() throws DaoException;

    List<Task> findAllByBelongs(Integer belongs) throws DaoException;

    Task find(Integer id) throws DaoException;

    void create(Task task) throws DaoException;

    void update(Task task) throws DaoException;

    void delete(Task task) throws DaoException;

    void delete(Integer id) throws DaoException;

    void deleteByBelong(Integer belong) throws DaoException;
}
