package dao.constant;

public class DaoConstant {
    public static final String URL_DRIVER = "jdbc:mysql://localhost:3306/taskworkbench";

    public static final String USER_DB = "root";

    public static final String PASSWORD_DB = "root";

    public static final String APOSTROPHE = "`";

    public static final String EMPLOYEE = "employee";

    public static final String ID = "id";

    public static final String LAST_NAME = "lastName";

    public static final String NAME = "name";

    public static final String MIDDLE_NAME = "middleName";

    public static final String LOGIN = "login";

    public static final String PASSWORD = "password";

    public static final String BIRTH_DATE = "birthDate";

    public static final String CITY = "city";

    public static final String COUNTRY = "country";

    public static final String TASK = "task";

    public static final String BELONGS = "belongs";

    public static final String TITEL = "titel";

    public static final String CONTENT = "content";

    public static final String RECEPTION_DATE = "receptionDate";

    public static final String ENDING_DATE = "endingDate";

    public static final String DONE_DATE = "doneDate";

    public static final String DONE = "done";

    public static final String VERIFIED = "verified";

    public static final String FIND_ALL_EMPLOYEE = "SELECT * FROM " + APOSTROPHE + EMPLOYEE + APOSTROPHE;

    public static final String FIND_BY_ID_EMPLOYEE = "SELECT * FROM " + APOSTROPHE + EMPLOYEE + APOSTROPHE + " WHERE "
            + APOSTROPHE + ID + APOSTROPHE + " = ";

    public static final String FIND_BY_LOGIN_EMPLOYEE = "SELECT * FROM " + APOSTROPHE + EMPLOYEE + APOSTROPHE +
            " WHERE " +APOSTROPHE + LOGIN + APOSTROPHE + " = ";

    public static final String CREATE_EMLOYEE = "INSERT INTO " + APOSTROPHE + EMPLOYEE + APOSTROPHE + " (" +
            APOSTROPHE + LAST_NAME + APOSTROPHE +
            "," + APOSTROPHE + NAME + APOSTROPHE +
            "," + APOSTROPHE + MIDDLE_NAME + APOSTROPHE +
            "," + APOSTROPHE + LOGIN + APOSTROPHE +
            "," + APOSTROPHE + PASSWORD + APOSTROPHE +
            "," + APOSTROPHE + BIRTH_DATE + APOSTROPHE +
            "," + APOSTROPHE + CITY + APOSTROPHE +
            "," + APOSTROPHE + COUNTRY + APOSTROPHE + ") VALUES(?,?,?,?,?,?,?,?)";

    public static final String UPDATE_EMPLOYEE = "UPDATE " + APOSTROPHE + EMPLOYEE + APOSTROPHE + " SET " +
            APOSTROPHE + LAST_NAME + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + NAME + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + MIDDLE_NAME + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + LOGIN + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + PASSWORD + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + BIRTH_DATE + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + CITY + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + COUNTRY + APOSTROPHE + "=" + "?" + " WHERE " +
            APOSTROPHE + ID + APOSTROPHE + "=" + "?";

    public static final String DELETE_EMPLOYEE = "DELETE FROM " + APOSTROPHE + EMPLOYEE + APOSTROPHE + " WHERE " +
            APOSTROPHE + ID + APOSTROPHE + "=" + "?";

    public static final String FIND_ALL_TASK = "SELECT * FROM " + APOSTROPHE + TASK + APOSTROPHE;

    public static final String FIND_ALL_BY_PARAM_TASK = "SELECT * FROM " + APOSTROPHE + TASK + APOSTROPHE + " WHERE "
            + APOSTROPHE + BELONGS + APOSTROPHE + "=" + "?";

    public static final String FIND_ALL_BY_ID_TASK = "SELECT * FROM " + APOSTROPHE + TASK + APOSTROPHE + " WHERE "
            + APOSTROPHE + ID + APOSTROPHE + "=" + "?";

    public static final String CREATE_TASK = "INSERT INTO " + APOSTROPHE + TASK + APOSTROPHE + " (" +
            APOSTROPHE + BELONGS + APOSTROPHE +
            ", " + APOSTROPHE + TITEL + APOSTROPHE +
            ", " + APOSTROPHE + CONTENT + APOSTROPHE +
            ", " + APOSTROPHE + RECEPTION_DATE + APOSTROPHE +
            ", " + APOSTROPHE + ENDING_DATE + APOSTROPHE +
            ", " + APOSTROPHE + DONE + APOSTROPHE +
            ", " + APOSTROPHE + VERIFIED + APOSTROPHE + ") VALUE(?,?,?,?,?,?,?)";

    public static final String UPDATE_TASK = "UPDATE " + APOSTROPHE + TASK + APOSTROPHE + " SET " +
            APOSTROPHE + BELONGS + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + TITEL + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + CONTENT + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + RECEPTION_DATE + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + ENDING_DATE + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + DONE_DATE + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + DONE + APOSTROPHE + "=" + "?" +
            "," + APOSTROPHE + VERIFIED + APOSTROPHE + "=" + "?" + " WHERE " +
            APOSTROPHE + ID + APOSTROPHE + "=" + "?";

    public static final String DELETE_TASK = "DELETE FROM " + APOSTROPHE + TASK + APOSTROPHE + " WHERE " +
            APOSTROPHE + ID + APOSTROPHE + "=" + "?";

    public static final String DELETE_TASK_BY_BELONGS = "DELETE FROM " + APOSTROPHE + TASK + APOSTROPHE + " WHERE " +
            APOSTROPHE + BELONGS + APOSTROPHE + "=" + "?";
}
