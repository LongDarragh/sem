package com.napier.sem;


public class App
{
    public static void main(String[] args)
    {
        String continent="Europe";
        String query1="SELECT Name FROM city ORDER BY Population DESC";
        DatabaseOperations db1 = new DatabaseOperations();

        db1.connect();

        db1.statement(query1);



        db1.disconnect();
    }
}
