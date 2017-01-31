package com.gonzobeans.codesample.donorapi;

import com.gonzobeans.codesample.util.Logging;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.gonzobeans.codesample.util.StateAbbreviations.CALIFORNIA;

/**
 * Created by Dave on 1/29/2017.
 */
public class SearchTest implements Logging {

    //TODO: Refactor tests with a data provider

    @Test
    public void searchTest() {
        //This demonstrates usage of the builder pattern ... it makes the code nice and neat
        SearchRequest request = new SearchRequest.SearchRequestBuilder()
                .withSearchString("student class")
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

    @Test
    public void NoSearchTerms() {
        SearchRequest request = new SearchRequest.SearchRequestBuilder()
                .withNumResults(5)
                .withSortingOptions(SortingOptions.URGENCY)
                .withState(CALIFORNIA)
                .build();


        SearchClient client = new SearchClient();
        List<Proposal> proposals = client.search(request).getProposals();
        Assert.assertEquals(proposals.size(), 5);
        proposals.forEach(p -> {
            LOG.info(p.toString());
        });
    }

    @Test
    public void ManyResults() {
        SearchRequest request = new SearchRequest.SearchRequestBuilder()
                .withNumResults(50)
                .withSortingOptions(SortingOptions.URGENCY)
                .build();

        SearchClient client = new SearchClient();
        List<Proposal> proposals = client.search(request).getProposals();
        Assert.assertEquals(proposals.size(), 50);
        proposals.forEach(p -> {
            LOG.info(p.toString());
        });
    }
}
