package com.napier.sem;



import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseOperationsTest
{
    @Mock
    private DriverManager dm;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;
    //@Mock
   // private DatabaseOperations db;
    DatabaseOperations db = new DatabaseOperations();
    public static String s = "SELECT Name FROM city ORDER BY Population DESC";


    @BeforeAll
    public void setUp() throws Exception
    {
        assertNotNull(dm);
        Mockito.when(dm.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example")).thenReturn(c);
    }

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
