package com.ziizii.hallmanagementsystem.DataBaseManager;


public class Day
{
    private Hall[] halls = new Hall[28];
    private String dayName;

    public Day(String dayName)
    {
        this.dayName = dayName;
    }

    public Hall[] getHalls()
    {
        return halls;
    }

    public void setHalls(Hall[] halls)
    {
        this.halls = halls;
    }

    public void setHall(int i, Hall hall)
    {
        this.halls[i] = hall;
    }
}
