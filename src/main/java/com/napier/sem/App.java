package com.napier.sem;


import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static DatabaseOperations db1 = new DatabaseOperations();
    public static void main(String[] args)
    {
        String country ="SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
        String countryContinent ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Europe' ORDER BY Population DESC";
        String countryRegion ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Central Africa' ORDER BY Population DESC";

        String city ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";
        String cityContinent ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Continent = 'Europe' ORDER BY Population DESC";
        String cityRegion ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Region = 'Central Africa' ORDER BY Population DESC";
        String cityCountry ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE country.Name = 'Italy' ORDER BY Population DESC";
        String cityDistrict ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE District = 'England' ORDER BY Population DESC";


        ArrayList<Country> ALcountry;
        ArrayList<City> ALcity;

        db1.connect("192.168.99.100:33060");

        int n = 0;
        Scanner sc = new Scanner(System.in);





        //COUNTRIES


        System.out.println("\n \n \n Countries of the world. \n \n \n");
        ALcountry = db1.statementCountry(country);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Countries of Europe. \n \n \n");
        ALcountry = db1.statementCountry(countryContinent);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Countries of Central Africa. \n \n \n");
        ALcountry = db1.statementCountry(countryRegion);
        for(int i = 0; i < ALcountry.size(); i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }





        //TOP n COUNTRIES



        System.out.println("\n \n \n Type the number of countries to be displayed for the world.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Countries of the world. \n \n \n");
        ALcountry = db1.statementCountry(country);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of countries to be displayed for Europe.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Countries of Europe. \n \n \n");
        ALcountry = db1.statementCountry(countryContinent);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of countries to be displayed for Central Africa.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Countries of Central Africa. \n \n \n");
        ALcountry = db1.statementCountry(countryRegion);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcountry.get(i).getCode() + " ");
            System.out.print(ALcountry.get(i).getName() + " ");
            System.out.print(ALcountry.get(i).getContinent() + " ");
            System.out.print(ALcountry.get(i).getRegion() + " ");
            System.out.print(ALcountry.get(i).getPopulation() + "\n");
        }





        //CITIES




        System.out.println("\n \n \n Cities of the world. \n \n \n");
        ALcity = db1.statementCity(city);
        for(int i = 0; i < ALcity.size(); i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Cities of Europe. \n \n \n");
        ALcity = db1.statementCity(cityContinent);
        for(int i = 0; i < ALcity.size(); i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Cities of Central Africa. \n \n \n");
        ALcity = db1.statementCity(cityRegion);
        for(int i = 0; i < ALcity.size(); i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Cities of Italy. \n \n \n");
        ALcity = db1.statementCity(cityCountry);
        for(int i = 0; i < ALcity.size(); i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Cities of England. \n \n \n");
        ALcity = db1.statementCity(cityDistrict);
        for(int i = 0; i < ALcity.size(); i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }






        //TOP n CITIES


        System.out.println("\n \n \n Type the number of cities to be displayed for the world.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Cities of the world. \n \n \n");
        ALcity = db1.statementCity(city);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of cities to be displayed for Europe.");
        n = sc.nextInt();

        System.out.println("\n \n \n  Top " + n + " Cities of Europe. \n \n \n");
        ALcity = db1.statementCity(cityContinent);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of cities to be displayed for Central Africa.");
        n = sc.nextInt();

        System.out.println("\n \n \n  Top " + n + " Cities of Central Africa. \n \n \n");
        ALcity = db1.statementCity(cityRegion);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of cities to be displayed for Italy.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Cities of Italy. \n \n \n");
        ALcity = db1.statementCity(cityCountry);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }

        System.out.println("\n \n \n Type the number of cities to be displayed for England.");
        n = sc.nextInt();

        System.out.println("\n \n \n Top " + n + " Cities of England. \n \n \n");
        ALcity = db1.statementCity(cityDistrict);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ALcity.get(i).getName() + " ");
            System.out.print(ALcity.get(i).getCountry() + " ");
            System.out.print(ALcity.get(i).getDistrict() + " ");
            System.out.print(ALcity.get(i).getPopulation() + "\n");
        }


        System.out.println("End.");

        db1.disconnect();
    }
}



