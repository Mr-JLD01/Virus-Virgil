package org.cs3380project.application.backend;

import org.json.JSONObject;
import org.junit.jupiter.api.*;

public class CovidUnitedStatesAPITest {
    @DisplayName("Covid United States API test")

    @Test
    public void specificStateMetadataTest() {
        System.out.println("====== 2 - TEST GET LOUISIANA STATE METADATA EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.specificStateMetadata("LA");
        Assertions.assertNotNull(result);
    }

    @Test
    public void currentValuesSingleStateTest() {
        System.out.println("====== 3 - TEST GET LOUISIANA CURRENT VALUES EXECUTED =======");
        JSONObject result = CovidUnitedStatesAPI.currentValuesSingleState("LA");
        Assertions.assertNotNull(result);
    }
}