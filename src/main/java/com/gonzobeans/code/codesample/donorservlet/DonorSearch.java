package com.gonzobeans.code.codesample.donorservlet;

import com.gonzobeans.code.codesample.donorapi.Proposal;
import com.gonzobeans.code.codesample.donorapi.SearchClient;
import com.gonzobeans.code.codesample.donorapi.SearchRequest;
import com.gonzobeans.code.codesample.donorapi.SortingOptions;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.gonzobeans.code.codesample.util.StateAbbreviations.CALIFORNIA;

/**
 * Created by Dave on 1/30/2017.
 */
public class DonorSearch extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String searchString = request.getParameter("search");
        SearchClient client = new SearchClient();

        SearchRequest searchRequest = new SearchRequest.SearchRequestBuilder()
                .withState(CALIFORNIA)
                .withCostToCompleteMinimum(0)
                .withCostToCompleteMaximum(2000)
                .withNumResults(5)
                .withSortingOptions(SortingOptions.URGENCY)
                .build();

        if (!StringUtils.isEmpty(searchString)) {
            searchRequest.setSearchString(searchString);
        }

        List<Proposal> proposalList = client.search(searchRequest).getProposals();

        PrintWriter writer = response.getWriter();

        proposalList.forEach(p -> writer.println("<div class=\"proposal\">" +
                "<b>Title: </b> " + p.getTitle() + "<br/>" +
                "<b>Description: </b>" + p.getShortDescription() + "<br/>" +
                "<b>URL: </b>" + p.getProposalURL() + "<br/>" +
                "<b>Percent Funded: </b>" + p.getPercentFunded() + "<br/>" +
                "<b>Cost to Complete: </b>" + p.getCostToComplete() + "<br/>" +
                "<b>Number of Students: " + p.getNumStudents() + "<br/>" +
                "<b>Number of Donors: " + p.getNumDonors() + "<br/>" +
                "<br/><br/>"));
    }

    public void destroy() {
        // do nothing.
    }
}
