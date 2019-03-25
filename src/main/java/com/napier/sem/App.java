package com.napier.sem;


public class App
{
    public static void main(String[] args)
    {

        String country ="SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
        String countryContinent ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = Europe ORDER BY Population DESC";
        String countryRegion ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = Central Africa ORDER BY Population DESC";

        String city ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";
        String cityContinent ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Continent = Europe ORDER BY Population DESC";
        String cityRegion ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Region = Central Africa ORDER BY Population DESC";
        String cityCountry ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE country.Name = Italy ORDER BY Population DESC";
        String cityDistrict ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";



        DatabaseOperations db1 = new DatabaseOperations();

        db1.connect();

        db1.statement(country);

        db1.statement(countryContinent);

        db1.statement(countryRegion);

        db1.disconnect();
    }
}
