package com.napier.sem;



import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseOperationsTest
{
    DatabaseOperations db = new DatabaseOperations();
    public static String s = "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";

    @Test
    public void statementCountry() throws NullPointerException, SQLException
    {
        ArrayList<Country> al = new ArrayList<>();
        db.statementCountry("SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC");

    }

    @Test
    public void connect()
    {
        db.connect("localhost:3306");
    }
}
