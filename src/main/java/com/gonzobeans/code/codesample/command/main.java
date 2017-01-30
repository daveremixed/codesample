package com.gonzobeans.code.codesample.command;

import com.gonzobeans.code.codesample.donorapi.Proposal;
import com.gonzobeans.code.codesample.donorapi.SearchClient;
import com.gonzobeans.code.codesample.donorapi.SearchRequest;
import com.gonzobeans.code.codesample.donorapi.SortingOptions;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.gonzobeans.code.codesample.util.StateAbbreviations.CALIFORNIA;

/**
 * Created by Dave on 1/30/2017.
 */
public class main {
    public static void main(String[] args) {
        String searchTerms = String.join(" ", args);

        SearchClient client = new SearchClient();

        SearchRequest searchRequest = new SearchRequest.SearchRequestBuilder()
                .withState(CALIFORNIA)
                .withCostToCompleteMinimum(0)
                .withCostToCompleteMaximum(2000)
                .withNumResults(5)
                .withSortingOptions(SortingOptions.URGENCY)
                .build();

        if (!StringUtils.isEmpty(searchTerms)) {
            searchRequest.setSearchString(searchTerms);
        }

        List<Proposal> proposalList = client.search(searchRequest).getProposals();

        proposalList.forEach(p -> System.out.println(
                "Title: " + p.getTitle() + "\n" +
                        "Description: " + p.getShortDescription() + "\n" +
                        "URL: " + p.getProposalURL() + "\n" +
                        "Percent Funded: " + p.getPercentFunded() + "\n" +
                        "Cost to Complete: " + p.getCostToComplete() + "\n" +
                        "Number of Students: " + p.getNumStudents() + "\n" +
                        "Number of Donors: " + p.getNumDonors() + "\n\n"));
    }

}

