package com.napier.sem;

import org.junit.Test;

import java.util.ArrayList;

public class AppTest
{
    App app = new App();

    @Test
    public void country()
    {
        ArrayList<Country> ALcountry = new ArrayList<>();
        ALcountry.add(new Country("a","b","c","d",1));
        app.printCountry(1, ALcountry);
    }

    @Test
    public void city()
    {
        ArrayList<City> ALcity = new ArrayList<>();
        ALcity.add(new City("d","g","4",1));
        app.printCity(1, ALcity);
    }
}
