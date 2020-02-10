package com.example.musictabs;

import java.util.List;

public class Results {
    int resultCount;
    List<Music> results;

    public Results(int resultCount, List<Music> results){
        this.resultCount = resultCount;
        this.results = results;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Music> getResults() {
        return results;
    }

    public void setResults(List<Music> results) {
        this.results = results;
    }
}
