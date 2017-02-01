package com.gonzobeans.codesample.donorapi;

import com.gonzobeans.codesample.util.ApplicationConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dave on 1/29/2017.
 * Request documentation located at: https://data.donorschoose.org/docs/project-listing/json-requests/
 */
public class SearchRequest {
    // TODO: supply apiKey by injection
    private final String apiKey;
    private String searchString;
    private String state;
    private Integer index;
    private Integer numResults;
    private Integer costToCompleteMinimum;
    private Integer costToCompleteMaximum;
    private SortingOptions sortingOptions;

    SearchRequest() {
        this.apiKey = ApplicationConstants.API_KEY;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    void setState(String state) {
        this.state = state;
    }

    void setIndex(Integer index) {
        this.index = index;
    }

    void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    void setCostToCompleteMinimum(Integer costToCompleteMinimum) {
        this.costToCompleteMinimum = costToCompleteMinimum;
    }

    void setCostToCompleteMaximum(Integer costToCompleteMaximum) {
        this.costToCompleteMaximum = costToCompleteMaximum;
    }

    void setSortingOptions(SortingOptions sortingOptions) {
        this.sortingOptions = sortingOptions;
    }

    public Map<String, Object> getQueryParameters() {
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("APIKey", apiKey);
        queryParameters.put("index", index);
        queryParameters.put("max", numResults);
        queryParameters.put("keywords", searchString);
        queryParameters.put("state", state);
        queryParameters.put("sortBy", (sortingOptions != null) ? sortingOptions.getSortByValue() : null);
        queryParameters.put("costToCompleteRange",
                (costToCompleteMinimum != null || costToCompleteMaximum != null) ? String.format("%d TO %d",
                        (costToCompleteMinimum == null) ? 0 : costToCompleteMinimum,
                        (costToCompleteMaximum) == null ? Integer.MAX_VALUE : costToCompleteMaximum)
                        : null);
        return queryParameters;
    }

    public static class SearchRequestBuilder {
        private String searchString;
        private String state;
        private Integer index;
        private Integer numResults;
        private Integer costToCompleteMinimum;
        private Integer costToCompleteMaximum;
        private SortingOptions sortingOptions;

        public SearchRequestBuilder withSearchString(String searchString){
            this.searchString = searchString;
            return this;
        }

        public SearchRequestBuilder withState(String state){
            this.state = state;
            return this;
        }

        public SearchRequestBuilder withIndex(int index) {
            this.index = index;
            return this;
        }

        public SearchRequestBuilder withNumResults(int numResults) {
            this.numResults = numResults;
            return this;
        }

        public SearchRequestBuilder withCostToCompleteMinimum(int costToCompleteMinimum) {
            this.costToCompleteMinimum = costToCompleteMinimum;
            return this;
        }

        public SearchRequestBuilder withCostToCompleteMaximum(int costToCompleteMaximum) {
            this.costToCompleteMaximum = costToCompleteMaximum;
            return this;
        }

        public SearchRequestBuilder withSortingOptions(SortingOptions sortingOptions) {
            this.sortingOptions = sortingOptions;
            return this;
        }

        public SearchRequest build() {
            SearchRequest request = new SearchRequest();
            request.setSearchString(searchString);
            request.setState(state);
            request.setIndex(index);
            request.setNumResults(numResults);
            request.setCostToCompleteMinimum(costToCompleteMinimum);
            request.setCostToCompleteMaximum(costToCompleteMaximum);
            request.setSortingOptions(sortingOptions);
            return request;
        }

    }
}

