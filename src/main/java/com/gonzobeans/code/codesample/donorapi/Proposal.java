package com.gonzobeans.code.codesample.donorapi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Dave on 1/30/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proposal {
    private String title;
    private String shortDescription;
    private String proposalURL;
    private Float percentFunded;
    private Integer numDonors;
    private Float costToComplete;
    private Integer numStudents;
    private Float totalPrice;

    // For deserialization
    public Proposal() {

    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getProposalURL() {
        return proposalURL;
    }

    public Float getPercentFunded() {
        return percentFunded;
    }

    public Integer getNumDonors() {
        return numDonors;
    }

    public Float getCostToComplete() {
        return costToComplete;
    }

    public Integer getNumStudents() {
        return numStudents;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", proposalURL='" + proposalURL + '\'' +
                ", percentFunded='" + percentFunded + '\'' +
                ", numDonors=" + numDonors +
                ", costToComplete='" + costToComplete + '\'' +
                ", numStudents=" + numStudents +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}