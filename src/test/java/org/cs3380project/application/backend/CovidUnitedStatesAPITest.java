package org.cs3380project.application.backend;

import org.json.JSONObject;
import org.junit.jupiter.api.*;

public class CovidUnitedStatesAPITest {
    @DisplayName("Covid United States API test")

    //@Disabled
    @Test
    public void getStatesMetadata() {
        System.out.println("======TEST GET STATES METADATA EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.getStatesMetadata();
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }

    @Disabled
    @Test
    public void specificStateMetadata() {
        System.out.println("======TEST GET LOUISIANA STATE METADATA EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.specificStateMetadata("LA");
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }

    @Disabled
    @Test
    public void currentValuesAllStates() {
        System.out.println("======TEST GET CURRENT VALUES ALL STATES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.currentValuesAllStates();
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }

    @Disabled
    @Test
    public void historicValuesAllStates() {
        System.out.println("======TEST GET HISTORIC VALUES ALL STATES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.historicValuesAllStates();
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }

    @Disabled
    @Test
    public void currentValuesSingleState() {
        System.out.println("======TEST GET LOUISIANA CURRENT VALUES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.currentValuesSingleState("LA");
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }

    @Disabled
    @Test
    public void historicValuesSingleState() {
        System.out.println("======TEST GET LOUISIANA HISTORICAL VALUES EXECUTED=======");
        JSONObject result = CovidUnitedStatesAPI.historicValuesSingleState("LA");
        Assertions.assertNotNull(result);
        System.out.println(result);
        System.out.println("\n\n\n\n");
    }







}