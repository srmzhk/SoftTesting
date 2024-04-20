package jdbc;

import java.sql.DriverManager;
import java.sql.*;

public class Release1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connector connector = new Connector();
            connector.openConnection("localhost:5432/jdbc", "postgres", "133464213");
            Queries queries = new Queries(connector);
            queries.getBrandsByClockType("quartz");
            queries.getBrandsByClockType("mechanical");
            queries.getClocksWherePriceLowerThan(7000f);
            queries.getClocksWherePriceLowerThan(100f);
            queries.getClocksWherePriceLowerThan(1000f);
            queries.getBrandsInCurrentCountry("Switzerland");
            queries.getBrandsInCurrentCountry("Japan");
            queries.getBrandsInCurrentCountry("France");
            queries.getProducersWhereClocksTotalPriceLowerThan(300000f);
            queries.getProducersWhereClocksTotalPriceLowerThan(52000f);
            queries.getProducersWhereClocksTotalPriceLowerThan(10000f);
            connector.closeConnection();
        }
        catch (SQLException e ) {
            e.printStackTrace();
        }
    }
}
