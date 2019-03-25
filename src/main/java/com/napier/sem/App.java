package com.napier.sem;


public class App
{
    public static void main(String[] args)
    {
        String query1="SELECT Code, Name FROM city WHERE Continent = ? ORDER BY Population DESC";
        DatabaseOperations db1 = new DatabaseOperations();

        db1.connect();

        db1.statement(query1);



        db1.disconnect();
    }
}
