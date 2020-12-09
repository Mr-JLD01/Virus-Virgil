package org.cs3380project.application.backend;

import org.json.JSONObject;
import org.junit.jupiter.api.*;

public class CovidUnitedStatesAPITest {
    @DisplayName("Covid United States API test")

    //@Disabled
    @Test
    public void getStatesMetadataTest() {
        System.out.println("====== 1 - TEST GET STATES METADATA EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.getStatesMetadata();
        Assertions.assertNotNull(result);
    }

    //@Disabled
    @Test
    public void specificStateMetadataTest() {
        System.out.println("====== 2 - TEST GET LOUISIANA STATE METADATA EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.specificStateMetadata("LA");
        Assertions.assertNotNull(result);
    }

    //@Disabled
    @Test
    public void currentValuesSingleStateTest() {
        System.out.println("====== 3 - TEST GET LOUISIANA CURRENT VALUES EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.currentValuesSingleState("LA");
        Assertions.assertNotNull(result);
    }

    //@Disabled
    @Test
    public void historicValuesSingleStateTest() {
        System.out.println("====== 4 - TEST GET LOUISIANA HISTORICAL VALUES EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.historicValuesSingleState("LA");
        Assertions.assertNotNull(result);
    }

    //@Disabled
    @Test
    public void currentValuesAllStatesTest() {
        System.out.println("====== 5 - TEST GET CURRENT VALUES ALL STATES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.currentValuesAllStates();
        Assertions.assertNotNull(result);
    }

    // Note that this test, for some reason, takes some time to begin
    //@Disabled
    @Test
    public void historicValuesAllStatesTest() {
        System.out.println("====== 6 - TEST GET HISTORIC VALUES ALL STATES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.historicValuesAllStates();
        Assertions.assertNotNull(result);
    }

}