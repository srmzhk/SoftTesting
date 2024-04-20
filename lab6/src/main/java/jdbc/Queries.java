package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
    private Connector connector;

    public Queries(Connector connector) {
        this.connector = connector;
    }

    public void getBrandsByClockType(String clockType) {
        try{
            PreparedStatement preparedStatement = connector.getConnection()
                    .prepareStatement("SELECT DISTINCT Brand FROM Clocks WHERE ClockType = ?");
            preparedStatement.setString(1, clockType);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Select brand by ClockType: " + clockType);
            while (resultSet.next()) {
                String brand = resultSet.getString("Brand");
                System.out.println(brand);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getClocksWherePriceLowerThan(float price) throws SQLException {
        try{
            PreparedStatement preparedStatement = connector.getConnection()
                    .prepareStatement("SELECT * FROM Clocks WHERE Price <= ?");
            preparedStatement.setFloat(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Clocks info where price lower than " + price + "$");
            while (resultSet.next()) {
                int clockID = resultSet.getInt("ClockID");
                String brand = resultSet.getString("Brand");
                String clockType = resultSet.getString("ClockType");
                float clockPrice = resultSet.getFloat("Price");
                int amount = resultSet.getInt("Amount");
                int producerID = resultSet.getInt("ProducerID");
                System.out.println("ClockID: " + clockID + ", Brand: " + brand + ", ClockType: " + clockType +
                        ", Price: " + clockPrice + ", Amount: " + amount + ", ProducerID: " + producerID);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBrandsInCurrentCountry(String country) throws SQLException{
        try{
            PreparedStatement preparedStatement = connector.getConnection()
                    .prepareStatement("SELECT DISTINCT c.Brand FROM Clocks c JOIN Producers p ON c.ProducerID = p.ProducerID WHERE p.Country = ?");
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Clocks brands where producer country is " + country);
            while (resultSet.next()) {
                String brand = resultSet.getString("Brand");
                System.out.println(brand);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getProducersWhereClocksTotalPriceLowerThan(float maxTotalPrice) throws SQLException {
        try{
            PreparedStatement preparedStatement = connector.getConnection()
                    .prepareStatement("SELECT p.ProducerName, SUM(c.Price * c.Amount) AS TotalPrice FROM Producers p JOIN Clocks c ON p.ProducerID = c.ProducerID GROUP BY p.ProducerID, p.ProducerName HAVING SUM(c.Price * c.Amount) <= ?");
            preparedStatement.setFloat(1, maxTotalPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Producers where clocks total price lower than " + maxTotalPrice + "$");
            while (resultSet.next()) {
                String producerName = resultSet.getString("ProducerName");
                double totalPrice = resultSet.getDouble("TotalPrice");
                System.out.println("Producer: " + producerName + ", Total Price: " + totalPrice);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
