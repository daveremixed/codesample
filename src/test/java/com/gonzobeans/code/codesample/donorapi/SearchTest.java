package com.gonzobeans.code.codesample.donorapi;

import org.junit.Test;

import javax.ws.rs.core.Response;


import static com.gonzobeans.code.codesample.util.StateAbbreviations.CALIFORNIA;

/**
 * Created by Dave on 1/29/2017.
 */
public class SearchTest {

    @Test
    public void searchTest() {
        SearchRequest request = new SearchRequest.SearchRequestBuilder()
                .withSearchString("Canoga Park")
                .withCostToCompleteMinimum(0)
                .withCostToCompleteMaximum(2000)
                .withNumResults(5)
                .withSortingOptions(SortingOptions.URGENCY)
                .withState(CALIFORNIA)
                .build();

        SearchClient client = new SearchClient();
        Response response = client.search(request);
        System.out.println("Response: " +  response.readEntity(String.class));
    }
}
