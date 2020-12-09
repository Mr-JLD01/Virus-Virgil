package org.cs3380project.application.backend;

import java.io.BufferedReader;
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
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        System.out.printf("Request URI %s\n", uriComplete);

        try {
            URL url = new URL(uriComplete);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.printf("Response Code: %d\n", responsecode);

            String inline = "";
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext())
                inline +=sc.nextLine();
            sc.close();

            return new JSONObject(inline);

            /**
            URI uri = new URIBuilder(uriComplete).build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Content-Type", "application/json");

            // Call the REST API method and get the response entity.
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Format and display the JSON response.
                String jsonString = EntityUtils.toString(entity);
                System.out.printf("JSONString %s\n", jsonString);
                return new JSONObject(jsonString);
            }
             */
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

    public static JSONObject currentValuesAllStates(){
        return getJsonObject(currentValuesAllStates);
    }

    public static JSONObject historicValuesAllStates(){
        return getJsonObject(historicValuesAllStates);
    }

    public static JSONObject currentValuesSingleState(String state){
        return getJsonObject(currentValuesSingleState, state);
    }

    public static JSONObject historicValuesSingleState(String state){
        return getJsonObject(historicValuesSingleState, state);
    }





}
