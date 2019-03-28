package com.napier.sem;



import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseOperationsTest
{
    DatabaseOperations db = new DatabaseOperations();

    @Test
    public void statementCountry() throws NullPointerException, SQLException, IndexOutOfBoundsException
    {
        db.connect("192.168.99.100:33060");
        ArrayList<Country> al =  db.statementCountry("SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC");
        assertEquals(al.get(0).getName(), "China");
    }
}
