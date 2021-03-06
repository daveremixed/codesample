package com.gonzobeans.codesample.donorapi;

import com.gonzobeans.codesample.util.Logging;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static com.gonzobeans.codesample.util.ApplicationConstants.DONOR_API_TARGET;

/**
 * Created by Dave on 1/29/2017.
 *
 */
public class SearchClient implements Logging {

    public SearchResponse search(SearchRequest searchRequest) {
        ResteasyClient client = new ResteasyClientBuilder().build();

        MultivaluedMap<String, Object> queryParameters = new MultivaluedMapImpl<>();
        for (Map.Entry<String, Object> parameter : searchRequest.getQueryParameters().entrySet()) {
            if (parameter.getValue() != null) {
                queryParameters.put(parameter.getKey(), Collections.singletonList(parameter.getValue()));
            }
        }

        ResteasyWebTarget target = client.target(DONOR_API_TARGET).queryParams(queryParameters);
        LOG.info("TargetURI=" + target.getUri());
        Response response = target.request().accept(MediaType.TEXT_PLAIN_TYPE).get();
        return getSearchResponse(response.readEntity(String.class));
    }

    // TODO: Unmarshall using Resteasy, then Remove this block of code
    private SearchResponse getSearchResponse(String jsonString) {
        SearchResponse response;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(jsonString, SearchResponse.class);
        } catch (IOException e) {
            LOG.error("Error unmarshalling JSON to Object", e);
            response = new SearchResponse();
        }
        return response;
    }
}
