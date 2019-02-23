package dao.connection;

import dao.constant.DaoConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DaoConstant.URL_DRIVER, DaoConstant.USER_DB, DaoConstant.PASSWORD_DB);
        } catch (SQLException e) {
            System.err.println("Connection is not received");
            e.printStackTrace();
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getInstance() {
        return connection;
    }


}
