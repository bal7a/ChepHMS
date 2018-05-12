package com.ziizii.hallmanagementsystem.DataBaseManager;

import android.os.AsyncTask;
import android.util.Log;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class POSTManager extends AsyncTask<Day, Void, Void>
{
    protected static String jsonify(Day day)
    {
        String returnJSON = "";
        returnJSON += "{" +
                        "\"halls\":{" +
                            "\"hall\":[";
        for(int hallIndex = 0; hallIndex < day.getHalls().length; hallIndex++)
        {
            if(hallIndex > 0)
                returnJSON += ",";

            returnJSON += "{\"hallName\":\"" + day.getHalls()[hallIndex].getHallName() + "\"," +
                            "\"slots\":[";
            for(int slotIndex = 0; slotIndex < day.getHalls()[hallIndex].getSlots().length; slotIndex++)
            {
                if(slotIndex > 0)
                    returnJSON += ",";

                returnJSON += "{" +
                        "\"slot\":\"" + day.getHalls()[hallIndex].getSlots()[slotIndex].getSlotPosition() + "\"," +
                        "\"isEmpty\":\"" + day.getHalls()[hallIndex].getSlots()[slotIndex].isEmpty() + "\"," +
                        "\"courseNumber\":\"" + day.getHalls()[hallIndex].getSlots()[slotIndex].getCourseCode() + "\"," +
                        "\"Lecture\":\"" + day.getHalls()[hallIndex].getSlots()[slotIndex].isLecture() + "\"" +
                        "}";
            }

            returnJSON += "]}";
        }

        returnJSON += "]}}";
        return returnJSON;
    }

    @Override
    protected Void doInBackground(Day... days)
    {
        try {
            URL url = new URL("/testing/Saturday.json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
            outputStreamWriter.write(jsonify(days[0]));
            outputStreamWriter.flush();
            urlConnection.disconnect();
            Log.i("POST", "Post Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

