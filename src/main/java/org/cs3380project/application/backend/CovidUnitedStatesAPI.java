package org.cs3380project.application.backend;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Recovers state data from:                    https://covidtracking.com/
 * Information on the API can be found here:    https://covidtracking.com/data/api
 * Changes to the API can be found here:        https://apichanges.covidtracking.com/
 */
public class  CovidUnitedStatesAPI {

    private static final String uriBase = "https://api.covidtracking.com";

    private static final String statesMetadata = "/v1/states/info.json";
    private static final String specificStateMetadata = "/v1/states/%s/info.json";

    private static final String currentValuesAllStates = "/v1/states/current.json";
    private static final String historicValuesAllStates = "/v1/states/daily.json";

    private static final String currentValuesSingleState = "/v1/states/%s/current.json";
    private static final String historicValuesSingleState = "/v1/states/%s/daily.json";

    private static JSONObject getJsonObject(String target) {
        return getJSONObjectHelper(uriBase + target);
    }

    private static JSONObject getJsonObject(String target, String state) {
        return getJSONObjectHelper(uriBase + String.format(target, state.toLowerCase()));
    }

    private static JSONObject getJSONObjectHelper(String uriComplete) {
        System.out.printf("Request URI %s\n", uriComplete);

        try {
            int responseCode = -999;
            int counter = -1;
            URL url = new URL(uriComplete);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            do {
                conn.setRequestMethod("GET");
                conn.connect();
                responseCode = conn.getResponseCode();
                System.out.printf("Response Code: %d\n", responseCode);

                counter ++;
            } while(responseCode != 200 && counter < 3);

            if (responseCode != 200)
                return null;





            System.out.println("Reading lines");
            String jsonResponse = null;

            InputStream stream = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            try{
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                jsonResponse = response.toString();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            } finally {
                br.close();
                stream.close();
            }

            if (jsonResponse == null)
                return null;

            if (jsonResponse.charAt(0) != '{'){
                System.out.println("Some trimming needed.");
                jsonResponse = jsonResponse.substring(1, jsonResponse.length() - 1);
            }

            System.out.println("Done, returning");

            return new JSONObject(jsonResponse);
        } catch (Exception e) {
            // Display error message.
            System.out.println(e.getMessage());
        }

        return null;
    }


    public static JSONObject getStatesMetadata(){
        return getJsonObject(statesMetadata);
    }

    public static JSONObject specificStateMetadata(String state){
        return getJsonObject(specificStateMetadata, state);
    }

    public static JSONObject currentValuesSingleState(String state){
        return getJsonObject(currentValuesSingleState, state);
    }

    public static JSONObject historicValuesSingleState(String state){
        return getJsonObject(historicValuesSingleState, state);
    }

    public static JSONObject currentValuesAllStates(){
        return getJsonObject(currentValuesAllStates);
    }

    public static JSONObject historicValuesAllStates(){
        return getJsonObject(historicValuesAllStates);
    }




}
