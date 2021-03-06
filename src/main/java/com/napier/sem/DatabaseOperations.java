package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperations
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;


    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+ location +"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public ArrayList<Country> statementCountry(String s) {
        ArrayList<Country> c = new ArrayList<>();
        try
        {
            if( s != null) //Checks if the input String is Null
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(s);

                //Adds results to an ArrayList
                while (rs.next()) {
                    c.add(new Country(rs.getString("Code"), rs.getString("Name"), rs.getString("Continent"), rs.getString("Region"), rs.getInt("Population")));
                }
            }
            else
            {
                System.out.println("No statement found.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to run SQL Query.");
        }
        catch (NullPointerException n)
        {
            System.out.println(n.getMessage());
        }
        return c;
    }

    public ArrayList<City> statementCity(String s) {
        ArrayList<City> c = new ArrayList<>();
        try
        {
            if( s != null) //Checks if the input String is Null
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(s);

                //Adds results to an ArrayList
                while (rs.next()) {
                    c.add(new City(rs.getString("Name"), rs.getString("Country"), rs.getString("District"), rs.getInt("Population")));
                }
            }
            else
            {
                System.out.println("No statement found.");
            }


        }
        catch (SQLException e)
        {
            System.out.println("Failed to run SQL Query.");
        }
        catch (NullPointerException n)
        {
            System.out.println(n.getMessage());
        }
        return c;
    }


    public String statementPopulation(String s) {
        String c = "0";
        try
        {
            if( s != null) //Checks if the input String is Null
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(s);

                //Adds results to an ArrayList
                while (rs.next()) {
                    c = rs.getString(1);
                }
            }
            else
            {
                System.out.println("No statement found.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to run SQL Query.");
        }
        catch (NullPointerException n)
        {
            System.out.println(n.getMessage());
        }
        return c;
    }


    public ArrayList<Language> statementLanguage(String s) {
        ArrayList<Language> c = new ArrayList<>();

        try
        {
            if( s != null) //Checks if the input String is Null
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(s);

                //Adds results to an ArrayList
                while (rs.next()) {
                    c.add(new Language(rs.getString("Language"), rs.getString("Number"), rs.getString("Percentage")));
                }
            }
            else
            {
                System.out.println("No statement found.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to run SQL Query.");
        }
        catch (NullPointerException n)
        {
            System.out.println(n.getMessage());
        }
        return c;
    }
}
