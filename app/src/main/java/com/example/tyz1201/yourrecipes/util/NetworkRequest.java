package com.example.tyz1201.yourrecipes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class NetworkRequest {

    public static String getRequestData(String netStr) {
        BufferedReader br = null;
        String getDatas = "";
        try {
            URL url = new URL(netStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                getDatas = line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getDatas;
    }
}