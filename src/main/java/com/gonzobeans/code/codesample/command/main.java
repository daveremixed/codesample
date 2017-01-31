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

        Double funded = 0.0;
        Double costToComplete = 0.0;
        Double numStudents = 0.0;
        Double numDonors = 0.0;
        Double totalCost = 0.0;

        for (Proposal p : proposalList) {
            funded += p.getPercentFunded();
            costToComplete += p.getCostToComplete();
            numStudents += p.getNumStudents();
            numDonors += p.getNumDonors();
            totalCost += p.getTotalPrice();

            System.out.println("Title: " + p.getTitle() + "\n" +
                    "Description: " + p.getShortDescription() + "\n" +
                    "URL: " + p.getProposalURL() + "\n" +
                    "Cost to Complete:  $" + p.getCostToComplete() + "\n");
        }

        printAverage("PercentFunded", funded, proposalList.size());
        printAverage("Cost to Complete", costToComplete, proposalList.size());
        printAverage("Number of Students", numStudents, proposalList.size());
        printAverage("Number of Donors", numDonors, proposalList.size());
        printAverage("Total Cost", totalCost, proposalList.size());
    }

    private static void printAverage(String name, Double elementTotal, int numElements) {
        String dollarSign = "";
        if (name.toLowerCase().contains("cost")) {
            dollarSign = "$";
        }
        System.out.println(String.format("Average %s: %s%3$,.2f", name, dollarSign, (elementTotal / numElements)));
    }

}

