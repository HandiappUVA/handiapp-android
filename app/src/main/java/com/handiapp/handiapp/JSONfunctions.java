package com.handiapp.handiapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.*;

/**
 * Created by Jason Ashley on 3/24/2018.
 */

public class JSONfunctions {

    public static JSONObject getJSONfromURL(String url) {
        InputStream is = null;
        String result = "";
        JSONObject jArray = null;

        // Download JSON data from URL
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("") //TODO: Get url.
                    .build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonData = responses.body().string();
            JSONObject Jobject = new JSONObject(jsonData);
            JSONArray Jarray = Jobject.getJSONArray("employees");

            for (int i = 0; i < Jarray.length(); i++) {
                JSONObject object     = Jarray.getJSONObject(i);
            }

        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }

        // Convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }

        try {

            jArray = new JSONObject(result);
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jArray;
    }
}
