package com.napier.sem;



import org.junit.Test;

import java.sql.SQLException;


public class DatabaseOperationsTest
{
    DatabaseOperations db = new DatabaseOperations();
    public static String s = "SELECT Name FROM city ORDER BY Population DESC";

    @Test
    public void statement() throws NullPointerException, SQLException
    {
        db.statementCountry(s);
    }

    @Test
    public void connect()
    {
        db.connect();
    }
}
