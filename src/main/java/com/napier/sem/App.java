package com.napier.sem;


import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static DatabaseOperations db1 = new DatabaseOperations();  //Instantiate new DatabaseOperations object

    //ArrayLists for storing results
    static ArrayList<Country> ALcountry;
    static ArrayList<City> ALcity;

    //Stores value for top n queries where n is defined by the user
    static int n = 0;

    //Strings for user defined locations
    static String continent;
    static String region;
    static String district;
    static String userCountry;

    public static void main(String[] args)
    {

        //SQL queries for Counrty reports
        String country ="SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
        String countryContinent ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Europe' ORDER BY Population DESC";
        String countryRegion ="SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Central Africa' ORDER BY Population DESC";

        //SQL queries for City reports
        String city ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode ORDER BY Population DESC";
        String cityContinent ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Continent = 'Europe' ORDER BY Population DESC";
        String cityRegion ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE Region = 'Central Africa' ORDER BY Population DESC";
        String cityCountry ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE country.Name = 'Italy' ORDER BY Population DESC";
        String cityDistrict ="SELECT city.Name, country.Name AS Country, District, city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE District = 'England' ORDER BY Population DESC";


        db1.connect("192.168.99.100:33060"); //Connect to database
        Scanner sc = new Scanner(System.in); //Scanner for top n queries
        Scanner scPlace = new Scanner(System.in); //Scanner for user defined locations



        //ALL COUNTRIES


        //All Countries in the world
        System.out.println("\n \n \n Countries of the world. \n \n \n");
        ALcountry = db1.statementCountry(country);
        printCountry(ALcountry.size(),ALcountry);  //Displays all results from ArrayList


        //All Countries in a continent
        System.out.println("\n \n \n Countries of Europe. \n \n \n");
        ALcountry = db1.statementCountry(countryContinent);
        printCountry(ALcountry.size(),ALcountry);  //Displays all results from ArrayList


        //All Countries in a region
        System.out.println("\n \n \n Countries of Central Africa. \n \n \n");
        ALcountry = db1.statementCountry(countryRegion);
        printCountry(ALcountry.size(),ALcountry); //Displays all results from ArrayList




        //TOP n COUNTRIES


        //Top n Countries in the world
        System.out.println("\n \n \n Type the number of countries to be displayed for the world.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Countries of the world. \n \n \n");
        ALcountry = db1.statementCountry(country);
        printCountry(n,ALcountry); //Displays top n results from ArrayList


        //Top n Countries in a continent
        System.out.println("\n \n \n Type the number of countries to be displayed for Europe.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Countries of Europe. \n \n \n");
        ALcountry = db1.statementCountry(countryContinent);
        printCountry(n,ALcountry); //Displays top n results from ArrayList


        //Top n Countries in a region
        System.out.println("\n \n \n Type the number of countries to be displayed for Central Africa.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Countries of Central Africa. \n \n \n");
        ALcountry = db1.statementCountry(countryRegion);
        printCountry(n,ALcountry); //Displays top n results from ArrayList



        //ALL CITIES


        //All Cities in the world
        System.out.println("\n \n \n Cities of the world. \n \n \n");
        ALcity = db1.statementCity(city);
        printCity(ALcity.size(),ALcity); //Displays all results from ArrayList


        //All Cities in a continent
        System.out.println("\n \n \n Cities of Europe. \n \n \n");
        ALcity = db1.statementCity(cityContinent);
        printCity(ALcity.size(),ALcity); //Displays all results from ArrayList


        //All Cities in a region
        System.out.println("\n \n \n Cities of Central Africa. \n \n \n");
        ALcity = db1.statementCity(cityRegion);
        printCity(ALcity.size(),ALcity); //Displays all results from ArrayList


        //All Cities in a country
        System.out.println("\n \n \n Cities of Italy. \n \n \n");
        ALcity = db1.statementCity(cityCountry);
        printCity(ALcity.size(),ALcity); //Displays all results from ArrayList


        //All Cities in a district
        System.out.println("\n \n \n Cities of England. \n \n \n");
        ALcity = db1.statementCity(cityDistrict);
        printCity(ALcity.size(),ALcity); //Displays all results from ArrayList



        //TOP n CITIES


        //Top n Cities in the world
        System.out.println("\n \n \n Type the number of cities to be displayed for the world.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Cities of the world. \n \n \n");
        ALcity = db1.statementCity(city);
        printCity(n,ALcity); //Displays top n results from ArrayList


        //Top n Cities in a continent
        System.out.println("\n \n \n Type the number of cities to be displayed for Europe.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n  Top " + n + " Cities of Europe. \n \n \n");
        ALcity = db1.statementCity(cityContinent);
        printCity(n,ALcity); //Displays top n results from ArrayList


        //Top n Cities in a region
        System.out.println("\n \n \n Type the number of cities to be displayed for Central Africa.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n  Top " + n + " Cities of Central Africa. \n \n \n");
        ALcity = db1.statementCity(cityRegion);
        printCity(n,ALcity); //Displays top n results from ArrayList


        //Top n Cities in a country
        System.out.println("\n \n \n Type the number of cities to be displayed for Italy.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Cities of Italy. \n \n \n");
        ALcity = db1.statementCity(cityCountry);
        printCity(n,ALcity); //Displays top n results from ArrayList


        //Top n Cities in a district
        System.out.println("\n \n \n Type the number of cities to be displayed for England.");
        n = sc.nextInt(); //User decides how many results to show

        System.out.println("\n \n \n Top " + n + " Cities of England. \n \n \n");
        ALcity = db1.statementCity(cityDistrict); //Populates ArrayList with cities
        printCity(n,ALcity); //Displays top n results from ArrayList


        //Disconnect from database
        db1.disconnect();
        System.out.println("End."); //Signals end of the run
    }

    //Method to display results for City reports
    public static void printCity(int size, ArrayList<City> c)
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(c.get(i).getName() + " ");
            System.out.print(c.get(i).getCountry() + " ");
            System.out.print(c.get(i).getDistrict() + " ");
            System.out.print(c.get(i).getPopulation() + "\n");
        }
    }

    //Method to display results for Country reports
    public static void printCountry(int size, ArrayList<Country> c)
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(c.get(i).getCode() + " ");
            System.out.print(c.get(i).getName() + " ");
            System.out.print(c.get(i).getContinent() + " ");
            System.out.print(c.get(i).getRegion() + " ");
            System.out.print(c.get(i).getPopulation() + "\n");
        }
    }
}



