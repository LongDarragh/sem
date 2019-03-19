package com.napier.sem;



import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

//@RunWith(Parameterized.class)
public class DatabaseOperationsTest
{
    DatabaseOperations db = new DatabaseOperations();
    public static String s = "SELECT Name FROM city ORDER BY Population DESC";

    @Test
    public void statement() throws NullPointerException
    {
        db.statement(s);
    }

    @Test
    public void connect()
    {
        db.connect();
    }
}
