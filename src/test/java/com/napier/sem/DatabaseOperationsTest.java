package com.napier.sem;



import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseOperationsTest
{
    DatabaseOperations db = new DatabaseOperations();

    @Test
    public void statementCountry() throws NullPointerException, IndexOutOfBoundsException
    {
        db.connect("192.168.99.100:33060");
        ArrayList<Country> al =  db.statementCountry("SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC");
        assertEquals(al.get(0).getName(), "China");
    }

    @Test
    public void statementCity() throws NullPointerException, IndexOutOfBoundsException
    {
        db.connect("192.168.99.100:33060");
        ArrayList<City> al =  db.statementCity("SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC");
        assertEquals(al.get(0).getName(), "Mumbai (Bombay)");
    }
}
