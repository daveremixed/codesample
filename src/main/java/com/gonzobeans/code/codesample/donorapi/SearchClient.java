package com.gonzobeans.code.codesample.donorapi;

import static com.gonzobeans.code.codesample.util.ApplicationConstants.DONOR_API_TARGET;

import com.gonzobeans.code.codesample.util.Logging;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Dave on 1/29/2017.
 */
public class SearchClient implements Logging {

    public Response search(SearchRequest searchRequest) {
        ResteasyClient client = new ResteasyClientBuilder().build();

        MultivaluedMap<String, Object> queryParameters = new MultivaluedMapImpl<>();
        for (Map.Entry<String, String> parameter : searchRequest.getQueryParameters().entrySet()) {
            if (parameter.getValue() != null) {
                queryParameters.put(parameter.getKey(), Arrays.asList(parameter.getValue()));
            }
        }

        ResteasyWebTarget target = client.target(DONOR_API_TARGET).queryParams(queryParameters);
        LOG.info("TargetURI=" + target.getUri());
        return target.request().get();
    }
}
