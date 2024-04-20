package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    private Connection connection;
    private String url;
    private String user;
    private String pass;

    public void openConnection(String url, String user, String pass) throws SQLException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        if(connection == null)
            connection = setConnection();
        else
            System.out.println("Connection is already open");
    }

    public void closeConnection() throws SQLException {
        if(!connection.isClosed())
            connection.close();
        else
            System.out.println("Connection is already closed");
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection setConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("org.postgresql.Driver class not found");
        }
        return DriverManager.getConnection("jdbc:postgresql://" + this.url, this.user, this.pass);
    }
}
