 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import org.json.JSONObject;

/*
 * Uses the CovidStateAPI's json object to create a dictionary of the various disease values
 */
public class Covid19
{
    
    private HashMap<String, String> data; //dictionary to store disease data
    

    /**
     * @param data dictionary
     * Constructor for objects of class Covid19
     */
    public Covid19(JsonObject json)
    {
        // initialise instance variables
        data = jsonToMap(json);
    }
    
    //converts a json object into a dictionary
    private HashMap<String, String> jsonToMap(JsonObject json) {
        HashMap<String, String> retMap = new HashMap<String, String>();

        if(json != JsonObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    //used in tandum with jsonToMap to make a dictionary with a json object
    private HashMap<String, String> toMap(JsonObject object) throws JsonException {
        HashMap<String, String> map = new HashMap<String, String>();

        Iterator<String> keysItr = object.keySet().iterator();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            String value = object.get(key);

            if(value instanceof JsonArray) {
                value = toList((JsonArray) value);
            }

            else if(value instanceof JsonObject) {
                value = toMap((JsonObject) value);
            }
            map.put(key, value);
        }
        return map;
    }
    
    /*
     * below are the key values needing to be ruturned from the dictionary
     */
    public String getCases(){
        return data.get("positive");
    }
    
    public String getDeaths(){
        return data.get("deathConfirmed");
    }
    
    public String getHospitalizations(){
        return data.get("hospitalizedCurrently");
    }
}
