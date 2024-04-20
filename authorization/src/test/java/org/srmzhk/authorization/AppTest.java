package org.srmzhk.authorization;

import MyExceptions.*;
import org.postgresql.util.PSQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void tryToCreateStatementWithNullConnection() throws SQLException {
        Connector connector = new Connector();
        connector.createStatement();
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void tryToCloseNullConnection() throws SQLException {
        Connector connector = new Connector();
        connector.getConnection().close();
    }

    @Test
    public void isConnectionClosed() {
        try {
            Connector connector = new Connector();
            connector.openConnection("localhost:5432/auth", "postgres", "133464213");
            connector.getConnection().close();
            Assert.assertTrue(connector.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expectedExceptions = PSQLException.class)
    public void tryToGetDataFromWrongDb() throws SQLException {
        Connector connector = new Connector();
        connector.openConnection("localhost:5432/lab", "postgres", "133464213");
        String sql = "SELECT * FROM Users";
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
    }

    @Test
    public void tryToGetDataFromCurrentDb() throws SQLException {
        Connector connector = new Connector();
        connector.openConnection("localhost:5432/auth", "postgres", "133464213");
        String sql = "SELECT * FROM users";
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Assert.assertNotNull(resultSet);
    }

    @Test(expectedExceptions = SQLException.class)
    public void tryToSelectWrongTable() throws SQLException {
        Connector connector = new Connector();
        connector.openConnection("localhost:5432/auth", "postgres", "133464213");
        String sql = "SELECT * FROM peoples";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
    }

    @Test(expectedExceptions = LoginException.class)
    public void enterLoginAndCheckIt() throws LoginException, SQLException {
        App app = new App();
        app.setLogin("fldflskjlfsd");
        app.checkLogin();
    }

    @Test(expectedExceptions = PasswordException.class)
    public void enterPasswordAndCheckIt() throws PasswordException, SQLException {
        App app = new App();
        app.setPass(null);
        app.checkPassword();
    }

    @Test(expectedExceptions = PhraseException.class)
    public void enterPhraseAndCheckIt() throws PhraseException, SQLException {
        App app = new App();
        app.setPhrase("32189321");
        app.checkPhrase();
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void enterCodeAndCheckIt() throws CodeException, SQLException, NumberFormatException {
        App app = new App();
        app.checkCode("hello World!");
    }

    @Test
    public void enterRandomNumberAndCheckIt() throws RandomException {
        App app = new App();
        app.checkNumber(1);
    }
}
