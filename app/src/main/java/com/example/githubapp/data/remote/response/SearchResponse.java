package com.example.githubapp.data.remote.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<UserResponse> items;

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public List<UserResponse> getItems() {
        return items;
    }
}