package com.gonzobeans.code.codesample.donorapi;

import com.gonzobeans.code.codesample.util.Logging;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;


import java.util.List;

import static com.gonzobeans.code.codesample.util.StateAbbreviations.CALIFORNIA;

/**
 * Created by Dave on 1/29/2017.
 */
public class SearchTest implements Logging{

    @Test
    public void searchTest() {
        SearchRequest request = new SearchRequest.SearchRequestBuilder()
                .withCostToCompleteMinimum(0)
                .withCostToCompleteMaximum(2000)
                .withNumResults(5)
                .withSortingOptions(SortingOptions.URGENCY)
                .withState(CALIFORNIA)
                .build();

        SearchClient client = new SearchClient();
        List<Proposal> proposals = client.search(request).getProposals();
        Assert.assertEquals(proposals.size(), 5);
        proposals.forEach(p -> {
            Assert.assertTrue(p.getTotalPrice() <= 2000);
            // Skipping State Assertion because state was not one of the requested data return types
            LOG.info(p.toString());
        });
    }
}
