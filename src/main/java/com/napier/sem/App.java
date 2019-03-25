package com.napier.sem;


import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {

        String country ="SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
        String countryContinent ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Europe' ORDER BY Population DESC";
        String countryRegion ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Central Africa' ORDER BY Population DESC";

        String city ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";
        String cityContinent ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Continent = Europe ORDER BY Population DESC";
        String cityRegion ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Region = Central Africa ORDER BY Population DESC";
        String cityCountry ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode WHERE country.Name = Italy ORDER BY Population DESC";
        String cityDistrict ="SELECT Name, country.Name, District, Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";

        DatabaseOperations db1 = new DatabaseOperations();
        ArrayList<Country> ALcountry;

        db1.connect();

        System.out.println("\n \n \n Countries of the world. \n \n \n");
        ALcountry = db1.statement(country);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Countries of Europe. \n \n \n");
        ALcountry = db1.statement(countryContinent);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Countries of Central Africa. \n \n \n");
        ALcountry = db1.statement(countryRegion);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        db1.disconnect();
    }
}

