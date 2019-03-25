package com.napier.sem;

public class Country
{
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;

    public Country(String code,
            String name,
            String continent,
            String region,
            int population)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
    }

    /*public void setCode(String code)
    {
        this.code = code;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setContinent(String continent)
    {
        this.continent = continent;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }
    public void setPopulation(int population)
    {
        this.population = population;
    }*/

    public String getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }
    public String getContinent()
    {
        return continent;
    }
    public String getRegion()
    {
        return region;
    }
    public int getPopulation()
    {
        return population;
    }

}
