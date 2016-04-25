package com.sokrates.mobileTeacherAssistent.utils;


import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class ConnectUtils {

    private static final int TIMEOUT_DELAY = 30000;

    public static String  performPostCall(String requestURL,
                                   HashMap<String, String> postDataParams) {

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpsURLConnection  conn = (HttpsURLConnection) url.openConnection();
            //HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIMEOUT_DELAY);
            conn.setConnectTimeout(TIMEOUT_DELAY);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));
            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    private static String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    public static String updateToken(String requestURL, HashMap<String, String> postDataParams){

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(requestURL).openConnection();

            InputStream in = new BufferedInputStream(httpURLConnection.getInputStream());

            String data = JSONParser.readStream(in);
            JSONObject object = new JSONObject(data);
            if(object.getString("value") != null){
                return object.getString("value");
            }

        } catch (IOException e) {
            Log.e("ERROR", e.toString());
        } catch (JSONException e) {
            Log.e("ERROR", e.toString());
        }
        return null;
    }

}
