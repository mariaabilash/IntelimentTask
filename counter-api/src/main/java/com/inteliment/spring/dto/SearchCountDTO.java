package com.inteliment.spring.dto;

import java.util.List;
import java.util.Map;

public class SearchCountDTO
{
    private List<Map<String, Integer>> counts;

    public List<Map<String, Integer>> getCounts()
    {
        return counts;
    }

    public void setCounts(List<Map<String, Integer>> counts)
    {
        this.counts = counts;
    }

}
