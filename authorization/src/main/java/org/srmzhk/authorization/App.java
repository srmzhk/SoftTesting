package org.srmzhk.authorization;

import MyExceptions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class App
{
    private Connector connector;
    private Scanner scanner;
    private String login;
    private String pass;
    private String phrase;
    private int code;

    {
        try {
            scanner = new Scanner(System.in);
            connector = new Connector();
            connector.openConnection("localhost:5432/auth", "postgres", "133464213");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void start() {
        try {
            System.out.println("\nHello in Authorization app\n");
            System.out.println("Enter correct data to authorization in your admin account");
            System.out.print("Login: ");
            login = scanner.nextLine();
            checkLogin();
            System.out.println("\nGreat! Next examination is password...");
            System.out.print("Password: ");
            pass = scanner.nextLine();
            checkPassword();
            System.out.println("\nDamn man! You are so smart! Do you remember your secret phrase???");
            System.out.print("Phrase: ");
            phrase = scanner.nextLine();
            checkPhrase();
            System.out.println("\nOH MY GOSH! No words anymore just next examination.");
            System.out.print("Code: ");
            checkCode(scanner.nextLine());
            System.out.println("\nSHUUUUUUUUIIIIIIIII! UNBRLIEVABLY!!! And the last one...");
            System.out.print("Guess the number between 0 and 1: ");
            checkNumber(Integer.parseInt(scanner.nextLine()));
            System.out.println("Succe... 404 NOT FOUND.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            if(tryAgain())
                start();
        }
    }

    public boolean tryAgain() {
        System.out.print("Want to try again?\n(Y/N): ");
        return scanner.nextLine().toLowerCase().equals("y");
    }

    public String getValueByColumnName(String columnName) throws SQLException{
        String query = "SELECT * FROM users";
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getString(columnName);
    }

    public void checkLogin() throws SQLException, LoginException {
        if (login == "")
            throw new LoginException("login can't be empty!");
        if (!login.equals(getValueByColumnName("UserLogin")))
            throw new LoginException("login not match!");
    }

    public void checkPassword() throws SQLException, PasswordException {
        if (pass == "")
            throw new PasswordException("password can't be empty!");
        if (!pass.equals(getValueByColumnName("UserPassword")))
            throw new PasswordException("password not match!");
    }

    public void checkPhrase() throws SQLException, PhraseException {
        if (phrase == "")
            throw new PhraseException("phrase can't be empty!");
        if (!phrase.equals(getValueByColumnName("Phrase")))
            throw new PhraseException("phrase not match!");
    }

    public void checkCode(String str) throws SQLException, CodeException, NumberFormatException {
        code = Integer.parseInt(str);
        if (code != Integer.parseInt(getValueByColumnName("Code")))
            throw new CodeException("code not match!");
    }

    public void checkNumber(int num) throws RandomException {
        Random random = new Random();
        if(num != random.nextInt(2))
            throw new RandomException("No no no...");
    }
}
