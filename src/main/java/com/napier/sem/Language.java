package com.napier.sem;

public class Language
{
    private String language;
    private String number;
    private String percentage;


    public Language(String language,
                   String number,
                   String percentage)
    {
        this.language = language;
        this.number = number;
        this.percentage = percentage;
    }

    public String getLanguage()
    {
        return language;
    }
    public String getNumber()
    {
        return number;
    }
    public String getPercentage()
    {
        return percentage;
    }
}
