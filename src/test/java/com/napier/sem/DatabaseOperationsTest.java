package com.napier.sem;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

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
    @Mock
    private DatabaseOperations db;

    private String s;


    @Before
    public void setUp() throws Exception
    {
        assertNotNull(dm);
        Mockito.when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        //Mockito.when(dm.getConnection()).thenReturn(c);

        Mockito.when(db.statement(any(String.class))).thenReturn(s);
    }

    @Test
    public void statement()
    {
        String s = "SELECT Name FROM city ORDER BY Population DESC";
        db.statement(s);
        assertEquals(s,s);
    }

    @Test
    public void connect()
    {
        db.connect();
    }

    @Test
    public void disconnect()
    {
        db.disconnect();
    }
}
