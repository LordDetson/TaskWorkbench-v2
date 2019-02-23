package entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Employee extends Humen {

    List<Task> taskList;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country, List<Task> taskList) {
        super(id, lastName, name, middleName, login, password, birthDate, city, country);
        this.taskList = taskList;
    }

    public Employee(String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country, List<Task> taskList) {
        super(lastName, name, middleName, login, password, birthDate, city, country);
        this.taskList = taskList;
    }

    public Employee(Integer id, String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country) {
        super(id, lastName, name, middleName, login, password, birthDate, city, country);
    }

    public Employee(String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country) {
        super(lastName, name, middleName, login, password, birthDate, city, country);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return taskList != null ? taskList.equals(employee.taskList) : employee.taskList == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (taskList != null ? taskList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", lastName='" + getLastName() + '\'' +
                ", name='" + getName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
