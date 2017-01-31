package com.gonzobeans.codesample.donorapi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave on 1/29/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {
    private List<Proposal> proposals;

    public SearchResponse() {
        this.proposals = new ArrayList<>();
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }
}
