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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getProposalURL() {
        return proposalURL;
    }

    public void setProposalURL(String proposalURL) {
        this.proposalURL = proposalURL;
    }

    public Float getPercentFunded() {
        return percentFunded;
    }

    public void setPercentFunded(Float percentFunded) {
        this.percentFunded = percentFunded;
    }

    public Integer getNumDonors() {
        return numDonors;
    }

    public void setNumDonors(Integer numDonors) {
        this.numDonors = numDonors;
    }

    public Float getCostToComplete() {
        return costToComplete;
    }

    public void setCostToComplete(Float costToComplete) {
        this.costToComplete = costToComplete;
    }

    public Integer getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(Integer numStudents) {
        this.numStudents = numStudents;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
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