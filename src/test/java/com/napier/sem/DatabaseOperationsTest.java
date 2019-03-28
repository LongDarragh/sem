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
        db.connect("localhost:33060"); //Database only connects in travis if IP is localhost but when ran locally must be 192.168.99.100
        ArrayList<Country> al =  db.statementCountry("SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC");
        assertEquals(al.get(0).getName(), "China"); //Passes if the first Name in the ArrayList is "China"
    }

    @Test
    public void statementCity() throws NullPointerException, IndexOutOfBoundsException
    {
        db.connect("localhost:33060"); //Database only connects in travis if IP is localhost but when ran locally must be 192.168.99.100
        ArrayList<City> al =  db.statementCity("SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC");
        assertEquals(al.get(0).getName(), "Mumbai (Bombay)"); //Passes if the first Name in the ArrayList is "Mumbai (Bombay)"
    }
}
