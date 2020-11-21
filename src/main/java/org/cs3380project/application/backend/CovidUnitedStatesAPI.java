/**
 * Recovers state data from:                    https://covidtracking.com/
 * Information on the API can be found here:    https://covidtracking.com/data/api
 * Changes to the API can be found here:        https://apichanges.covidtracking.com/
 */
package org.cs3380project.application.backend;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class CovidUnitedStatesAPI {
}
