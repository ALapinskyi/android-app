package com.sokrates.mobileTeacherAssistent.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class JSONParser {

    public static ArrayList<Object> parseToList(String inputStream, Class<?> object)  {

        ArrayList<Object> data = null;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        try {
            JSONArray jArray = new JSONArray(inputStream);
            data = new ArrayList();

            for (int i = 0; i < jArray.length(); i++) {
                Object obj = gson.fromJson(String.valueOf(jArray.getJSONObject(i)), object);
                data.add(obj);
            }
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        }
        return data;
    }

    public static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer data = new StringBuffer("");
        String line = "";
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            line = reader.readLine();
            /*while (line != null) {
                data.append(line);
            }*/
        } catch (IOException e) {
            Log.e("ERROR", e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("ERROR", e.toString());
                }
            }
        }
        //return data.toString();
        return line;
    }
}
