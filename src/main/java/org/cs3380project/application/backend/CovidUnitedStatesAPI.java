John Luke Denny, Corin Canepa, Nicholas Levergne, Brian Tsai
package org.cs3380project.application.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * Recovers state data from:                    https://covidtracking.com/
 * Information on the API can be found here:    https://covidtracking.com/data/api
 * Changes to the API can be found here:        https://apichanges.covidtracking.com/
 */
public class CovidUnitedStatesAPI {

    private static final String urlBase = "https://api.covidtracking.com";

    private static final String specificStateMetadata = "/v1/states/%s/info.json";
    private static final String currentValuesSingleState = "/v1/states/%s/current.json";
    private static final String historicValuesSingleState = "/v1/states/%s/daily.json";


    /**
     * Does the heavy lifting of creating the API request, retrieving and interpreting response, and returning data
     * @param target String path to append
     * @param state State to format URL path with
     * @return JSONObject with data, null otherwise
     */
    private static JSONObject getJSONObjectHelper(String target, String state) {
        // Builds entire URL from URL base and formatted URL path
        String urlComplete = urlBase + String.format(target, state.toLowerCase());
        try {
            int responseCode;
            int counter = 0;
            URL url = new URL(urlComplete);
            HttpURLConnection conn = null;

            // Makes, at a maximum, three response requests before giving up
            do {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                responseCode = conn.getResponseCode();
                counter ++;
            } while(responseCode != 200 && counter < 3);

            // If response code is not 'OK'
            if (responseCode != 200)
                return null;


            String jsonResponse = null;

            // Open input stream to URL
            InputStream stream = url.openStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
                try {
                    // Read through entire downloadable response and store in a string
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    jsonResponse = response.toString();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    // Shut down all streams when everything is done/crashed
                    br.close();
                    stream.close();
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }

            // If no jsonResponse, return null
            if (jsonResponse == null)
                return null;

            JSONObject returnJSON = null;
            try {
                // Attempts to build a JSON object from the JSON response
                returnJSON = new JSONObject(jsonResponse);
            } catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }

            return returnJSON;
        } catch (Exception e) {
            // Display error message.
            System.out.println(e.getMessage());
        }

        return null;
    }


    /**
     * Returns information about how and where the database retrieves information from a specific state
     * @param state State to retrieve information about
     * @return JSONObject with data, null otherwise
     */
    public static JSONObject specificStateMetadata(String state){
        return getJSONObjectHelper(specificStateMetadata, state);
    }

    /**
     * Returns the most recent COVID-19 data for a specific state
     * @param state State to retrieve data about
     * @return JSONObject with data, null otherwise
     */
    public static JSONObject currentValuesSingleState(String state){
        return getJSONObjectHelper(currentValuesSingleState, state);
    }
}
