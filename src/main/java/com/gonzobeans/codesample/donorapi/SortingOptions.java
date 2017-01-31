package com.gonzobeans.codesample.donorapi;

/**
 * Created by Dave on 1/29/2017.
 * Request documentation located at: https://data.donorschoose.org/docs/project-listing/json-requests/
 */
public enum SortingOptions {
    URGENCY(0),
    POVERTY(1),
    COST(2),
    POPULARITY(4),
    EXPIRATION(5),
    NEWEST(7);

    private int sortBy;

    SortingOptions(int sortBy) {
        this.sortBy = sortBy;
    }

    public int getSortByValue() {
        return this.sortBy;
    }
}
