package ru.moondi.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//Добавить на серверную сторону сетевого чата логирование событий (сервер запущен, произошла ошибка, клиент подключился, клиент прислал сообщение/команду).
public class Task3 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "12345678";
    private static Connection connection;
    private static PreparedStatement ps;
    private static Statement statement;

    public Task3() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sqlCreateTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE students(" +
                    "id serial NOT NULL," +
                    "surname text NOT NULL," +
                    "score numeric(1) NOT NULL," +
                    "CONSTRAINT studentid PRIMARY KEY(id))" +
                    "WITH (OIDS = FALSE);" +
                    "ALTER TABLE students OWNER TO postgres;");
            System.out.println("таблица students создана");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean sqlSelectAll(String query) {
        try {
            statement = connection.createStatement();
            return statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int sqlUpdateQuery(String query) {
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
