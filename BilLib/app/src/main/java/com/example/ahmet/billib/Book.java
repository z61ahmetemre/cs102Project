package com.example.ahmet.billib;

/**
 * Created by ahmet on 22.07.2017.
 */

public class Book
{
    String name;
    String author;
    String callNumber;
    String location;

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getCallNumber()
    {
        return callNumber;
    }

    public String getLocation()
    {
        return location;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setCallNumber(String callNumber)
    {
        this.callNumber = callNumber;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
