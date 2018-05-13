package com.ziizii.hallmanagementsystem.DataBaseManager;

import android.os.AsyncTask;
import android.util.Log;

import com.ziizii.hallmanagementsystem.Search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Manager extends AsyncTask<String, Integer, Void>
{
    static Day[] days = new Day[6];
    String downloadedJSON = "";

    private static Day deJsonDay (JSONObject dayRep)
    {
        Day newDay = new Day();
        try {
            newDay.setHalls(deJsonHallArr(dayRep.getJSONArray("hall")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newDay;
    }

    private static Hall[] deJsonHallArr(JSONArray hallArrRep)
    {
        Hall[] hallArr = new Hall[hallArrRep.length()];
        for(int i = 0; i < hallArr.length; i++)
        {
            try {
                hallArr[i] = deJsonHall(hallArrRep.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hallArr;
    }

    private static Hall deJsonHall (JSONObject hallRep)
    {
        Hall newHall = new Hall();
        try {
            newHall.setHallName(hallRep.getString("hallName"));
            newHall.setSlots(deJsonSlotArr(hallRep.getJSONArray("slots")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newHall;
    }

    private static Slot[] deJsonSlotArr(JSONArray slotArrRep)
    {
        Slot[] slotArr = new Slot[slotArrRep.length()];
        for(int i = 0; i < slotArr.length; i++)
        {
            try {
                slotArr[i] = deJsonSlot(slotArrRep.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return slotArr;
    }

    private static Slot deJsonSlot(JSONObject slotRep)
    {
        try {
            return new Slot(slotRep.getInt("slot"), slotRep.getBoolean("isEmpty"), slotRep.getString("courseNumber"), slotRep.getBoolean("Lecture"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Day[] getDayData()
    {
        return days;
    }



    @Override
    protected Void doInBackground(String... strings)
    {
        Log.i("GET", "entered");
        try {
            for(int i = 0; i < strings.length; i ++)
            {
                downloadedJSON = "";
                URL url = new URL(strings[i]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data != -1)
                {
                    char currentChar = (char) data;
                    downloadedJSON += currentChar;
                    data = inputStreamReader.read();
                }
                connection.disconnect();
                Log.i("GET", String.valueOf(i));
                days[i] = deJsonDay(new JSONObject(downloadedJSON).getJSONObject("halls"));

            }
            Search.setDays(days);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
